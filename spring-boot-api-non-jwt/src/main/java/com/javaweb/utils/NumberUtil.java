package com.javaweb.utils;

public class NumberUtil {
	public static Boolean isNumber(String value) {
		try {
			Long number = Long.parseLong(value);	
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
