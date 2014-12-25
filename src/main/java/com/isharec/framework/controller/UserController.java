package com.isharec.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.isharec.framework.base.persistence.Page;
import com.isharec.framework.base.web.BaseController;
import com.isharec.framework.entity.User;
import com.isharec.framework.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@ModelAttribute
	public User init() {
		return new User();
	}

	@RequestMapping()
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/user/index");
		Page<User> page = userService.page(new Page<User>(request, response));
		model.addObject("page", page);
		return model;
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public ModelAndView new0() {
		ModelAndView model = new ModelAndView("/user/new");
		return model;
	}
}
