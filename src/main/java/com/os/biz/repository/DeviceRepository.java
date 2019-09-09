package com.os.biz.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.os.biz.entity.Device;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface DeviceRepository extends ReactiveMongoRepository <Device, String> {

	public abstract Flux<Device> findByOnOffAndUserIdAllIgnoreCase(boolean onnOff, String userId);

	public abstract Flux<Device> findByTypeAndUserIdAllIgnoreCase(String type, String userId);

	public abstract Flux<Device> findByDeviceLocationAndUserIdAllIgnoreCase(String lightLocation, String userId);

	public abstract Flux<Device> findByUserId(String userId);
	public abstract Mono<Device> findById(String id);

}
