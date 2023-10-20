package edu.ssafy.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// springFramework  실행
		//BeanFactory cxt = new ClassPathXmlApplicationContext("/applicationContext.xml");
		BeanFactory cxt = 
				new AnnotationConfigApplicationContext(Config.class);
		
//		Person p = (Person) cxt.getBean("person");
//		System.out.println(p);
//		
//		Person p1 = (Person) cxt.getBean("person");
//		
//		if(p==p1) {
//			System.out.println("p == p1");
//		}else {
//			System.out.println("p != p1 ");
//		}
//		Student std = cxt.getBean(Student.class);
//		
//		System.out.println(std);
		
		
		
		// plain old java Object (POJO) 
//		edu.ssafy.main.Person p = new edu.ssafy.main.Person("홍길동",21,"덕명동");
//		System.out.println(p);
//		p.setAge(22);
//		System.out.println(p);
		
	}

}
