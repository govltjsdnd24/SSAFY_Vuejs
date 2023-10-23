package edu.ssafy.spring.dto;

import org.springframework.stereotype.Component;

@Component
public class MemberDto {
	private String id, pw,name,age,addr;

	
	
	public MemberDto(String id, String pw, String name, String age, String addr) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}

	public MemberDto() {
		super();
	}
	
	
}
