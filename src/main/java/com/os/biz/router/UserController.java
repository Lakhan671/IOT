package com.os.biz.router;

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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	private UserController() {
	}

	@PostMapping(value = "/user/{page}/{size}")
	public Flux<BizServerResponse<?>> getUser(@RequestBody WeakHashMap<String, String> param) {
		return userService.findAll();
	}

	@PostMapping(value = "/user/{id}")
	public Mono<BizServerResponse<Object>> getUserById(@PathVariable("id")String id,@RequestBody WeakHashMap<String, String> param) {
		return userService.findById(id);
		
	}

	@PostMapping(value = "/register")
	public Mono<BizServerResponse<Object>> saveUser(@RequestBody WeakHashMap<String, String> param) {
		return userService.save(param);
	}

	@DeleteMapping(value = "/user/{id}")
	public Mono<BizServerResponse<Object>> deleteUserById(@PathVariable("id")String id,@RequestBody WeakHashMap<String, String> param) {
		return userService.deleteById(id);
	}

	@PostMapping(value = "/user/findByname")
	public Mono<BizServerResponse<Object>> findUserByName(@RequestBody WeakHashMap<String, String> param) {
		return userService.findByName(param);
	}

	@DeleteMapping(value = "/user/findByMobileNo")
	public Mono<BizServerResponse<Object>> findUserByMobile(@RequestBody WeakHashMap<String, String> param) {
		return userService.findByMobileNo(param);
	}
	

	@DeleteMapping(value = "/user/login")
	public Mono<BizServerResponse<?>> login(@RequestBody WeakHashMap<String, String> param) {
		return userService.login(param);
	}

}
