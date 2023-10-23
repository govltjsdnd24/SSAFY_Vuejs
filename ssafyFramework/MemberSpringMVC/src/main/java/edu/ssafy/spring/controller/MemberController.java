package edu.ssafy.spring.controller;

import java.net.http.HttpRequest;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.spring.dto.MemberDto;
import edu.ssafy.spring.service.MemberService;

@Controller
@RequestMapping("/mem")
public class MemberController {
	
	private MemberService service;
	@Autowired
	public MemberController(MemberService service) {
		this.service = service;
	}
	@GetMapping("/insert")
	public String MemberInsertForm() {
		return "member/regform";
	};
	
	@PostMapping("/insert")
	public String MemberInsert(@ModelAttribute() MemberDto dto) {
		try {
			int res = service.memberInsert(dto);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	};
	@GetMapping("/list")
	public ModelAndView MemberList(ModelAndView mav) {
		try {
			List<MemberDto> list = service.memberList();
			mav.addObject("list",list);
			mav.setViewName("member/listmember");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	};
	
	@GetMapping("/view")
	public ModelAndView MemberView(MemberDto dto,ModelAndView mav) {
		try {
			MemberDto member = service.memberView(dto);
			mav.addObject("mem", member);
			mav.setViewName("member/viewmember");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	};
	
	@PostMapping("/update")
	public ModelAndView MemberUpdate(@ModelAttribute() MemberDto dto, ModelAndView mav) {
		try {
			int res = service.memberUpdate(dto);
			mav.setViewName("redirect:list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
			mav.addObject("exception",e.getMessage());
		}
		return mav;
	};
	@PostMapping("/delete")
	public ModelAndView MemberDelete(@ModelAttribute() MemberDto dto, ModelAndView mav) {
		try {
			int res = service.memberDelete(dto);
			mav.setViewName("redirect:list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
			mav.addObject("exception",e.getMessage());
		}
		return mav;
	};
	
	@GetMapping("/login")
	public String MemberLogin() {
		return "member/loginform";
	};
	
	@PostMapping("/login")
	public ModelAndView MemberLogin(ModelAndView mav, @RequestParam(value="id") String username, @RequestParam(value="pw") String userpwd,HttpSession session) {
		try {
			if(session.getAttribute("loginid")!=null) {
				mav.setViewName("index");
				return mav;
			}
			MemberDto memberDto= service.memberLogin(username,userpwd);
			if(memberDto.getId()!=null) {
				session.setAttribute("loginid", memberDto.getId());
				mav.setViewName("index");
			}
			else{
				mav.setViewName("member/loginform");
			}
		}catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
			mav.addObject("exception",e.getMessage());
		}
		return mav;
	}
	
	@GetMapping("/logout")
	public String MemberLogin(HttpSession session) {
		session.removeAttribute("loginid");
		return "index";
	};
	
	@PostMapping("/delmembers")
	public ModelAndView delMembers(@RequestParam(value="id")String[] checkList, ModelAndView mav) {
		try {
			int res= service.deleteMembers(checkList);
			for (int i = 0; i < checkList.length; i++) {
				System.out.println(checkList[i]);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
			mav.addObject("exception",e.getMessage());
		}
		mav.setViewName("redirect:list");
		return mav;
	}
	
	@PostMapping("/idcheck/{id}")
	public String idCheck(@PathVariable("id") String id) {
		int res;
		try {
			res = service.idCheck(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		return id;
	}
	
}
