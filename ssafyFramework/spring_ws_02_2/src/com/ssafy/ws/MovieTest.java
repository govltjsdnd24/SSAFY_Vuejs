package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) throws CallException {
		ApplicationContext appCtx= new ClassPathXmlApplicationContext("applicationContext.xml");
		Audience audience= appCtx.getBean("audience",Audience.class);
		audience.doSomething();
	}
}
