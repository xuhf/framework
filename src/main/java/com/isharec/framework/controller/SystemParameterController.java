package com.isharec.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.isharec.framework.base.persistence.Page;
import com.isharec.framework.base.web.BaseController;
import com.isharec.framework.entity.SystemParameter;
import com.isharec.framework.service.SystemParameterService;

@Controller
@RequestMapping("/parameter")
public class SystemParameterController extends BaseController {

	@Autowired
	private SystemParameterService systemParameterService;

	@RequestMapping()
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/parameter/index");
		Page<SystemParameter> page = systemParameterService
				.page(new Page<SystemParameter>(request, response));
		model.addObject("page", page);
		return model;
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public ModelAndView new0() {
		ModelAndView model = new ModelAndView("/parameter/new");
		SystemParameter systemParameter = new SystemParameter();
		model.addObject("systemParameter", systemParameter);
		return model;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(SystemParameter systemParameter,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/parameter");
		systemParameterService.saveSystemParameter(systemParameter);
		addSuccessMessage(redirectAttributes,
				"添加系统参数项 " + systemParameter.getName() + " 成功。");
		return model;
	}

	@RequestMapping(value = "show/{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("/parameter/show");
		SystemParameter systemParameter = systemParameterService
				.getSystemParameter(id);
		if (systemParameter == null) {
			model.setViewName("redirect:/parameter");
			addMessage(model, "查看系统参数项失败，系统参数项不存在");
			return model;
		}
		model.addObject("systemParameter", systemParameter);
		return model;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("/parameter/edit");
		SystemParameter systemParameter = systemParameterService
				.getSystemParameter(id);
		if (systemParameter == null) {
			model.setViewName("redirect:/parameter");
			addMessage(redirectAttributes, "修改系统参数项失败，系统参数项不存在。");
			return model;
		}
		model.addObject("systemParameter", systemParameter);
		return model;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(SystemParameter systemParameter,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/parameter");
		SystemParameter sp = systemParameterService
				.getSystemParameter(systemParameter.getId());
		sp.setName(systemParameter.getName());
		sp.setCode(systemParameter.getCode());
		sp.setValue(systemParameter.getValue());
		sp.setRemarks(systemParameter.getRemarks());
		systemParameterService.saveSystemParameter(sp);
		addSuccessMessage(redirectAttributes, "修改系统参数项 " + sp.getName()
				+ " 成功。");
		return model;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/parameter");
		SystemParameter systemParameter = systemParameterService
				.getSystemParameter(id);
		if (systemParameter == null) {
			addMessage(redirectAttributes, "删除系统参数项失败，系统参数项不存在。");
			return model;
		}
		systemParameterService.deleteSystemParameter(id);
		addSuccessMessage(redirectAttributes,
				"删除系统参数项 " + systemParameter.getName() + " 成功。");
		return model;
	}
}
