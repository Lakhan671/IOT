package com.os.biz.service;

import java.util.WeakHashMap;

import com.os.biz.entity.User;
import com.os.biz.util.BizServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
	    Mono<BizServerResponse<Object>> findById(String id);
	    Mono<BizServerResponse<?>> findAll();
	    Mono<BizServerResponse<Object>> deleteById(String id);
	    Mono<Void> deleteAll(String key);
		Mono<BizServerResponse<?>> findByemail(WeakHashMap<String, String> email);
		///Mono<BizServerResponse<?>> findByemail(Map<String, String> email);
		Mono<BizServerResponse<Object>> findByMobileNo(WeakHashMap<String, String> param);
		Mono<BizServerResponse<Object>> findByName(WeakHashMap<String, String> param);
		Mono<BizServerResponse<Object>> save(WeakHashMap<String, String> param);
		//Mono<BizServerResponse<Object>> login(Map<String, String> email);
		Mono<BizServerResponse<Object>> login(WeakHashMap<String, String> email);
		public Mono<User> findByUsername(String username);

}
