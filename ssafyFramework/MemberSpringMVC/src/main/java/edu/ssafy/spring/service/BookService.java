/**
 * 
 */
package edu.ssafy.spring.service;

import java.util.List;
import java.util.Map;

import edu.ssafy.spring.dto.BookDto;
import edu.ssafy.spring.util.PageNavigation;

public interface BookService {
	int bookRegister(BookDto dto) throws Exception;
	List<BookDto> bookList() throws Exception;
	List<BookDto> bookList(Map<String,Integer> map) throws Exception;
	BookDto bookView(BookDto dto) throws Exception;
	int bookUpdate(BookDto dto) throws Exception;
	int bookDelete(BookDto dto) throws Exception;
	
	boolean bookDeletes(String[] isbns)  throws Exception;
	PageNavigation makePageNavigation(int currentPage, int sizePerPage)  throws Exception;
}
