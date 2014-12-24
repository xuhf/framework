package com.isharec.framework.security;

import org.apache.shiro.authc.UsernamePasswordToken;

public class FrameUsernamePasswordToken extends UsernamePasswordToken {
	private static final long serialVersionUID = 1L;

	private String captcha;

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public FrameUsernamePasswordToken() {
		super();
	}

	public FrameUsernamePasswordToken(String username, char[] password,
			boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}
}
