package com.os.biz.util;

import java.util.HashMap;
import java.util.WeakHashMap;

import com.os.biz.entity.User;

public class LoginUtil {
	private static HashMap<String, User> userMap = new HashMap<>();

	public static boolean validateUser(WeakHashMap<String, String> param) {
		if (param.containsKey("tokenId")) {
			return true;
		}
		return false;

	}

	public static void saveTakenId(String token, User u) {
		userMap.put(token, u);
	}

	public static User getUser(WeakHashMap<String, String> param) {
		if (param.containsKey("tokenId")) {
			return userMap.get(param.get("tokenId"));
		} else {
			return null;
		}
		
	}
}
