package com.isharec.framework.base.config;

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.isharec.framework.utils.PropertiesLoader;

public class Global {

	private static final Map<String, String> map = Maps.newHashMap();

	private static PropertiesLoader propertiesLoader = new PropertiesLoader(
			"config.properties");

	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null) {
			value = propertiesLoader.getProperty(key);
			map.put(key, value);
		}
		return value;
	}

	/**
	 * 获得页面大小，默认为20
	 * 
	 * @return
	 */
	public static Integer getPageSize() {
		String pageSizeStr = getConfig("page.pageSize");
		if (Strings.isNullOrEmpty(pageSizeStr)) {
			return 20;
		}
		return Integer.parseInt(pageSizeStr);
	}
}
