package edu.ssafy.spring.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.spring.dto.BookDto;

@Repository("BookRepositoryMybatisImpl")
public class BookRepositoryMybatisImpl implements BookRepository{

	SqlSession session;
	
	@Autowired
	public BookRepositoryMybatisImpl(SqlSession session){
		this.session = session;
	}
	
	String ns = "edu.ssafy.spring.repository.BookRepository.";
	
	@Override
	public int bookRegister(BookDto dto) throws Exception {
		return session.insert(ns+"bookRegister",dto);
	}

	@Override
	public List<BookDto> bookList() throws Exception {
		return session.selectList(ns+"bookList");
	}

	@Override
	public List<BookDto> bookList(Map<String, Integer> map) throws Exception {
		return session.selectList(ns+"bookListPage",map);
	}

	@Override
	public BookDto bookView(BookDto dto) throws Exception {
		return session.selectOne(ns+"bookView",dto);
	}

	@Override
	public int bookUpdate(BookDto dto) throws Exception {
		return session.update(ns+"bookUpdate",dto);
	}

	@Override
	public int bookDelete(BookDto dto) throws Exception {
		return session.delete(ns+"bookDelete",dto);
	}

	@Override
	public int bookCnt() throws Exception {
		return session.selectOne(ns+"bookCnt");
	}

}
