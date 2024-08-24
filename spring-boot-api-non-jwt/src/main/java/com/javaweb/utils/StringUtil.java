package com.javaweb.utils;

public class StringUtil {
	public static Boolean notEmptyData(String data) {
		if (data != null && !data.equals("")) return true;
		else return false;
	}
}
