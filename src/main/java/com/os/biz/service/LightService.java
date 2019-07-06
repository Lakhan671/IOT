package com.os.biz.service;

import java.util.List;
import java.util.WeakHashMap;

import com.os.biz.entity.Light;
import com.os.biz.util.BizServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LightService {
	public abstract Mono<BizServerResponse<?>> findById(String id);

	public abstract Flux<Light> findAll();

	public abstract Mono<BizServerResponse<?>> save(WeakHashMap<String,String> user);

	public abstract Mono<BizServerResponse<?>> deleteById(String id);

	public abstract Mono<BizServerResponse<?>> deleteAll(String key);

	public abstract Mono<BizServerResponse<?>> findByOnOffAndUserIdAllIgnoreCase(String onnOff, String userId);

	public abstract Mono<BizServerResponse<?>> findByTypeAndUserIdAllIgnoreCase(String type, String userId);

	public abstract Mono<BizServerResponse<?>> findByLightLocationAndUserIdAllIgnoreCase(String lightLocation, String userId);

	public abstract Mono<BizServerResponse<?>> findByUserId(WeakHashMap<String,String>param);
}
