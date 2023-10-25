package edu.ssafy.spring.repository;

import java.util.List;
import java.util.Map;

import edu.ssafy.spring.dto.BookDto;
import edu.ssafy.spring.dto.MemberDto;
import edu.ssafy.spring.util.PageNavigation;

public interface BookRepository {
	int bookRegister(BookDto dto) throws Exception;
	List<BookDto> bookList() throws Exception;
	List<BookDto> bookList(Map<String,Integer> map) throws Exception;
	BookDto bookView(BookDto dto) throws Exception;
	int bookUpdate(BookDto dto) throws Exception;
	int bookDelete(BookDto dto) throws Exception;
	
	int bookCnt()  throws Exception;
}
