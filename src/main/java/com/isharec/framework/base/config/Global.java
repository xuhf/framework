package com.isharec.framework.base.config;

import java.util.Map;

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

}
