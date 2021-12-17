package com.test.ur.app.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.ur.app.dto.ljk_URC002Dto;
import com.test.ur.app.mapper.ljk_URC002Mapper;



@Repository
public class ljk_URC002Dao {
	
	// bean 객체에 있는 것과 이 선언된 것을 연결해서 사용하기 위해서 Autowired를 선언해줌
	@Autowired
	SqlSession sqlSession;
	
	public ljk_URC002Dto get(int consulting_registerNo) {
		ljk_URC002Mapper mapper = sqlSession.getMapper(ljk_URC002Mapper.class);
		return mapper.get(consulting_registerNo);
	}
	
	
	
	
}
