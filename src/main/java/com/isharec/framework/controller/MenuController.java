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
import com.isharec.framework.entity.Menu;
import com.isharec.framework.service.MenuService;
import com.isharec.framework.utils.UserUtils;

@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService;

	@RequestMapping()
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("/menu/index");
		List<Menu> list = Lists.newArrayList();
		List<Menu> sourcelist = menuService.findAllMenu();
		Menu.sortList(list, sourcelist);
		model.addObject("list", list);
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView new0() {
		ModelAndView model = new ModelAndView("/menu/new");
		Menu menu = new Menu();
		List<Menu> menuList = UserUtils.getMenuList();
		model.addObject("menuList", menuList);
		model.addObject("menu", menu);
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(Menu menu, RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/menu");
		if (menu.getParent() == null || menu.getParent().getId() == 0) {
			menu.setParent(new Menu(0L));
		}
		menuService.saveMenu(menu);
		addSuccessMessage(redirectAttributes, "添加菜单 " + menu.getName() + " 成功。");
		return model;
	}

	@RequestMapping(value = "sort", method = RequestMethod.POST)
	public ModelAndView sortMenu(int[] ids, Integer[] sorts,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/menu");
		int len = ids.length;
		Menu[] menus = new Menu[len];
		for (int i = 0; i < len; i++) {
			menus[i] = menuService.getMenu((long) ids[i]);
			menus[i].setSort(sorts[i]);
			menuService.saveMenu(menus[i]);
		}
		addSuccessMessage(redirectAttributes, "保存菜单排序成功!");
		return model;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("/menu/edit");
		Menu menu = menuService.getMenu(id);
		model.addObject("menu", menu);
		model.addObject("menuList", UserUtils.getMenuList());
		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(Menu menu, RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/menu");
		if (menu.getParent() == null || menu.getParent().getId() == 0) {
			menu.setParent(new Menu(0L));
		}
		menuService.saveMenu(menu);
		addSuccessMessage(redirectAttributes, "修改菜单 " + menu.getName() + " 成功。");
		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/menu");
		Menu menu = menuService.getMenu(id);
		if (menu == null) {
			addMessage(redirectAttributes, "删除菜单失败，菜单不存在。");
			return model;
		}
		menuService.deleteMenu(id);
		addSuccessMessage(redirectAttributes, "删除菜单 " + menu.getName() + " 成功");
		return model;
	}

	@RequestMapping(value = "/parent/{parentId}", method = RequestMethod.GET)
	public ModelAndView parent(@PathVariable Long parentId,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("/menu/new");
		Menu menu = new Menu();
		Menu parentMenu = menuService.getMenu(parentId);
		if (parentMenu == null) {
			model.setViewName("redirect:/menu");
			addMessage(redirectAttributes, "增加下级菜单失败，菜单不存在。");
			return model;
		}
		menu.setParent(parentMenu);
		List<Menu> menuList = UserUtils.getMenuList();
		model.addObject("menuList", menuList);
		model.addObject("menu", menu);
		return model;
	}
}
