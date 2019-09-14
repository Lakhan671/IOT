package com.os.biz.config;

import java.util.WeakHashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Aspect
public class LoggingAspect {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Before("execution(* com.os.biz.controller.*.*(..)) && args(param,..)")
    public void logBefore(JoinPoint joinPoint,WeakHashMap<String, String> param) {

		log.info("**************************************************"+"logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******"+joinPoint.getArgs());
    }
	@After("execution(* com.os.biz.controller.*.*(..)) && args(param,..)")
    public void logAfter(JoinPoint joinPoint) {

		log.info("**************************************************"+"logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******"+joinPoint.getArgs());
    }
}
