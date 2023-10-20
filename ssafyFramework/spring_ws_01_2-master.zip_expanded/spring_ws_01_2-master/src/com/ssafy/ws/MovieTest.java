package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {
		ApplicationContext appCtx= new ClassPathXmlApplicationContext("applicationContext.xml");
		Audience aud= appCtx.getBean("audience",Audience.class);
		aud.setMovie(aud.movie);
		aud.print();
	}
}
