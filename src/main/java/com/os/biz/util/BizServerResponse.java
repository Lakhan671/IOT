package com.os.biz.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * @author Lakhan
 *
 * @param <T>
 */
public class BizServerResponse<T> implements ServerResponse {
	private boolean status;
	private String error;
	private String ErrorCode;
	private String message;
	private T data;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String userName;


	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return ErrorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public HttpStatus statusCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpHeaders headers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> writeTo(ServerWebExchange exchange, Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	public MultiValueMap<String, ResponseCookie> cookies() {
		// TODO Auto-generated method stub
		return null;
	}

}
