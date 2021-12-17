package com.test.ur.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URN002Dto;
import com.test.ur.app.mapper.URN002Mapper;

@Repository
public class URN002Dao {
	
	@Autowired
	SqlSession sqlSession;
	// bean 객체에 있는 것과 이 선언된 것을 연결해서 사용하기 위해서 Autowired를 선언해줌
	
	public URN002Dto findDetail(int notice_registerNo) {
		URN002Mapper mapper = sqlSession.getMapper(URN002Mapper.class);
		URN002Dto list = mapper.findDetail(notice_registerNo);
		return list;
	}
	
	public List<URN002Dto> findAll(int startnum){
		URN002Mapper mapper = sqlSession.getMapper(URN002Mapper.class);
		List<URN002Dto> list = mapper.findAll(startnum);
		return list;
	}
	
	public int getTotal() {
		return sqlSession.getMapper(URN002Mapper.class).getTotal();
	}
	
	public List<CodeDto> codeAList(){
		return sqlSession.getMapper(URN002Mapper.class).codeAList();
	}
	
	public List<CodeDto> codeCList(){
		return sqlSession.getMapper(URN002Mapper.class).codeCList();
	}
	
	public int createNotice(URN002Dto createNotice) {
		URN002Mapper mapper = sqlSession.getMapper(URN002Mapper.class);
		int cn = mapper.createNotice(createNotice);
		return cn;
	}
	
	public URN002Dto getNotice(int notice_registerNo) {
		URN002Mapper mapper = sqlSession.getMapper(URN002Mapper.class);
		URN002Dto dto = mapper.getNotice(notice_registerNo);
		return dto;
	}
	
	public int updateNotice(URN002Dto updateNotice) {
		URN002Mapper mapper = sqlSession.getMapper(URN002Mapper.class);
		int un = mapper.updateNotice(updateNotice);
		return un;
	}
}
