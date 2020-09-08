package com.cognizant.userservice.aspect;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Configuration
@Slf4j
public class UserServiceAspect {

	
	@Before("execution(* com.cognizant.userservice.service.*.*(..))")
	public void before(JoinPoint joinPoint) {
		Signature sig = joinPoint.getSignature();
		log.debug("Entering [ {} ]", sig);

	}

	@AfterThrowing(value = "execution(* com.cognizant.userservice.*.*(..))", throwing = "error")
	public void afterThrowing(JoinPoint jp, Throwable error) {
		 log.error("Exception in {}.{}() with cause = {}", jp.getClass(),jp,jp.getSignature().getDeclaringTypeName(),
		            jp.getSignature().getName(), error.getMessage() != null ? error.getMessage() : "NULL");
	}

	@AfterReturning(value = "execution(* com.cognizant.userservice.controller.*.*(..)) ", returning = "result")
	public void afterController(JoinPoint joinPoint, ResponseEntity<Map<String, Object>> result) {
		log.debug("Returning [ {} ]",result);
	}

}
