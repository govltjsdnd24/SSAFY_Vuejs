package edu.ssafy.project;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PrintAdvice {
	@Before("execution(* edu.ssafy.project.*.power*(..))")
	public void printBefore() {
		System.out.println("AOP Before");
	}
	
	@After("execution(* edu.ssafy.project.*.power*(..))")
	public void printAfter() {
		System.out.println("AOP After");
	}
	
	@Around("execution(* edu.ssafy.project.*.power*(..))")
	public Object printAround(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("AOP AroundBefore");
		Object proceed= jp.proceed();
		System.out.println("AOP AroundAfter");
		return proceed;
	}
	
	@AfterReturning(value ="execution(* edu.ssafy.project.*.power*(..))", returning="returnObj")
	public void afterReturning(JoinPoint jp, Object returnObj) {
		Object[] args= jp.getArgs();
		//returnObj
		System.out.println("afterReturning");
	}
	
	//error 발생 시 실행됨
	@AfterThrowing(value="execution(* edu.ssafy.project.*.power*(..))", throwing="exception")
	public void afterThrowing(Exception exception) {
		System.out.println("afterThrowing");
		//exception.printStackTrace();
	}
}
