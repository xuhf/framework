package com.isharec.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.isharec.framework.base.persistence.Page;
import com.isharec.framework.base.web.BaseController;
import com.isharec.framework.entity.DictHeader;
import com.isharec.framework.service.DictService;

@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {

	@Autowired
	private DictService dictService;

	@RequestMapping()
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/dict/index");
		Page<DictHeader> page = dictService.page(new Page<DictHeader>(request,
				response));
		model.addObject("page", page);
		return model;
	}

	public ModelAndView new0() {
		ModelAndView model = new ModelAndView();
		
		return model;
	}
}
