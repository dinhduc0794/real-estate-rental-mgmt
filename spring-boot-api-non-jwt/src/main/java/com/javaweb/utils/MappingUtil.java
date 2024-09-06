package com.javaweb.utils;

import java.util.Map;

public class MappingUtil {
	public static <T> T getObject(Map<String, Object> params, String key, Class<T> tClass) {
		Object value = params.getOrDefault(key, null);
		if (value != null) {
			if (tClass.getTypeName().equals("java.lang.Long")) {
				value = value != "" ? Long.valueOf(value.toString()) : null; 
			}
			else if (tClass.getTypeName().equals("java.lang.Integer")) {
				value = value != "" ? Integer.valueOf(value.toString()) : null;
			}
			else if (tClass.getTypeName().equals("java.lang.String")) {
				value = value != "" ? value.toString() : null;
			}
			return tClass.cast(value);
		}
		
		return null;
	}
}
