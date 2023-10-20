package edu.ssafy.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="service")
public class MyService implements Service {
	@Autowired
	private Repository repo;
	
	@Override
	public String getMember() {
		System.out.println(repo.getMember());
		return "MyService";
	}

}
