package edu.ssafy.spring.service;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ssafy.spring.dto.MemberDto;
import edu.ssafy.spring.repository.MemberRepository;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService {

	private MemberRepository repository;
	
	@Autowired
	public MemberServiceImpl(MemberRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public int memberInsert(MemberDto memberDto) throws SQLException {
		return repository.memberInsert(memberDto);
	}

	@Override
	public List<MemberDto> memberList() throws SQLException {
		return repository.memberList();
	}

	@Override
	public MemberDto memberView(MemberDto memberDto) throws SQLException {
		return repository.memberView(memberDto);
	}

	@Override
	public int memberUpdate(MemberDto memberDto) throws SQLException {
		return repository.memberUpdate(memberDto);
	}

	@Override
	public int memberDelete(MemberDto memberDto) throws SQLException {
		return repository.memberDelete(memberDto);
	}

	@Override
	public MemberDto memberLogin(String username, String userpwd) throws SQLException {
		return repository.memberLogin(username,userpwd);
	}

	@Override
	public int deleteMembers(String[] checkList) throws SQLException {
		return repository.deleteMembers(checkList);
	}

	@Override
	public int idCheck(String userId) throws SQLException {
		return repository.idCheck(userId);
	}


	
}
