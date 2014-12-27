package com.isharec.framework.base.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Maps;

public abstract class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 用于跳转回原页面存放消息
	 * 
	 * @param model
	 * @param message
	 */
	public void addMessage(ModelAndView model, String message) {
		Map<String, Object> messageMap = Maps.newHashMap();
		messageMap.put("success", false);
		messageMap.put("message", message);
		model.addObject("message", messageMap);
	}

	/**
	 * 失败消息
	 * 
	 * @param redirectAttributes
	 * @param message
	 */
	public void addMessage(RedirectAttributes redirectAttributes, String message) {
		Map<String, Object> messageMap = Maps.newHashMap();
		messageMap.put("success", false);
		messageMap.put("message", message);
		redirectAttributes.addFlashAttribute("message", messageMap);
	}

	/**
	 * 成功消息
	 * 
	 * @param redirectAttributes
	 * @param message
	 */
	public void addSuccessMessage(RedirectAttributes redirectAttributes,
			String message) {
		Map<String, Object> messageMap = Maps.newHashMap();
		messageMap.put("success", true);
		messageMap.put("message", message);
		redirectAttributes.addFlashAttribute("message", messageMap);
	}

	/**
	 * 失败消息
	 * 
	 * @param redirectAttributes
	 * @param message
	 */
	public void addFailedMessage(RedirectAttributes redirectAttributes,
			String message) {
		Map<String, Object> messageMap = Maps.newHashMap();
		messageMap.put("success", false);
		messageMap.put("message", message);
		redirectAttributes.addFlashAttribute("message", messageMap);
	}
}
