package edu.ssafy.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.spring.model.DataDto;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(HttpServletRequest request, HttpSession session, String name) {
		//String name = request.getParameter("name");
		System.out.println(name);
		request.setAttribute("name", name);
		return "hello";
	}
	@GetMapping(value="/param" )
	public String param() {
		return "form";
	}
	
	@GetMapping(value="/result")
	public String result() {
		return "result";
	}
	
//	@GetMapping(value="/sendparam")
//	public ModelAndView sendParam(@RequestParam("userid")String userId, @RequestParam("username")String userName, @RequestParam("area")int region) {
//		ModelAndView mav= new ModelAndView();
//		DataDto data=new DataDto(userId, userName, region);
//		mav.addObject("data",data);
//		mav.setViewName("result");
//		return mav;
//	}
	
	@RequestMapping(value="/sendparam")
	public ModelAndView sendParamMulti(@ModelAttribute DataDto data) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("data",data);
		mav.setViewName("result");
		return mav;
	}
	
}
