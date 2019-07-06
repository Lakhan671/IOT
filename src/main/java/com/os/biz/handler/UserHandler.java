package com.os.biz.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.util.WeakHashMap;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.os.biz.entity.User;
import com.os.biz.service.UserService;
import com.os.biz.util.BizServerResponse;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {
private final UserService  userService;
private UserHandler(UserService userService) {
	this.userService=userService;
}

public Mono<ServerResponse> findById(ServerRequest request) {
	
    return ok().contentType(MediaType.APPLICATION_JSON).body(userService.findById(request.pathVariable("id")), User.class);
}

public Mono<ServerResponse>findAll(ServerRequest request){
	return ok().contentType(MediaType.APPLICATION_JSON).body(userService.findAll(),User.class);
}
public Mono<ServerResponse>saveEmployee(ServerRequest request){
 final Mono<User> employee=request.bodyToMono(User.class);
	return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromPublisher(employee.flatMap(userService::save), User.class));

}
public Mono<ServerResponse>deleteById(ServerRequest request){
	return ok().contentType(MediaType.APPLICATION_JSON).body(userService.deleteById(request.pathVariable("id")),Void.class);
}

public Mono<ServerResponse>findByName(ServerRequest request){
	return ok().contentType(MediaType.APPLICATION_JSON).body(userService.findByName(request.pathVariable("name"),Integer.parseInt(request.pathVariable("page")),Integer.parseInt(request.pathVariable("size"))),User.class);
}
public Mono<ServerResponse>findByemail(ServerRequest request){
	 final Mono<WeakHashMap<String,String>> req=request.bodyToMono(WeakHashMap.class);
	return ok().contentType(MediaType.APPLICATION_JSON).body(fromPublisher(req.flatMap(userService::findByemail), BizServerResponse.class));
}
public Mono<ServerResponse>findByMobileNo(ServerRequest request){
	return ok().contentType(MediaType.APPLICATION_JSON).body(userService.findByMobileNo(request.pathVariable("mobileNo")),User.class);
}
}
