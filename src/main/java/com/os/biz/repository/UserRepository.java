package com.os.biz.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.os.biz.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {
	public abstract Flux<User> findByNameLike(String name, Pageable pageable);

	public abstract Flux<User> findByMobileNo(String mob);

	public abstract Mono<User> findByEmail(String email);

	public Mono<User> findByUsername(String username);

	@Query("{ id: { $exists: true }}")
	Flux<User> retrieveAllUsersPaged(final Pageable page);

}
