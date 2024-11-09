package com.javaweb.utils;

import java.util.Map;

public class MappingUtils {
	public static <T> T getObject(Object item, Class<T> tClass) {
		if(item != null) {
			String valueString = item.toString().trim();  // Loai bo khoang trang truoc khi chuyen qua kieu du lieu so de tranh loi NumberFormatException
			if(tClass.getTypeName().equals("java.lang.Long")) {
				item = item != "" ? Long.valueOf(valueString) : null;
			}
			else if(tClass.getTypeName().equals("java.lang.Integer")) {
				item = item != "" ? Integer.valueOf(valueString) : null;
			}
			else if(tClass.getTypeName().equals("java.lang.String")) {
				item = !valueString.isEmpty() ? valueString : null;
			}
			return tClass.cast(item);
		}
		return null;
	}

	public static <T> T getObject(Map<String, Object> params, String key, Class<T> tClass) {
		Object value = params.getOrDefault(key, null);
		if (value != null) {
			String valueString = value.toString().trim();  // Loai bo khoang trang truoc khi chuyen qua kieu du lieu so de tranh loi NumberFormatException
			if (tClass.getTypeName().equals("java.lang.Long")) {
				value = !valueString.isEmpty() ? Long.valueOf(valueString) : null;
			}
			else if (tClass.getTypeName().equals("java.lang.Integer")) {
				value = !valueString.isEmpty() ? Integer.valueOf(valueString) : null;
			}
			else if (tClass.getTypeName().equals("java.lang.String")) {
				value = !valueString.isEmpty() ? valueString : null;
			}
			return tClass.cast(value);
		}
		return null;
	}

}
