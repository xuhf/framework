package com.isharec.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isharec.framework.base.persistence.Page;
import com.isharec.framework.base.web.BaseController;
import com.isharec.framework.entity.User;
import com.isharec.framework.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

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
		User user = new User();
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(User user, RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView();
		User u = userService.getUserByLoginName(user.getLoginName());
		if (u != null) {
			addMessage(model, "保存用户失败，用户名已经存在。");
			model.addObject("user", user);
			model.setViewName("/user/new");
			return model;
		}
		// TODO
		// 这是不是要判断重复密码应该和密码一样
		user.setPassword(UserService.entryptPassword(user.getPassword()));
		userService.saveUser(user);
		addSuccessMessage(redirectAttributes, "保存用户 " + user.getLoginName()
				+ " 成功");
		model.setViewName("redirect:/user");
		return model;
	}
}
