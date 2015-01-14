package com.isharec.framework.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.google.common.base.Strings;
import com.isharec.framework.entity.DictHeader;
import com.isharec.framework.entity.DictItem;
import com.isharec.framework.service.DictService;
import com.isharec.framework.utils.SpringContextHolder;

public class DictOptionsTag extends SimpleTagSupport {

	private String header;
	private String defaultSelect;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDefaultSelect() {
		return defaultSelect;
	}

	public void setDefaultSelect(String defaultSelect) {
		this.defaultSelect = defaultSelect;
	}

	public void doTag() throws JspException {
		DictService dictService = SpringContextHolder
				.getBean(DictService.class);
		DictHeader dictHeader = dictService.findDictHeaderByValue(header);
		List<DictItem> items = dictHeader.getItems();
		StringBuilder sb = new StringBuilder();
		for (DictItem item : items) {
			if (Strings.isNullOrEmpty(defaultSelect)) {
				sb.append("<option ").append(
						" value='" + item.getValue() + "'>");
			} else {
				if (defaultSelect.equals(item.getValue())) {
					sb.append("<option ").append(
							" value='" + item.getValue()
									+ "' selected='selected'>");
				} else {
					sb.append("<option ").append(
							" value='" + item.getValue() + "'>");
				}
			}
			sb.append(item.getName());
			sb.append("</option>");
		}
		JspWriter out = getJspContext().getOut();
		try {
			out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
