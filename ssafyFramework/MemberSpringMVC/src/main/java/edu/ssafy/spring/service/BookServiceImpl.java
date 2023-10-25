package edu.ssafy.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.ssafy.spring.dto.BookDto;
import edu.ssafy.spring.dto.MemberDto;
import edu.ssafy.spring.repository.BookRepository;
import edu.ssafy.spring.util.PageNavigation;
import edu.ssafy.spring.util.PaggingUtil;

@Service
public class BookServiceImpl implements BookService {
	
	private BookRepository repository;
	
	@Autowired
	public BookServiceImpl(@Qualifier("BookRepositoryMybatisImpl")BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public int bookRegister(BookDto dto) throws Exception {
		return repository.bookRegister(dto);
	}

	@Override
	public List<BookDto> bookList() throws Exception {
		return repository.bookList();
	}

	@Override
	public List<BookDto> bookList(Map<String, Integer> map) throws Exception {
		return repository.bookList(map);
	}

	@Override
	public BookDto bookView(BookDto dto) throws Exception {
		return repository.bookView(dto);
	}

	@Override
	public int bookUpdate(BookDto dto) throws Exception {
		return repository.bookUpdate(dto);
	}

	@Override
	public int bookDelete(BookDto dto) throws Exception {
		return repository.bookDelete(dto);
	}

	@Override
	public boolean bookDeletes(String[] isbns) throws Exception {
		BookDto dto = new BookDto();
		for (String isbn: isbns) {
			dto.setIsbn(isbn);
			repository.bookDelete(dto);
		}
		return true;
	}

	@Override
	public PageNavigation makePageNavigation(int currentPage, int sizePerPage) throws Exception {
		int naviSize = PaggingUtil.naviSize;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalSize = repository.bookCnt();
		//pageNavigation.setTotalCount(totalSize);
		int totalPageSize = (totalSize - 1)/sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageSize);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

}
