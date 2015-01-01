package com.isharec.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.isharec.framework.base.web.BaseController;

@Controller
@RequestMapping()
public class HomeController extends BaseController {

	@RequestMapping()
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("/index");
		return model;
	}
}
