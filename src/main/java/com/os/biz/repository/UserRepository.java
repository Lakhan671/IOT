package com.os.biz.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import com.os.biz.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface UserRepository extends ReactiveSortingRepository<User,String> {
	public abstract Flux<User>findByNameLike(String name, Pageable pageable);
	public abstract Mono<User>findByMobileNo(String mob);
	public abstract Mono<User>findByEmail(String email);
	

}
