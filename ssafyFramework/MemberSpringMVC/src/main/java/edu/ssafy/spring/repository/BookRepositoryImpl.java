package edu.ssafy.spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.spring.dto.BookDto;
import edu.ssafy.spring.dto.MemberDto;
import edu.ssafy.spring.util.PageNavigation;

@Repository
public class BookRepositoryImpl implements BookRepository {
	
	@Autowired
	private DataSource source;

	@Override
	public int bookRegister(BookDto dto) throws Exception {
		Connection conn = source.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into book(isbn, author, title, price, upfile) ");
		sb.append(" values(?,?,?,?,?) ");
		PreparedStatement stmt = conn.prepareStatement(sb.toString());
		stmt.setString(1, dto.getIsbn());
		stmt.setString(2, dto.getAuthor());
		stmt.setString(3, dto.getTitle());
		stmt.setString(4, dto.getPrice());
		stmt.setString(5, dto.getUpfile());
		int res = stmt.executeUpdate();
		conn.close();
		return res;
	}

	@Override
	public List<BookDto> bookList() throws Exception {
		Connection conn = source.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select isbn, author, title, price, upfile ");
		sb.append(" from book ");
		
		PreparedStatement stmt = conn.prepareStatement(sb.toString());
		ResultSet rs = stmt.executeQuery();
		List<BookDto> list = new ArrayList<BookDto>();
		while(rs.next()) {
			list.add(new BookDto(rs.getString("isbn"), rs.getString("author"), rs.getString("title"), rs.getString("price"), rs.getString("upfile")));
		}
		conn.close();
		return list;
	}

	@Override
	public List<BookDto> bookList(Map<String, Integer> map) throws Exception {
		int currentPage = (int) map.get("currentPage");
		int sizePerPage = (int) map.get("sizePerPage");
		
		Connection conn = source.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select isbn, author, title, price, upfile ");
		sb.append(" from book ");
		sb.append(" limit ?, ?" );
		
		PreparedStatement stmt = conn.prepareStatement(sb.toString());
		stmt.setInt(1, currentPage);
		stmt.setInt(2, sizePerPage);
		ResultSet rs = stmt.executeQuery();
		
		List<BookDto> list = new ArrayList<BookDto>();
		while(rs.next()) {
			list.add(new BookDto(rs.getString("isbn"), rs.getString("author"), rs.getString("title"), rs.getString("price"), rs.getString("upfile")));
		}
		conn.close();
		return list;
	}

	@Override
	public BookDto bookView(BookDto dto) throws Exception {
		Connection conn = source.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select isbn, author, title, price, upfile ");
		sb.append(" from book ");
		sb.append(" where isbn = ? ");
		PreparedStatement stmt = conn.prepareStatement(sb.toString());
		stmt.setString(1, dto.getIsbn());
		ResultSet rs = stmt.executeQuery();
		BookDto book = null;
		if(rs.next()) {
			book = new BookDto();
			book.setIsbn(rs.getString("isbn"));
			book.setAuthor(rs.getString("author")); 
			book.setTitle(rs.getString("title"));
			book.setPrice(rs.getString("price"));
			book.setUpfile(rs.getString("upfile"));
		}
		conn.close();
		return book;
	}

	@Override
	public int bookUpdate(BookDto dto) throws Exception {
		Connection conn = source.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" update book set author = ?, title= ?, price= ?, upfile = ? ");
		sb.append(" where isbn = ?  ");
		PreparedStatement stmt = conn.prepareStatement(sb.toString());
		stmt.setString(1, dto.getAuthor());
		stmt.setString(2, dto.getTitle());
		stmt.setString(3, dto.getPrice());
		stmt.setString(4, dto.getUpfile());
		stmt.setString(5, dto.getIsbn());
		int res = stmt.executeUpdate();
		conn.close();
		return res;
	}

	@Override
	public int bookDelete(BookDto dto) throws Exception {
		Connection conn = source.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" delete from book ");
		sb.append(" where isbn = ?  ");
		PreparedStatement stmt = conn.prepareStatement(sb.toString());
		stmt.setString(1, dto.getIsbn());
		int res = stmt.executeUpdate();
		conn.close();
		return res;
	}


	@Override
	public int bookCnt() throws Exception {
		Connection conn = source.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) as cnt from book  ");
		PreparedStatement stmt = conn.prepareStatement(sb.toString());
		ResultSet rs = stmt.executeQuery();
		int cnt = 0;
		if(rs.next()) {
			cnt = rs.getInt("cnt");
		}
		conn.close();
		return cnt;
	}


}

