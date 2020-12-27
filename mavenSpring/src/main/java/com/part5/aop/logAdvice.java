package com.part5.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class logAdvice {
	@Before("execution(* com.part5.service.AOPExamService*.doAdd(String, String)) && args(str1, str2)")
	public void logBefore(String str1, String str2) {
		log.info("str1: " + str1);
		log.info("str2: " + str2);
	}
										   
	@AfterThrowing(pointcut = "execution(* com.part5.service.AOPExamService*.*(..))", throwing="exception")
	public void logException(Exception exception) {
		log.info("Exception....!!!!");
		log.info("exeception: " + exception);
	}
	
	@Around("execution(* com.part5.service.AOPExamService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		
		log.info("Target:: " + pjp.getTarget());
		log.info("Param:: " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		
		try {
			result= pjp.proceed(); //메서드 실행
		}catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		log.info("TIME:: " + (end - start));
		
		return result;
	}
}
