package edu.ssafy.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Autowired
	private Person p;
	private String num = "11";
	
	
//	public Student(Person p, String num) {
//		super();
//		this.p = p;
//		this.num = num;
//	}
	public Student(Person p) {
		System.out.println("33");

	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Student [p=" + p + ", num=" + num + "]";
	}
	
	
}
