package com.os.biz.util;

import java.util.regex.Pattern;

/**
 * @author Lakhan Singh
 *
 */
public class Util {
	private static String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
			+ "A-Z]{2,7}$";

	public static boolean isValidEmail(String email) {

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
	
	public static boolean valiMobileNo(String mobile) {
		return mobile.matches("-?\\d+(\\.\\d+)?");
	}
	public static void main(String[] args) {
	System.out.println(	isValidEmail("lakhan67@gmail.com"));
	System.out.println(valiMobileNo("868686868"));
	}
}
