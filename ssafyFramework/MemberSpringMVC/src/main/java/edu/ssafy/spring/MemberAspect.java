package edu.ssafy.spring;

import org.springframework.stereotype.Component;

public class MemberAspect {
		
		public void before() {
			System.out.println("form을 받아올 준비를 합니다.");
		}
		
		public void after() {
			System.out.println("form을 받아왔습니다.");
		}
		public void afterReturn() {
			System.out.println("form을 처리했습니다");
		}
		
		public void afterThrowing() {
			System.out.println("form 처리 중 오류 발생");
		}
		
		public void around() {
			//System.out.println("영화관을 갑니다");
		}
		
		
		

}
