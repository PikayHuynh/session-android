package com.zzz.sessionapplication.util;

public class StringUtil {
	public static boolean isValid(String str) {
		return str != null && !str.isBlank();
	}

	public static boolean isInvalid(String str) {
		return !isValid(str);
	}

	public static String cast(Object obj) {
		return obj.toString();
	}
}
