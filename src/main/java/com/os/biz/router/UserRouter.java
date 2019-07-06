package com.os.biz.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.os.biz.handler.UserHandler;

@Configuration
public class UserRouter {
	@Bean
	public RouterFunction<ServerResponse> route(UserHandler handler) {
		return RouterFunctions.route(GET("/user").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/user/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)
				.andRoute(POST("/user").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::saveEmployee)
				.andRoute(DELETE("/user/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::deleteById)
				.andRoute(GET("/user/findByname/{name}/{page}/{size}").and(accept(MediaType.APPLICATION_JSON)),
						handler::findByName)
				.andRoute(POST("/user/resgister").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::saveEmployee)
				/*
				 * .andRoute(GET("/user/findByEmail/{email}").and(accept(MediaType.
				 * APPLICATION_JSON)), handler::findByemail)
				 */
				.andRoute(GET("/user/findByMobileNo/{MobileNo}").and(accept(MediaType.APPLICATION_JSON)),
						handler::findByMobileNo)
				.andRoute(POST("/login").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findByemail);
	}

}
