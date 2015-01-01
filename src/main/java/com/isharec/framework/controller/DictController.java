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
import com.isharec.framework.entity.DictHeader;
import com.isharec.framework.entity.DictItem;
import com.isharec.framework.service.DictService;

@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {

	@Autowired
	private DictService dictService;

	/***** 数据字典头部部分 *****/
	@RequestMapping()
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/dict/index");
		Page<DictHeader> page = dictService.page(new Page<DictHeader>(request,
				response));
		model.addObject("page", page);
		return model;
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public ModelAndView new0() {
		ModelAndView model = new ModelAndView("/dict/new");
		DictHeader dictHeader = new DictHeader();
		model.addObject("dictHeader", dictHeader);
		return model;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(DictHeader dictHeader,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/dict");
		// value 值不能一样，名称可以一样
		DictHeader dh = dictService
				.findDictHeaderByValue(dictHeader.getValue());
		if (dh != null) {
			model.setViewName("/dict/new");
			model.addObject("dictHeader", dictHeader);
			addMessage(model, "保存数据字典失败，字典值已经存在。");
			return model;
		}
		dictService.saveDictHeader(dictHeader);
		addSuccessMessage(redirectAttributes, "保存数据字典　" + dictHeader.getName()
				+ " 成功。");
		return model;
	}

	@RequestMapping(value = "show/{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("/dict/show");
		DictHeader dictHeader = dictService.getDictHeader(id);
		if (dictHeader == null) {
			model.setViewName("redirect:/dict");
			addMessage(redirectAttributes, "查看数据字典失败，数据字典不存在。");
			return model;
		}
		model.addObject("dictHeader", dictHeader);
		return model;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("/dict/edit");
		DictHeader dictHeader = dictService.getDictHeader(id);
		if (dictHeader == null) {
			model.setViewName("redirect:/dict");
			addMessage(redirectAttributes, "修改数据字典失败，数据字典不存在。");
			return model;
		}
		model.addObject("dictHeader", dictHeader);
		return model;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(DictHeader dictHeader,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/dict");
		DictHeader dh = dictService.getDictHeader(dictHeader.getId());
		if (dh == null) {
			addMessage(redirectAttributes, "修改数据字典失败，数据字典不存在。");
			return model;
		}
		// 查看数据字典值,这个值应该是不可以改变的
		dh.setName(dictHeader.getName());
		dictService.saveDictHeader(dh);
		addSuccessMessage(redirectAttributes, "保存数据字典 " + dh.getName() + " 成功");
		return model;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/dict");
		DictHeader dictHeader = dictService.getDictHeader(id);
		if (dictHeader == null) {
			addMessage(redirectAttributes, "删除数据字典失败，数据字典不存在。");
			return model;
		}
		addSuccessMessage(redirectAttributes, "删除数据字典 " + dictHeader.getName()
				+ " 成功");
		dictService.deleteDictHeader(dictHeader);
		return model;
	}

	/***** 数据字典条目部分 *****/
	@RequestMapping(value = "{id}/item/new", method = RequestMethod.GET)
	public ModelAndView newItem(@PathVariable("id") Long dictHeaderId) {
		ModelAndView model = new ModelAndView("/dict/item/new");
		DictHeader dictHeader = dictService.getDictHeader(dictHeaderId);
		DictItem dictItem = new DictItem();
		dictItem.setDictHeader(dictHeader);
		model.addObject("dictItem", dictItem);
		return model;
	}

	@RequestMapping(value = "item/save", method = RequestMethod.POST)
	public ModelAndView saveItem(DictItem dictItem,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/dict/show/"
				+ dictItem.getDictHeader().getId());
		// 查看这个 header value下是否有相同的条目value
		DictHeader dictHeader = dictService.getDictHeader(dictItem
				.getDictHeader().getId());
		DictItem di = dictService.getDictItem(dictHeader, dictItem.getValue());
		if (di != null) {
			model.setViewName("/dict/item/new");
			model.addObject("dictItem", dictItem);
			addMessage(model, "保存数据字典条目失败，该数据字典下存在相同编码的条目。");
			return model;
		}
		dictItem.setDictHeader(dictHeader);
		dictService.saveDictItem(dictItem);
		addSuccessMessage(redirectAttributes, "保存数据字典条目 " + dictItem.getName()
				+ " 成功。");
		return model;
	}

	@RequestMapping(value = "item/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editItem(@PathVariable("id") Long dictItemId,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("/dict/item/edit");
		DictItem dictItem = dictService.getDictItem(dictItemId);
		model.addObject("dictItem", dictItem);
		return model;
	}

	@RequestMapping(value = "item/update", method = RequestMethod.POST)
	public ModelAndView updateItem(DictItem dictItem,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView("redirect:/dict/show/"
				+ dictItem.getDictHeader().getId());
		DictHeader dictHeader = dictService.getDictHeader(dictItem
				.getDictHeader().getId());
		DictItem di = dictService.getDictItem(dictItem.getId());
		if (di == null) {
			addMessage(redirectAttributes, "修改数据字典条目失败，数据字典条目不存在。");
			return model;
		}
		dictItem.setDictHeader(dictHeader);
		di.setName(dictItem.getName());
		dictService.saveDictItem(di);
		addSuccessMessage(redirectAttributes, "保存数据字典条目 " + di.getName()
				+ " 成功。");
		return model;
	}

	@RequestMapping(value = "item/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteItem(@PathVariable("id") Long dictItemId,
			RedirectAttributes redirectAttributes) {
		ModelAndView model = new ModelAndView();
		DictItem dictItem = dictService.getDictItem(dictItemId);
		if (dictItem == null) {
			model.setViewName("redirect:/dict");
			addMessage(redirectAttributes, "删除数据字典条目失败，数据字典条目不存在。");
			return model;
		}
		model.setViewName("redirect:/dict/show/"
				+ dictItem.getDictHeader().getId());
		dictService.deleteDictItem(dictItem);
		addSuccessMessage(redirectAttributes, "删除数据字典条目 " + dictItem.getName()
				+ " 成功。");
		return model;
	}
}
