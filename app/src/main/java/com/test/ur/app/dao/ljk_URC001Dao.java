package com.test.ur.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.ur.app.dto.ljk_URC001Dto;
import com.test.ur.app.mapper.ljk_URC001Mapper;

@Repository
public class ljk_URC001Dao {
	
	@Autowired
	SqlSession sqlSession;
	// bean 객체에 있는 것과 이 선언된 것을 연결해서 사용하기 위해서 Autowired를 선언해줌

	public List<ljk_URC001Dto> getList(int startnum){
		ljk_URC001Mapper mapper = sqlSession.getMapper(ljk_URC001Mapper.class);
		List<ljk_URC001Dto> list = mapper.getList(startnum);
		return list;
	}
	
	public int getTotal() {
		return sqlSession.getMapper(ljk_URC001Mapper.class).getTotal();
	}
	
	public int insertBoard(ljk_URC001Dto vo) {
		ljk_URC001Mapper mapper = sqlSession.getMapper(ljk_URC001Mapper.class);
		return mapper.insertBoard(vo);
	}
	
	public ljk_URC001Dto get(int consulting_registerNo) {
		ljk_URC001Mapper mapper = sqlSession.getMapper(ljk_URC001Mapper.class);
		return mapper.get(consulting_registerNo);
	}
	
	public int update(ljk_URC001Dto vo) {
		ljk_URC001Mapper mapper = sqlSession.getMapper(ljk_URC001Mapper.class);
		return mapper.update(vo);
	}
	
	public ljk_URC001Dto checkpassword(ljk_URC001Dto vo) {
		ljk_URC001Mapper mapper = sqlSession.getMapper(ljk_URC001Mapper.class);
		return mapper.checkpassword(vo);
	}
	
	public int remove(int consulting_registerNo) {
		ljk_URC001Mapper mapper = sqlSession.getMapper(ljk_URC001Mapper.class);
		return mapper.remove(consulting_registerNo);
	}
}
