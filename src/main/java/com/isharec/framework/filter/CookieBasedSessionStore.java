package com.isharec.framework.filter;

import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.FlashMap;

import com.google.common.base.Charsets;

public class CookieBasedSessionStore {

	@SuppressWarnings("serial")
	public static class CodecException extends RuntimeException {

		public CodecException(Throwable cause) {
			super(cause);
		}
	}

	public static class Codec {
		private final byte[] secret;
		private final byte[] mask;
		private final Charset encoding;

		public Codec(byte[] secret) {
			this(secret, secret, Charsets.UTF_8);
		}

		public Codec(byte[] secret, byte[] mask, Charset encoding) {
			if (secret == null || mask == null) {
				throw new IllegalArgumentException();
			}
			this.secret = secret;
			this.mask = mask;
			this.encoding = encoding;
		}

		public String encode(Map<String, Object> data, boolean ignoreSign) {
			String value = serialize(data);

			if (!ignoreSign) {
				String sign = doSign(value);
				value = sign + "--" + value;
			}
			byte[] result = doMask(value.getBytes(encoding));

			return Base64.encodeBase64String(result);
		}

		public Map<String, Object> decode(String value, boolean ignoreSign) {
			try {
				byte[] data = Base64.decodeBase64(value.getBytes(encoding));
				data = doMask(data);

				String s = new String(data, encoding);
				if (ignoreSign) {
					return unserialize(s);
				} else {
					String[] parts = s.split("--", 2);
					if (parts.length != 2) {
						return new HashMap<String, Object>();
					}

					String sign = parts[0];
					String content = parts[1];
					if (sign.equals(doSign(content))) {
						return unserialize(content);
					}
				}
				return new HashMap<String, Object>();
			} catch (Exception e) {
				return new HashMap<String, Object>();
			}
		}

		private byte[] doMask(byte[] input) {
			byte[] result = new byte[input.length];
			int j = 0;
			for (int i = 0; i < input.length; i++) {
				byte b = input[i];
				result[i] = (byte) (b ^ mask[j]);
				j = (j + 1) % mask.length;
			}
			return result;
		}

		private String doSign(String value) {
			try {
				Mac mac = Mac.getInstance("HmacSHA256");
				SecretKeySpec secretKey = new SecretKeySpec(secret,
						"HmacSHA256");
				mac.init(secretKey);
				return Base64.encodeBase64String(mac.doFinal(value
						.getBytes(encoding)));
			} catch (Exception e) {
				throw new CodecException(e);
			}
		}

		private String serialize(Map<String, Object> data) {
			try {
				StringWriter writer = new StringWriter();
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(writer, data);
				return writer.toString();
			} catch (Exception e) {
				throw new CodecException(e);
			}
		}

		@SuppressWarnings("unchecked")
		private Map<String, Object> unserialize(String value) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.readValue(value, HashMap.class);
			} catch (Exception e) {
				throw new CodecException(e);
			}
		}
	}

	private byte[] secret;

	private String sessionKey;
	private String cookiePath;
	private boolean httpOnly;
	private String domain;

	private boolean permanent;
	private boolean ignoreSign;

	public void setSecret(byte[] secret) {
		this.secret = secret;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public void setCookiePath(String cookiePath) {
		this.cookiePath = cookiePath;
	}

	public void setHttpOnly(boolean httpOnly) {
		this.httpOnly = httpOnly;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public void setIgnoreSign(boolean ignoreSign) {
		this.ignoreSign = ignoreSign;
	}

	public void restore(HttpServletRequest req) {
		req.getSession().invalidate();

		Cookie c = findCookie(req);
		if (c == null) {
			return;
		}

		Codec codec = new Codec(secret);
		Map<String, Object> data = codec.decode(c.getValue(), ignoreSign);
		String flashKey = "org.springframework.web.servlet.support.SessionFlashMapManager.FLASH_MAPS";
		if (data.containsKey(flashKey)) {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> list = (List<Map<String, Object>>) data
					.get(flashKey);
			List<FlashMap> flashMaps = new ArrayList<FlashMap>();
			for (Map<String, Object> map : list) {
				FlashMap flashMap = new FlashMap();
				flashMap.putAll(map);
				flashMaps.add(flashMap);
			}
			data.put(flashKey, flashMaps);
		}
		HttpSession session = req.getSession();
		for (Map.Entry<String, Object> entry : data.entrySet()) {
			session.setAttribute(entry.getKey(), entry.getValue());
		}
	}

	private Cookie findCookie(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies == null) {
			return null;
		}

		for (Cookie c : cookies) {
			if (sessionKey.equals(c.getName())) {
				return c;
			}
		}
		return null;
	}

	private void addCookie(HttpServletRequest req, HttpServletResponse resp,
			Cookie cookie) {
		if (cookiePath != null) {
			cookie.setPath(cookiePath);
		} else {
			String path = req.getContextPath();
			if ("".equals(path)) {
				path = "/";
			}
			cookie.setPath(path);
		}
		cookie.setHttpOnly(httpOnly);
		if (domain != null) {
			cookie.setDomain(domain);
		}
		resp.addCookie(cookie);
	}

	public void generate(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession(true);
		Map<String, Object> data = new HashMap<String, Object>();
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			Object value = session.getAttribute(name);
			data.put(name, value);
		}

		Codec codec = new Codec(secret);
		String cookieValue = codec.encode(data, ignoreSign);
		Cookie cookie = new Cookie(sessionKey, cookieValue);

		if (permanent) {
			cookie.setMaxAge(10 * 360 * 24 * 3600);
		} else {
			cookie.setMaxAge(-1);
		}
		addCookie(req, resp, cookie);

		session.invalidate();
	}

	public static void main(String[] args) throws Exception {
		byte[] secret = "1234klsf9rieiowrjjsdf".getBytes();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("uid", 1);
		data.put("message", "hello, world!");
		data.put("updated", new Date());

		Codec codec = new Codec(secret);

		for (boolean ignoreSign : new boolean[] { true, false }) {
			String result = codec.encode(data, ignoreSign);
			System.out.println("encoded result: " + result + ", ignoreSign: "
					+ ignoreSign);

			Map<String, Object> decoded = codec.decode(result, ignoreSign);
			System.out.println(decoded);
		}
	}

}
