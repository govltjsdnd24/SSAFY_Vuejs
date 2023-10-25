package edu.ssafy.spring;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.ssafy.spring.controller.MemberController;
import edu.ssafy.spring.repository.MemberRepository;
import edu.ssafy.spring.service.MemberService;

@WebAppConfiguration
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/servlet-context.xml"})
public class MVCTest {
	@Autowired
	MemberController conn;
	@Autowired
	MemberService service;
	@Autowired
	MemberRepository repo;
	
	@Test
	public void testController() {
		assertNotNull(conn);
	}
	
	@Test
	public void testService() {
		assertNotNull(service);
	}
	
	@Test
	public void testRepository() {
		assertNotNull(repo);
	}
}
