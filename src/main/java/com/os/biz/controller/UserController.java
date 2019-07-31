package com.os.biz.controller;

import java.net.URLConnection;
import java.util.WeakHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.os.biz.service.UserService;
import com.os.biz.util.BizServerResponse;
import com.os.biz.util.ConstantUtil;
import com.os.biz.util.URLConstant;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = URLConstant.API)
public class UserController {
	@Autowired
	private UserService userService;

	private UserController() {
	}

	@PostMapping(value = URLConstant.GET_USERS)
	public Mono<BizServerResponse<?>> getUser(@PathVariable(ConstantUtil.PAGE)int page,@PathVariable(ConstantUtil.SIZE)int size,@RequestBody WeakHashMap<String, String> param) {
		
		return userService.findAll(page,size);
	}

	@PostMapping(value =URLConstant.GET_USER_BY_ID)
	public Mono<BizServerResponse<Object>> getUserById(@PathVariable(ConstantUtil.ID)String id,@RequestBody WeakHashMap<String, String> param) {
		return userService.findById(id);
		
	}

	@PostMapping(value = URLConstant.SIGNUP)
	public Mono<BizServerResponse<Object>> saveUser(@RequestBody WeakHashMap<String, String> param) {
		return userService.save(param);
	}

	@DeleteMapping(value = "/user/{id}")
	public Mono<BizServerResponse<Object>> deleteUserById(@PathVariable("id")String id,@RequestBody WeakHashMap<String, String> param) {
		return userService.deleteById(id);
	}

	@PostMapping(value =URLConstant.FIND_BY_NAME)
	public Mono<BizServerResponse<Object>> findUserByName(@RequestBody WeakHashMap<String, String> param) {
		return userService.findByName(param);
	}

	@PostMapping(value = URLConstant.FIND_BY_MOBILE_NO)
	public Mono<BizServerResponse<Object>> findUserByMobile(@RequestBody WeakHashMap<String, String> param) {
		return userService.findByMobileNo(param);
	}
	

}
