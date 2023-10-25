package edu.ssafy.spring.controller;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.spring.dto.BookDto;
import edu.ssafy.spring.dto.MemberDto;
import edu.ssafy.spring.service.BookService;
import edu.ssafy.spring.util.PageNavigation;
import edu.ssafy.spring.util.PaggingUtil;

@Controller
@RequestMapping("/book")
public class BookController {
	
	private BookService service;
	@Autowired
	public BookController(BookService service) {
		this.service=service;
	}
	

	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/isbncheck/{isbn}")
	public @ResponseBody Map<String, String> idCheck(@PathVariable("isbn") String isbn) throws Exception{
		BookDto dto = new BookDto();
		dto.setIsbn(isbn);
		BookDto book = service.bookView(dto);
		Map<String, String> map = new HashMap<String,String>();
		System.out.println(book);
		map.put("result", book==null?"사용하실 수 있는 ISBN입니다":"사용하실 수 없는 ISBN입니다");
		return map;
	}
	
	@GetMapping("/list")
	public ModelAndView BookList(String pg, String spp) {
		ModelAndView mav= new ModelAndView();
		
		int currentPage = pg == null ? 1 : Integer.parseInt(pg);
		currentPage = currentPage == 0 ? 1 : currentPage;
		int sizePerPage = spp == null ? PaggingUtil.sizePerPage : Integer.parseInt(spp);
		try {
			Map<String,Integer>map = new HashMap<String, Integer>();
			map.put("currentPage", (currentPage-1)*sizePerPage);
			map.put("sizePerPage", sizePerPage);
			List<BookDto> list = service.bookList(map);
			PageNavigation pageNavigation = service.makePageNavigation(currentPage, sizePerPage);
			mav.addObject("navigation", pageNavigation);
			mav.addObject("list",list);
			mav.setViewName("book/listbook");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	}
	
	@GetMapping("/register")
	public String BookRegister() {
		return "/book/regform";
	}
	
	@PostMapping("/register")
	public ModelAndView BookRegister(String isbn, String author,String title,String price, MultipartFile[] upfile, String directoryPath) {
		ModelAndView mav= new ModelAndView();
		try {
			String realPath = servletContext.getRealPath("/upload");
			System.out.println("REALPATH :"+realPath);
			String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
			String saveFolder = realPath+File.separator+today;
			File folder = new File(saveFolder);
			if(!folder.exists()) {
				folder.mkdirs();
			}
			MultipartFile mfile=upfile[0];
			String originalFilename = mfile.getOriginalFilename();
			
			BookDto bookDto=new BookDto(isbn,author,title,price,folder.toString()+File.separator+originalFilename);
			mfile.transferTo(new File(folder,originalFilename));
			//bookDto.setUpfile(upfile[0].toString());
			int res = service.bookRegister(bookDto);
			mav.setViewName("redirect:/book/list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	}
	
	@PostMapping("/delete")
	public ModelAndView BookDelete(@ModelAttribute BookDto dto, ModelAndView mav) {
		try {
			System.out.println(dto.getIsbn());
			int res = service.bookDelete(dto);
			mav.setViewName("redirect:/book/list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	};
	
	@PostMapping("/deletes")
	public ModelAndView BookDeletes(String[] isbn , ModelAndView mav)  {
		try {
			service.bookDeletes(isbn);
			mav.setViewName("redirect:/book/list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	};
	
	@GetMapping("/view")
	public ModelAndView BookView(BookDto dto, ModelAndView mav) {
		try {
			BookDto book= service.bookView(dto);
			mav.addObject("book", book);
			mav.setViewName("book/viewbook");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		
		return mav;
	};
	
	@PostMapping("/update")
	public ModelAndView BookUpdate(@ModelAttribute() BookDto dto, ModelAndView mav,HttpServletRequest req) {
		try {
			int res = service.bookUpdate(dto);
			mav.setViewName("redirect:/book/list");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	};
}
