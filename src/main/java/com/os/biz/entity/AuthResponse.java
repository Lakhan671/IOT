package com.os.biz.entity;

/**
 * @author Lakhan
 *
 */
public class AuthResponse {
	
	private String token;

	
	/**
	 * @param token
	 */
	public AuthResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
