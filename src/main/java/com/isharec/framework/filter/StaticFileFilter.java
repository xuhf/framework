package com.isharec.framework.filter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;
import com.google.common.io.Files;

public class StaticFileFilter implements Filter {
	private final static String DEFAULT_CONTENT_TYPE = "text/plain";
	private final static Map<String, String> mimeTypes = new HashMap<String, String>();
	private final static Pattern VERSIONABLE_FILE_PATTERN = Pattern
			.compile("^(.*)-(\\d+)\\.(\\w+)$");

	static {
		mimeTypes.put("txt", "text/plain");
		mimeTypes.put("html", "text/html");
		mimeTypes.put("css", "text/css");
		mimeTypes.put("js", "application/x-javascript");
		mimeTypes.put("gif", "image/gif");
		mimeTypes.put("png", "image/png");
		mimeTypes.put("jpg", "image/jpeg");
		mimeTypes.put("jpeg", "image/jpeg");
		mimeTypes.put("xml", "text/xml");

		mimeTypes.put("ico", "image/x-icon");
		mimeTypes.put("svg", "image/svg+xml");
	}

	private Pattern excludePattern = Pattern.compile("\\.jsp$");

	public void init(FilterConfig filterConfig) throws ServletException {
		String exclude = filterConfig.getInitParameter("exclude");
		if (!Strings.isNullOrEmpty(exclude)) {
			excludePattern = Pattern.compile(exclude);
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI();
		String realPath = req.getServletContext().getRealPath(path);
		if (realPath == null) {
			chain.doFilter(request, response);
			return;
		}

		File file = normalizeFile(new File(realPath));
		if (file.isFile() && file.exists() && !isExcluded(file)) {
			HttpServletResponse resp = (HttpServletResponse) response;

			long length = file.length();
			resp.setContentLength((int) length);
			String contentType = getContentType(file);
			resp.setContentType(contentType);

			Files.copy(file, response.getOutputStream());
			response.getOutputStream().flush();
		} else {
			chain.doFilter(request, response);
		}
	}

	private boolean isExcluded(File file) {
		String path = file.getPath();
		// WEB-INF下的文件不允许
		if (path.indexOf("/WEB-INF/") != -1) {
			return true;
		}
		if (excludePattern != null) {
			Matcher m = excludePattern.matcher(path);
			if (m.find()) {
				return true;
			}
		}

		return false;
	}

	private File normalizeFile(File file) {
		if (file.isFile()) {
			return file;
		}
		String name = file.getName();
		Matcher m = VERSIONABLE_FILE_PATTERN.matcher(name);
		if (m.find()) {
			name = m.group(1) + "." + m.group(3);
			return new File(file.getParent(), name);
		}
		return file;
	}

	private String getContentType(File file) {
		String name = file.getName();
		int idx = name.lastIndexOf(".");
		String suffix = "";
		if (idx != -1) {
			suffix = name.substring(idx + 1);
		}
		String contentType = mimeTypes.get(suffix);
		if (contentType == null) {
			contentType = DEFAULT_CONTENT_TYPE;
		}
		return contentType + "; charset=UTF-8";
	}

	public void destroy() {
	}

}
