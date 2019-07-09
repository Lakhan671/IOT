package com.os.biz.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.os.biz.entity.Light;

import reactor.core.publisher.Flux;
@Repository
public interface LightRepository extends ReactiveMongoRepository <Light, String> {

	public abstract Flux<Light> findByOnOffAndUserIdAllIgnoreCase(String onnOff, String userId);

	public abstract Flux<Light> findByTypeAndUserIdAllIgnoreCase(String type, String userId);

	public abstract Flux<Light> findByLightLocationAndUserIdAllIgnoreCase(String lightLocation, String userId);

	public abstract Flux<Light> findByUserId(String userId);

}
