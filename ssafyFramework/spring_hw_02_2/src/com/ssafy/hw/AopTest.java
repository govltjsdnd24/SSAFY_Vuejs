package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) throws ApplicationException {
		ApplicationContext appCtx= new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("******1.GeneralUser");
		User genUser=appCtx.getBean("generalUser",User.class);
		genUser.useApp();
		System.out.println("******2.AdminUser");
		User admUser=appCtx.getBean("adminUser",User.class);
		admUser.useApp();
	}

}
