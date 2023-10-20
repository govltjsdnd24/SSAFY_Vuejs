package edu.ssafy.model;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Dispatcher {
	@Autowired
	private Controller con;
	
	public static void main(String[] args) {
		
		new Dispatcher().go();
	}
	
	private void go() {
		BeanFactory factory = new AnnotationConfigApplicationContext(Config.class);
		MyController conn = factory.getBean("controller", MyController.class);
		System.out.println(conn.getMember());
	}

}
