package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="audience")
public class Audience {
	
	Movie movie;
		
	@Autowired
	
	public Audience(@Qualifier("comic") Movie movie) {
		super();
		this.movie = movie;
	}
	
	@Autowired
	public void setMovie(@Qualifier("action") Movie movie) {
		this.movie=movie;
	}

	public void print() {
		System.out.println(movie.getInfo());
	}
}
