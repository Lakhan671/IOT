package com.os.biz.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.os.biz.entity.Light;

import reactor.core.publisher.Flux;

public interface LightRepository extends ReactiveMongoRepository <Light, String> {

	public abstract Flux<Light> findByOnOffAndUserIdAllIgnoreCase(String onnOff, String userId);

	public abstract Flux<Light> findByTypeAndUserIdAllIgnoreCase(String type, String userId);

	public abstract Flux<Light> findByLightLocationAndUserIdAllIgnoreCase(String lightLocation, String userId);

	public abstract Flux<Light> findByUserId(String userId);

}
