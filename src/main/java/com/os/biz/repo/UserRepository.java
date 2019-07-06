package com.os.biz.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import com.os.biz.entity.User;

import reactor.core.publisher.Flux;
public interface UserRepository extends ReactiveSortingRepository<User,String> {
	public abstract Flux<User>findByNameLike(String name, Pageable pageable);
	public abstract Flux<User>findByMobileNo(String mob);
	public abstract Flux<User>findByEmail(String email);
	

}
