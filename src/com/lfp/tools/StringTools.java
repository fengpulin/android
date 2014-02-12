package com.lfp.tools;

public class StringTools {

	public static boolean isNumber(char c){
		if((c-'0')>=0&&(c-'0')<=9){
			return true;
		}
		return false;
	}
}
