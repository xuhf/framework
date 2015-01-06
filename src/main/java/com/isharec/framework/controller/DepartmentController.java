package com.isharec.framework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.isharec.framework.base.web.BaseController;
import com.isharec.framework.entity.Department;
import com.isharec.framework.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController extends BaseController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping()
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("/department/index");
		List<Department> list = Lists.newArrayList();
		List<Department> sourcelist = departmentService.findAllDepartment();
		Department.sortList(list, sourcelist);
		model.addObject("list", list);
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView new0() {
		ModelAndView model = new ModelAndView("/department/new");
		Department department = new Department();
		List<Department> departmentList = departmentService.findAllDepartment();
		model.addObject("departmentList", departmentList);
		model.addObject("department", department);
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Department department,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/department");
		if (department.getParent() == null
				|| department.getParent().getId() == 0) {
			department.setParent(new Department(0L));
		}
		departmentService.saveDepartment(department);
		addSuccessMessage(redirectAttributes, "添加部门 " + department.getName()
				+ " 成功。");
		return model;
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("/department/show");
		Department department = departmentService.getDepartment(id);
		model.addObject("department", department);
		return model;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("/department/edit");
		Department department = departmentService.getDepartment(id);
		model.addObject("department", department);
		model.addObject("departmentList", departmentService.findAllDepartment());
		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Department department,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/department");
		if (department.getParent() == null
				|| department.getParent().getId() == 0) {
			department.setParent(new Department(0L));
		}
		departmentService.saveDepartment(department);
		addSuccessMessage(redirectAttributes, "修改部门 " + department.getName()
				+ " 成功。");
		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/department");
		Department department = departmentService.getDepartment(id);
		if (department == null) {
			addMessage(redirectAttributes, "删除部门失败，部门不存在。");
			return model;
		}
		departmentService.deleteDepartment(id);
		addSuccessMessage(redirectAttributes, "删除部门 " + department.getName()
				+ " 成功");
		return model;
	}

	@RequestMapping(value = "/parent/{parentId}", method = RequestMethod.GET)
	public ModelAndView parent(@PathVariable Long parentId,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("/department/new");
		Department department = new Department();
		Department parentDepartment = departmentService.getDepartment(parentId);
		if (parentDepartment == null) {
			model.setViewName("redirect:/department");
			addMessage(redirectAttributes, "增加下级部门失败，部门不存在。");
			return model;
		}
		department.setParent(parentDepartment);
		List<Department> departmentList = departmentService.findAllDepartment();
		model.addObject("departmentList", departmentList);
		model.addObject("department", department);
		return model;
	}

}
