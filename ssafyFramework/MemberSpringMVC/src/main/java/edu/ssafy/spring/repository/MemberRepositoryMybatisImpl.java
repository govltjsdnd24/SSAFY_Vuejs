package edu.ssafy.spring.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ssafy.spring.dto.MemberDto;

@Repository("MemberRepositoryMybatis")
public class MemberRepositoryMybatisImpl implements MemberRepository{
	
	SqlSession session;
	
	@Autowired
	public MemberRepositoryMybatisImpl(SqlSession session){
		this.session = session;
		System.out.println(session);
	}
	
	String ns = "edu.ssafy.spring.repository.MemberRepository.";
	@Override
	public int memberInsert(MemberDto dto) throws Exception {
		return session.insert(ns+"memberInsert",dto);
		
	}

	@Override
	public List<MemberDto> memberList() throws Exception {
		return session.selectList(ns+"memberList");
	
	}

	@Override
	public List<MemberDto> memberList(Map<String, Integer> map) throws Exception {
		return session.selectList(ns+"memberListPage",map);
		
	}

	@Override
	public MemberDto memberView(MemberDto dto) throws Exception {
		return session.selectOne(ns+"memberView",dto);
	}

	@Override
	public int memberUpdate(MemberDto dto) throws Exception {
		return session.update(ns+"memberUpdate", dto);
	}

	@Override
	public int memberDelete(MemberDto dto) throws Exception {
		return session.delete(ns+"memberDelete", dto);
	}

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		return session.selectOne(ns+"login",dto);
	}

	@Override
	public int memberCnt() throws Exception {
		return session.selectOne(ns+"memberCnt");
	}

}

