package com.os.biz.config;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.WeakHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.os.biz.entity.User;
import com.os.biz.repository.UserRepository;
import com.os.biz.service.UserService;
import com.os.biz.util.BizServerResponse;
import com.os.biz.util.ConstantUtil;
import com.os.biz.util.LoginUtil;
import com.os.biz.util.Util;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserRepository userRepository;
	private  BizServerResponse<Object> response;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public Mono<BizServerResponse<Object>> createAuthenticationToken(@RequestBody WeakHashMap<String, String> authenticationRequest) throws Exception {
		response = new BizServerResponse<>();
		authenticate(authenticationRequest.get(ConstantUtil.USERNAME), authenticationRequest.get("password"));
		 User user=getUserData(authenticationRequest);
		 if(Objects.nonNull(user)) {
			 final String token = jwtTokenUtil.generateToken(user.getEmail());
				WeakHashMap<String,String> tokenreapone=new WeakHashMap<>();
				tokenreapone.put("token", token);
				response.setData(tokenreapone);
		 }else {
			 response.setMessage("INVALID_CREDENTIALS");
			 response.setError("400");
		 }
		
		return Mono.just(response);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	private  User getUserData(WeakHashMap<String, String> email) {
		User u;
		if(email.containsKey(ConstantUtil.USERNAME)){
			if (Util.valiMobileNo(email.get(ConstantUtil.USERNAME))) {
			      userRepository.findByMobileNo(email.get(ConstantUtil.USERNAME)).map(user -> {
			    	  return user;
				});
			}
		}

		if(email.containsKey(ConstantUtil.USERNAME)){
		System.out.print(Util.isValidEmail(email.get(ConstantUtil.USERNAME)));
		if (Util.isValidEmail(email.get(ConstantUtil.USERNAME))) {
			 userRepository.findByEmail(email.get(ConstantUtil.USERNAME)).map(user -> {
				 return user;
			});
		}
		}
		return null;
	}
}

