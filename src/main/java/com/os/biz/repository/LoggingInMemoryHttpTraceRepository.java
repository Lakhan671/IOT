package com.os.biz.repository;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class LoggingInMemoryHttpTraceRepository extends InMemoryHttpTraceRepository {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
    public void add(HttpTrace trace) {
        super.add(trace);
		
		  log.info("Trace:" + ToStringBuilder.reflectionToString(trace));
		  log.info("Request:" +
		  ToStringBuilder.reflectionToString(trace.getRequest())); log.info("Response:"
		  + ToStringBuilder.reflectionToString(trace.getResponse()));
		 
    }
}
