package com.isharec.framework.controller;

import java.util.List;

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
import com.isharec.framework.entity.Menu;
import com.isharec.framework.entity.Role;
import com.isharec.framework.service.MenuService;
import com.isharec.framework.service.RoleService;

@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private MenuService menuService;

	@RequestMapping()
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/role/index");
		Page<Role> page = roleService.page(new Page<Role>(request, response));
		model.addObject("page", page);
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView new0() {
		ModelAndView model = new ModelAndView("/role/new");
		List<Menu> menuList = menuService.findAllMenu();
		Role role = new Role();
		model.addObject("role", role);
		model.addObject("menuList", menuList);
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Role role, RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/role");
		Role tmpRole = roleService.findRoleByName(role.getName());
		if (tmpRole != null) {
			model.setViewName("/role/new");
			model.addObject("role", role);
			addMessage(model, "保存角色失败，角色名称已经存在。");
			return model;
		}
		roleService.saveRole(role);
		addSuccessMessage(redirectAttributes, "保存角色 " + role.getName() + " 成功。");
		return model;
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.POST)
	public ModelAndView show(@PathVariable Long id) {
		ModelAndView model = new ModelAndView();
		List<Menu> menuList = menuService.findAllMenu();
		Role role = roleService.getRole(id);
		model.addObject("role", role);
		model.addObject("menuList", menuList);
		return model;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("/role/edit");
		Role role = roleService.getRole(id);
		model.addObject("role", role);
		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Role role, RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/role");
		Role tmpRole = roleService.getRole(role.getId());
		if (tmpRole == null) {
			addMessage(redirectAttributes, "修改角色失败，角色不存在。");
			return model;
		}
		roleService.saveRole(role);
		addSuccessMessage(redirectAttributes, "修改角色 " + role.getName() + " 成功。");
		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/role");
		Role role = roleService.getRole(id);
		if (role == null) {
			addMessage(redirectAttributes, "删除角色失败，角色不存在。");
			return model;
		}
		roleService.deleteRole(id);
		addSuccessMessage(redirectAttributes, "删除角色 " + role.getName() + " 成功。");
		return model;
	}
}
