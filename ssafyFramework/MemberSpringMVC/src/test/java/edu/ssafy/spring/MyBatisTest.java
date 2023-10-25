package edu.ssafy.spring;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.ssafy.spring.dto.MemberDto;

@WebAppConfiguration
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/servlet-context.xml"})
public class MyBatisTest {
	
	@Autowired
	SqlSession session;
	
	String ns= "edu.ssafy.spring.repository.MemberRepository.";
	
	@Test
	public void testSession1() {
		assertNotNull(session);
	}
	
	@Test
	public void test1() {
		Map<String,String> map = new HashMap();
		map.put("col","id");
		map.put("id", "11");
		List<MemberDto> list= session.selectList(ns+"dynamictest1");
		System.out.println(list.toString());
		assertNotNull(list);
	}
}
