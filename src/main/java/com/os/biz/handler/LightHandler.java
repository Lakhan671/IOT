package com.os.biz.handler;

import org.springframework.stereotype.Component;

@Component
public class LightHandler {
	/*
	 * private final LightService lightService;
	 * 
	 * private LightHandler(LightService lightService) { this.lightService =
	 * lightService; }
	 * 
	 * public Mono<ServerResponse>saveLight(ServerRequest request){ final
	 * Mono<WeakHashMap<String,String>> req=request.bodyToMono(WeakHashMap.class);
	 * return ok() .contentType(MediaType.APPLICATION_JSON)
	 * .body(fromPublisher(req.flatMap(lightService::save),
	 * BizServerResponse.class));
	 * 
	 * }
	 * 
	 * public Mono<ServerResponse>getByUserIdLight(ServerRequest request){
	 * 
	 * return ok() .contentType(MediaType.APPLICATION_JSON)
	 * .body(fromPublisher(lightService.findByUserId(request.pathVariable("userId"))
	 * , BizServerResponse.class));
	 * 
	 * }
	 * 
	 * public Mono<ServerResponse>deleteById(ServerRequest request){ return
	 * ok().contentType(MediaType.APPLICATION_JSON).body(lightService.findByUserId(
	 * request.pathVariable("id")),Void.class); }
	 * 
	 * 
	 * private final UserService userService; private LightHandler(UserService
	 * userService) { this.userService=userService; }
	 * 
	 * public Mono<ServerResponse> findById(ServerRequest request) {
	 * 
	 * return
	 * ok().contentType(MediaType.APPLICATION_JSON).body(userService.findById(
	 * request.pathVariable("id")), User.class); }
	 * 
	 * public Mono<ServerResponse>findAll(ServerRequest request){ return
	 * ok().contentType(MediaType.APPLICATION_JSON).body(userService.findAll(),User.
	 * class); } public Mono<ServerResponse>saveEmployee(ServerRequest request){
	 * final Mono<User> employee=request.bodyToMono(User.class); return ok()
	 * .contentType(MediaType.APPLICATION_JSON)
	 * .body(fromPublisher(employee.flatMap(userService::save), User.class));
	 * 
	 * } public Mono<ServerResponse>deleteById(ServerRequest request){ return
	 * ok().contentType(MediaType.APPLICATION_JSON).body(userService.deleteById(
	 * request.pathVariable("id")),Void.class); }
	 * 
	 * public Mono<ServerResponse>findByName(ServerRequest request){ return
	 * ok().contentType(MediaType.APPLICATION_JSON).body(userService.findByName(
	 * request.pathVariable("name"),Integer.parseInt(request.pathVariable("page")),
	 * Integer.parseInt(request.pathVariable("size"))),User.class); } public
	 * Mono<ServerResponse>findByemail(ServerRequest request){ return
	 * ok().contentType(MediaType.APPLICATION_JSON).body(userService.findByemail(
	 * request.pathVariable("email")),User.class); } public
	 * Mono<ServerResponse>findByMobileNo(ServerRequest request){ return
	 * ok().contentType(MediaType.APPLICATION_JSON).body(userService.findByMobileNo(
	 * request.pathVariable("mobileNo")),User.class); }
	 */}
