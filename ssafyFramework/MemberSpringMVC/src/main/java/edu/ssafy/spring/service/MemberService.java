package edu.ssafy.spring.service;

import java.sql.SQLException;
import java.util.List;

import edu.ssafy.spring.dto.MemberDto;
import edu.ssafy.spring.repository.MemberRepository;

public interface MemberService{
	int memberInsert(MemberDto memberDto) throws SQLException;
	List<MemberDto> memberList() throws SQLException;
	MemberDto memberView(MemberDto memberDto) throws SQLException;
	int memberUpdate(MemberDto memberDto) throws SQLException;
	int memberDelete(MemberDto memberDto) throws SQLException;
	MemberDto memberLogin(String username, String userpwd) throws SQLException;
	int deleteMembers(String[] checkList) throws SQLException;
	int idCheck(String userId) throws SQLException;
}
