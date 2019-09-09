package com.os.biz.controller;

import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
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
import com.os.biz.repository.LoggingInMemoryHttpTraceRepository;
import com.os.biz.service.UserService;
import com.os.biz.util.BizServerResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author Lakhan
 *
 */
@RestController
@RequestMapping(value="/api")
@Slf4j
public class AuthenticationController {

	@Autowired
	private JWTUtil jwtUtil;
	private BizServerResponse<Object> response;
	/*
	 * @Autowired private PBKDF2Encoder passwordEncoder;
	 */
	@Autowired
	private UserService userRepository;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Mono<BizServerResponse<Object>> login(@RequestBody AuthRequest ar) {
	//	log.info("Trace:" + ToStringBuilder.reflectionToString(ar));
		    response = new BizServerResponse<>();
		    response.setStatus(false);
			response.setMessage("your are not authroize to login. Please  signup....");
		return userRepository.findByUsername(ar.getUsername()).map((userDetails) -> {
			response.setData(ar);
			if (ar.getPassword().equals(userDetails.getPassword())) {
				response.setStatus(true);
				response.setMessage("you have beein login suceessfully.");
				response.setData(new AuthResponse(jwtUtil.generateToken(userDetails)));
			} else if(Objects.nonNull(ar)) {
				response.setStatus(false);
				response.setMessage("user name or password invalid.");
			}
			return response;
		}).defaultIfEmpty(response);
	}

}
