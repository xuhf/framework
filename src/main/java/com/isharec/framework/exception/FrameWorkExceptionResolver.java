package com.isharec.framework.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.isharec.framework.entity.User;
import com.isharec.framework.utils.UserUtils;

public class FrameWorkExceptionResolver implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		User user = UserUtils.getUser();
		ModelAndView model = new ModelAndView("/exception");
		if (user.getId() != null) {
			model.addObject("sysMenuList", UserUtils.getMenuList());
		}
		return model;
	}

}
