package com.lfp.tools;

public class StringTools {

	public static boolean isNumber(char c) {
		if ((c - '0') >= 0 && (c - '0') <= 9) {
			return true;
		}
		return false;
	}

	public static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(String str) {
		if (null != str && str.length() != 0) {
			return false;
		}
		return true;
	}

	public static double strToNum(String str) {
		if (!isNullOrEmpty(str)) {
			return Double.valueOf(str);
		}
		return 0.0;
	}

	public static boolean isInt(String str) {
		if (!isNullOrEmpty(str)) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '.')
					return false;
			}
			return true;
		}
		return false;
	}
}
