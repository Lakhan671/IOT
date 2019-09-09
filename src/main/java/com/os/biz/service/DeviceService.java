package com.os.biz.service;

import java.util.WeakHashMap;

import com.os.biz.entity.Device;
import com.os.biz.util.BizServerResponse;

import reactor.core.publisher.Mono;

public interface DeviceService {
	public abstract Mono<Device> findById(String id);

	public abstract Mono<BizServerResponse<?>> findAll();

	public abstract Mono<BizServerResponse<?>> save(WeakHashMap<String, String> user);

	public abstract Mono<BizServerResponse<?>> deleteById(WeakHashMap<String, String> param);

	public abstract Mono<BizServerResponse<?>> deleteAll(String key);

	public abstract Mono<BizServerResponse<?>> findByOnOffAndUserIdAllIgnoreCase(WeakHashMap<String, String> param);

	public abstract Mono<BizServerResponse<?>> findByTypeAndUserIdAllIgnoreCase(WeakHashMap<String, String> param);

	public abstract Mono<BizServerResponse<?>> findByUserId(WeakHashMap<String, String> param);

	public abstract Mono<BizServerResponse<?>> findByLightLocationAndUserIdAllIgnoreCase(WeakHashMap<String, String> param);

	Mono<BizServerResponse<?>> update(WeakHashMap<String, String> param);
}
