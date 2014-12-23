package com.isharec.framework.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

public class NoSessionFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		RequestWrapper requestWrapper = new RequestWrapper(
				(HttpServletRequest) request);

		ResponseWrapper responseWrapper = new ResponseWrapper(
				(HttpServletResponse) response);
		chain.doFilter(requestWrapper, responseWrapper);
		responseWrapper.flushBuffer();
	}

	/**
	 * 禁止生成JSESSIONID cookie.
	 */
	static class HttpSessionWrapper implements HttpSession {
		private Map<String, Object> data = new HashMap<String, Object>();
		private HttpServletRequestWrapper req;

		public HttpSessionWrapper(HttpServletRequestWrapper req) {
			this.req = req;
		}

		public long getCreationTime() {
			return 0;
		}

		public String getId() {
			return null;
		}

		public long getLastAccessedTime() {
			return 0;
		}

		public ServletContext getServletContext() {
			return req.getServletContext();
		}

		public void setMaxInactiveInterval(int interval) {
		}

		public int getMaxInactiveInterval() {
			return 0;
		}

		@SuppressWarnings("deprecation")
		public javax.servlet.http.HttpSessionContext getSessionContext() {
			return null;
		}

		public Object getAttribute(String name) {
			return data.get(name);
		}

		public Object getValue(String name) {
			return getAttribute(name);
		}

		public Enumeration<String> getAttributeNames() {
			return new Vector<String>(data.keySet()).elements();
		}

		public String[] getValueNames() {
			return data.keySet().toArray(new String[0]);
		}

		public void setAttribute(String name, Object value) {
			data.put(name, value);
		}

		public void putValue(String name, Object value) {
			setAttribute(name, value);
		}

		public void removeAttribute(String name) {
			data.remove(name);
		}

		public void removeValue(String name) {
			removeAttribute(name);
		}

		public void invalidate() {
			data.clear();
		}

		public boolean isNew() {
			return false;
		}

	}

	static class RequestWrapper extends HttpServletRequestWrapper {
		private HttpSessionWrapper session = new HttpSessionWrapper(this);

		public RequestWrapper(HttpServletRequest request) {
			super(request);
		}

		@Override
		public HttpSessionWrapper getSession() {
			return session;
		}

		@Override
		public HttpSessionWrapper getSession(boolean create) {
			return session;
		}
	}

	/**
	 * 覆盖encode*Url, 禁止通过urlrewrite加入jsessionid.
	 */
	static class ResponseWrapper extends HttpServletResponseWrapper {

		public ResponseWrapper(HttpServletResponse resp) throws IOException {
			super(resp);
		}

		@Override
		public String encodeRedirectUrl(String url) {
			return url;
		}

		@Override
		public String encodeRedirectURL(String url) {
			return url;
		}

		@Override
		public String encodeUrl(String url) {
			return url;
		}

		@Override
		public String encodeURL(String url) {
			return url;
		}

	}
}