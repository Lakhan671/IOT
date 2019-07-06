package com.os.biz.service;

import java.util.WeakHashMap;

import com.os.biz.entity.User;
import com.os.biz.util.BizServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
	    Mono<User> findById(String id);
	    Flux<User> findAll();
	    Mono<User> save(User user);
	    Mono<Void> deleteById(String id);
	    Mono<Void> deleteAll(String key);
	    Flux<User>findByName(String name,int page, int size);
	    public abstract Flux<User>findByMobileNo(String mob);
		Mono<BizServerResponse<?>> findByemail(WeakHashMap<String, String> email);

}
