package com.test.ur.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB010Dto;
import com.test.ur.app.mapper.URB010Mapper;


@Repository
public class URB010Dao {
	
	@Autowired
	SqlSession sqlSession;
	// bean 객체에 있는 것과 이 선언된 것을 연결해서 사용하기 위해서 Autowired를 선언해줌
	
	public URB010Dto findDetail(int community_registerNo) {
		URB010Mapper mapper = sqlSession.getMapper(URB010Mapper.class);
		URB010Dto list = mapper.findDetail(community_registerNo);
		return list;
	}
	
	public List<URB010Dto> findAll(int startnum){
		URB010Mapper mapper = sqlSession.getMapper(URB010Mapper.class);
		List<URB010Dto> list = mapper.findAll(startnum);
		return list;
	}
	
	public List<URB010Dto> findAllByBuildNo(int buildNo){
		URB010Mapper mapper = sqlSession.getMapper(URB010Mapper.class);
		List<URB010Dto> list = mapper.findAllByBuildNo(buildNo);
		return list;
	}
	
	public int getTotal() {
		return sqlSession.getMapper(URB010Mapper.class).getTotal();
	}
	
	public List<CodeDto> codeAList(){
		return sqlSession.getMapper(URB010Mapper.class).codeAList();
	}
	
	public List<CodeDto> codeCList(){
		return sqlSession.getMapper(URB010Mapper.class).codeCList();
	}
	
	public int createCommunity(URB010Dto createCommunity) {
		URB010Mapper mapper = sqlSession.getMapper(URB010Mapper.class);
		int cc = mapper.createCommunity(createCommunity);
		return cc;
	}
	
	public URB010Dto getCommunity(int community_registerNo) {
		URB010Mapper mapper = sqlSession.getMapper(URB010Mapper.class);
		URB010Dto dto = mapper.getCommunity(community_registerNo);
		return dto;
	}
	
	public int updateCommunity(URB010Dto updateCommunity) {
		URB010Mapper mapper = sqlSession.getMapper(URB010Mapper.class);
		int uc = mapper.updateCommunity(updateCommunity);
		return uc;
	}
	
	public int removeCommunity(int removeCommunity) {
		URB010Mapper mapper = sqlSession.getMapper(URB010Mapper.class);
		int rn = mapper.removeCommunity(removeCommunity);
		return rn;
	}
	
	
	public int createReply(URB010Dto createReply) {
		URB010Mapper mapper = sqlSession.getMapper(URB010Mapper.class);
		int cr = mapper.createReply(createReply);
		return cr;
	}


}
