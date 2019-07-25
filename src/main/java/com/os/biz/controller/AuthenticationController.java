package com.os.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.os.biz.config.security.JWTUtil;
import com.os.biz.config.security.PBKDF2Encoder;
import com.os.biz.entity.AuthRequest;
import com.os.biz.entity.AuthResponse;
import com.os.biz.service.UserService;

import reactor.core.publisher.Mono;

/**
 * @author Lakhan
 *
 */
@RestController
@RequestMapping(value="/api")
public class AuthenticationController {

	@Autowired
	private JWTUtil jwtUtil;
	
	/*
	 * @Autowired private PBKDF2Encoder passwordEncoder;
	 */
	@Autowired
	private UserService userRepository;
//passwordEncoder.encode(
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Mono<ResponseEntity<?>> login(@RequestBody AuthRequest ar) {
		return userRepository.findByUsername(ar.getUsername()).map((userDetails) -> {
			if (ar.getPassword().equals(userDetails.getPassword())) {
				return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails)));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

}
