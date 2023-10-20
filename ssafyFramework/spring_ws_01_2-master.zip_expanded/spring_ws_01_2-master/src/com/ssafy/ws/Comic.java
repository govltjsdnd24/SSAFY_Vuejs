package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component(value="comic")
public class Comic implements Movie{
	

	@Override
	public String getInfo() {
		return "만화영화를 관람합니다.";
	}
}
