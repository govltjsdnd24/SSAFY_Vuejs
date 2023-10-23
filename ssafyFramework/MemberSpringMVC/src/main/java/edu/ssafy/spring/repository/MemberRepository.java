package edu.ssafy.spring.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.ssafy.spring.dto.MemberDto;

public interface MemberRepository {
	int memberInsert(MemberDto memberDto) throws SQLException;
	List<MemberDto> memberList() throws SQLException;
	MemberDto memberView(MemberDto memberDto) throws SQLException;
	int memberUpdate(MemberDto memberDto) throws SQLException;
	int memberDelete(MemberDto memberDto) throws SQLException;
	MemberDto memberLogin(String username, String userpwd) throws SQLException;
	int deleteMembers(String[] checkList) throws SQLException;
	int idCheck(String userId) throws SQLException;
}
