package edu.ssafy.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="controller")
public class MyController implements Controller {

	@Autowired
	private Service ser;
	
	@Override
	public String getMember() {
		System.out.println(ser.getMember());
		return "MyController";
	}

}
