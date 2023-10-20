package edu.ssafy.project;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("edu/ssafy/project/name.properties")
public class AppDispatcher extends Dispatcher {
	@Value("${phone}")
	private String phone;
	
	public AppDispatcher(BeanFactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}
	
	public void go() {
		Phone p = getBean("phone");
		p.takePicture();
		
//		Phone p1=getBean("apple");
//		p1.takePicture();
	}
	
	
}
