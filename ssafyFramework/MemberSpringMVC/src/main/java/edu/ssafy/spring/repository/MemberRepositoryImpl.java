package edu.ssafy.spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.spring.dto.MemberDto;

@Repository
public class MemberRepositoryImpl implements MemberRepository{

	private DataSource source;
	
	@Autowired
	public MemberRepositoryImpl(DataSource source) {
		this.source=source;
	}
	
	@Override
	public int idCheck(String userId) throws SQLException {
		int cnt = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = source.getConnection();
			StringBuilder loginMember = new StringBuilder();
			loginMember.append("select count(user_id) \n");
			loginMember.append("from members \n");
			loginMember.append("where user_id = ? ");
			pstmt = conn.prepareStatement(loginMember.toString());
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} finally {
			conn.close();
		}
		return cnt;
	}
	
	@Override
	public int memberInsert(MemberDto memberDto) throws SQLException {
		Connection conn= source.getConnection();
		StringBuilder sql= new StringBuilder();
		sql.append("INSERT INTO members(id,pw,name,age,addr)");
		sql.append("values(?,?,?,?,?)");
		conn.prepareStatement(sql.toString());
		PreparedStatement stmt= conn.prepareStatement(sql.toString());
		stmt.setString(1, memberDto.getId());
		stmt.setString(2, memberDto.getPw());
		stmt.setString(3, memberDto.getName());
		stmt.setString(4, memberDto.getAge());
		stmt.setString(5, memberDto.getAddr());
		int res=stmt.executeUpdate();
		conn.close();
		return res;
	}

	@Override
	public List<MemberDto> memberList() throws SQLException {
		Connection conn= source.getConnection();
		StringBuilder sql= new StringBuilder();
		sql.append("SELECT id,pw,name,age,addr ");
		sql.append("FROM members");
		
		conn.prepareStatement(sql.toString());
		PreparedStatement stmt= conn.prepareStatement(sql.toString());
		ResultSet rs = stmt.executeQuery();
		
		List<MemberDto>list = new ArrayList<MemberDto>();
		while(rs.next()) {
			list.add(new MemberDto(rs.getString("id"),rs.getString("pw"),rs.getString("name"),rs.getString("age"),rs.getString("addr")));
		}
		conn.close();
		return list;
	}

	@Override
	public MemberDto memberView(MemberDto memberDto) throws SQLException {
		Connection conn= source.getConnection();
		StringBuilder sql= new StringBuilder();
		sql.append("SELECT id,pw,name,age,addr ");
		sql.append("FROM members ");
		sql.append("where id=?");
		
		PreparedStatement stmt= conn.prepareStatement(sql.toString());
		stmt.setString(1, memberDto.getId());
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			memberDto.setId(rs.getString("id"));
			memberDto.setPw(rs.getString("pw"));
			memberDto.setName(rs.getString("name"));
			memberDto.setAge(rs.getString("age"));
			memberDto.setAddr(rs.getString("addr"));
		}
		conn.close();
		return memberDto;
	}

	@Override
	public int memberUpdate(MemberDto memberDto) throws SQLException {
		Connection conn= source.getConnection();
		StringBuilder sql= new StringBuilder();
		sql.append("UPDATE members SET pw=?,name=?,age=?,addr=? ");
		sql.append("WHERE id=? ");
		conn.prepareStatement(sql.toString());
		PreparedStatement stmt= conn.prepareStatement(sql.toString());
		stmt.setString(1, memberDto.getPw());
		stmt.setString(2, memberDto.getName());
		stmt.setString(3, memberDto.getAge());
		stmt.setString(4, memberDto.getAddr());
		stmt.setString(5, memberDto.getId());
		int res=stmt.executeUpdate();
		conn.close();
		return res;
	}

	@Override
	public int memberDelete(MemberDto memberDto) throws SQLException {
		Connection conn= source.getConnection();
		StringBuilder sql= new StringBuilder();
		sql.append("DELETE FROM members ");
		sql.append("WHERE id=? ");

		PreparedStatement stmt= conn.prepareStatement(sql.toString());
		stmt.setString(1, memberDto.getId());
		int res=stmt.executeUpdate();
		conn.close();
		return res;
	}

	@Override
	public MemberDto memberLogin(String username, String userpwd) throws SQLException {
		Connection conn= source.getConnection();
		StringBuilder sql= new StringBuilder();
		sql.append("SELECT id,pw,name,age,addr ");
		sql.append("FROM members ");
		sql.append("where id=? AND pw =?");
		
		PreparedStatement stmt= conn.prepareStatement(sql.toString());
		stmt.setString(1, username);
		stmt.setString(2,userpwd);
		ResultSet rs = stmt.executeQuery();
		
		MemberDto memberDto=new MemberDto();
		if(rs.next()) {
			memberDto.setId(rs.getString("id"));
			memberDto.setPw(rs.getString("pw"));
			memberDto.setName(rs.getString("name"));
			memberDto.setAge(rs.getString("age"));
			memberDto.setAddr(rs.getString("addr"));
		}
		System.out.println(memberDto);
		conn.close();
		return memberDto;
	}

	@Override
	public int deleteMembers(String[] checkList) throws SQLException {
		Connection conn= source.getConnection();
		StringBuilder sql= new StringBuilder();

		sql.append("DELETE FROM members ");
		sql.append("WHERE 0 ");
		for (int i = 0; i < checkList.length; i++) {
			sql.append("OR id=?");
		}
		
		PreparedStatement stmt= conn.prepareStatement(sql.toString());
		int counter=1;
		for (int i = 0; i < checkList.length; i++) {
			stmt.setString(counter++, checkList[i]);
		}
		
		int res=stmt.executeUpdate();
		conn.close();
		return res;
	}
	
}
