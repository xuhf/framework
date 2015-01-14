package com.isharec.framework.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.isharec.framework.entity.DictHeader;
import com.isharec.framework.entity.DictItem;
import com.isharec.framework.service.DictService;
import com.isharec.framework.utils.SpringContextHolder;

public class DictItemTag extends SimpleTagSupport {

	private String header;
	private String item;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void doTag() throws JspException {
		JspWriter out = getJspContext().getOut();
		DictService dictService = SpringContextHolder
				.getBean(DictService.class);
		DictHeader dictHeader = dictService.findDictHeaderByValue(header);
		DictItem dictItem = dictService.getDictItem(dictHeader, item);
		try {
			if (dictItem == null) {
				out.println("数据字典值不存在。");
			} else {
				out.println(dictItem.getName());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
