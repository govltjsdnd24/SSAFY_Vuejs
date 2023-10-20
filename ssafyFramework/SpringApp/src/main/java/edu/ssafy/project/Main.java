package edu.ssafy.project;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext cxt= new ClassPathXmlApplicationContext("edu/ssafy/project/applicationContext.xml");
		Phone gal = cxt.getBean("apple",Phone.class);
		gal.powerOn();
//		gal.powerOff();
//		gal.takePicture();
//		gal.call();
//		System.out.println();
		
		//new AppDispatcher(cxt).go();
		

	}

}
