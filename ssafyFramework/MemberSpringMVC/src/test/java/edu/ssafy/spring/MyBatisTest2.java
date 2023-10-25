package edu.ssafy.spring;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.ssafy.spring.dto.MemberDto;


@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/servlet-context.xml"})
public class MyBatisTest2 {
	
	@Autowired
	SqlSession session;
	
	String ns= "edu.ssafy.spring.repository.MemberRepository.";
	
	@Test
	public void test1() {
		List<MemberDto> list= session.selectList(ns+"test1");
		System.out.println(list.toString());
		assertNotNull(list);
	}
}
