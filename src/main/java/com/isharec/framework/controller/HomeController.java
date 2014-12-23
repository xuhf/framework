package com.isharec.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping()
public class HomeController {

	@RequestMapping()
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("/index");
		return model;
	}
}
