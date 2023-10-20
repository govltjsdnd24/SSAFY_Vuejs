package edu.ssafy.spring.model;

import java.util.Arrays;
import java.util.List;

public class DataDto {
	private String userid,username;
	private int area;
	private List<String> fruit;
	
//	public DataDto(String userid, String username, int area, String[] fruit) {
//		super();
//		this.userid = userid;
//		this.username = username;
//		this.area=area;
//		this.fruit=fruit;
//	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	
	public List<String> getFruit() {
		return fruit;
	}
	public void setFruit(List<String> fruit) {
		this.fruit = fruit;
	}
	
	
	
}
