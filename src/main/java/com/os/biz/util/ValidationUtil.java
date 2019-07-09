package com.os.biz.util;

import java.util.WeakHashMap;

import reactor.core.publisher.Mono;

public class ValidationUtil {
	private static BizServerResponse<Object> response = new BizServerResponse<>();

	public static BizServerResponse<Object> validateTokenId(WeakHashMap<String, String> param) {
		if (!LoginUtil.validateUser(param)) {
			response.setMessage("Invalid token id");
			return response;
		}else {
			return null;
		}
			
	}

}
