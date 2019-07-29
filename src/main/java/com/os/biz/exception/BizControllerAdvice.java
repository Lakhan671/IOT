package com.os.biz.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.os.biz.util.BizServerResponse;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
public class BizControllerAdvice implements WebExceptionHandler {
	private BizServerResponse<Object> response;
	private ObjectMapper objectMapper;

    public BizControllerAdvice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
	@Override
	public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
		response = new BizServerResponse<Object>();
		if (ex instanceof WebExchangeBindException) {
			
		} else {

			if (ex instanceof ResponseStatusException) {
				response.setStatus(false);
				response.setErrorCode(StringUtils.EMPTY+ ((ResponseStatusException) ex).getStatus().value());
				response.setMessage("url  not found ");
				DataBuffer db = null;
				try {
					db = new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(response));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				return exchange.getResponse().writeWith(Mono.just(db));
			}
			
			if (ex instanceof InternalServerError) {
				response.setStatus(false);
				response.setMessage(ex.getMessage());
				DataBuffer db = null;
				try {
					db = new DefaultDataBufferFactory().wrap(objectMapper.writeValueAsBytes(response));
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				return exchange.getResponse().writeWith(Mono.just(db));
			}

	}
		return null;
}

}