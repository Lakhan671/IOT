package com.os.biz.service;

import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.os.biz.entity.User;
import com.os.biz.repo.UserRepository;
import com.os.biz.util.BizServerResponse;
import com.os.biz.util.ConstantUtil;
import com.os.biz.util.LoginUtil;
import com.os.biz.util.Util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
	UserRepository userRepository;
	private BizServerResponse<Object> response;

	private UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Mono<BizServerResponse<Object>> findById(String id) {
		// userRepository.;
		return userRepository.findById(id.trim()).map(user -> {
			response = new BizServerResponse<>();
			response.setStatus(true);
			response.setData(user);
			return response;
		});
	}

	@Override
	public Mono<BizServerResponse<Object>> save(WeakHashMap<String, String> param) {
		return userRepository.save(prepareUser(param)).map(user -> {
			response = new BizServerResponse<>();
			response.setStatus(true);
			response.setData(user);
			return response;
		});
	}

	@Override
	public Mono<BizServerResponse<Object>> deleteById(String id) {
		return userRepository.deleteById(id).map(user -> {
			response = new BizServerResponse<>();
			response.setStatus(true);
			response.setData(user);
			return response;
		});
	}

	@Override
	public Mono<Void> deleteAll(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<BizServerResponse<Object>> findByName(WeakHashMap<String, String> param) {
		return userRepository
				.findByNameLike(param.get(ConstantUtil.NAME), PageRequest.of(
						Integer.parseInt(param.get(ConstantUtil.PAGE)), Integer.parseInt(param.get(ConstantUtil.SIZE))))
				.collectList().map(user -> {
					response = new BizServerResponse<>();
					response.setStatus(true);
					response.setData(user);
					return response;
				});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.UserService#findByMobileNo(java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<Object>> findByMobileNo(WeakHashMap<String, String> param) {
		return userRepository.findByMobileNo(param.get("mobileNo")).map(user -> {
			response = new BizServerResponse<>();
			response.setStatus(true);
			response.setData(user);
			return response;
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.os.biz.service.UserService#findByemail(java.lang.String)
	 */
	@Override
	public Mono<BizServerResponse<?>> login(Map<String, String> email) {
		response = new BizServerResponse<>();
		WeakHashMap<String,String> tokenreapone=new WeakHashMap<>();
		String token =UUID.randomUUID().toString();
		tokenreapone.put("tokenId", token);
		response.setMessage("Login have been done successfully");
		if (Util.valiMobileNo(ConstantUtil.USERNAME)) {
			return userRepository.findByMobileNo(ConstantUtil.MobileNo).map(user -> {
				response.setStatus(true);
				
				response.setData(tokenreapone);
				LoginUtil.saveTakenId(token, user);
				return response;
			});
		}

		if (Util.isValidEmail(ConstantUtil.USERNAME)) {
			return userRepository.findByEmail(ConstantUtil.EMAIL).map(user -> {
				response.setStatus(true);
				response.setData(user);
				response.setData(tokenreapone);
				LoginUtil.saveTakenId(token, user);
				return response;
			});
		}
		response = new BizServerResponse<>();
		response.setStatus(false);
		response.setMessage("Invalid login id or password");
		return Mono.just(response);
	}

	@Override
	public Mono<BizServerResponse<?>> findByemail(WeakHashMap<String, String> email) {
		return userRepository.findByEmail(email.get(ConstantUtil.EMAIL)).map(user -> {
			response = new BizServerResponse<>();
			response.setStatus(true);
			response.setData(user);
			response.setMessage("User have been getted successfully");
			return response;
		});
	}

	@Override
	public Flux<BizServerResponse<?>> findAll() {
		return userRepository.findAll().map(user -> {
			response = new BizServerResponse<>();
			response.setStatus(true);
			response.setData(user);
			response.setMessage("User have been getted successfully");
			return response;
		});

	}

	private User prepareUser(WeakHashMap<String, String> param) {
		User u = new User();
		if (param.containsKey("name")) {
			u.setName(param.get("name"));
		}
		if (param.containsKey("email")) {
			u.setEmail(param.get("email"));
		}
		if (param.containsKey("mobileNo")) {
			u.setMobileNo(param.get("mobileNo"));
		}
		if (param.containsKey("city")) {
			u.setCity(param.get("city"));
		}
		if (param.containsKey("state")) {
			u.setState(param.get("state"));
		}
		if (param.containsKey("country")) {
			u.setCountry(param.get("country"));
		}
		if (param.containsKey("password")) {
			u.setPassword(param.get("password"));
		}
		return u;
	}
}
