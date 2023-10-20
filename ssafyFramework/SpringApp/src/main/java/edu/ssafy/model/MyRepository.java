package edu.ssafy.model;

import org.springframework.stereotype.Component;

@Component(value="repository")
class MyRepository implements Repository {

	@Override
	public String getMember() {
		return "MyRepository";
	}

}
