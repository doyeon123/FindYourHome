package com.test.ur.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.mapper.URB002Mapper;

@Repository
public class URB002Dao {

	@Autowired
	SqlSession sqlSession;
	
	public List<URB002Dto> buildList(int startnum, int endnum, String search_codeA, String search_codeB, String search_codeC, String search_name) {
		return sqlSession.getMapper(URB002Mapper.class).buildList(startnum, endnum, search_codeA, search_codeB, search_codeC, search_name);
	}
	
	public int getTotal() {
		return sqlSession.getMapper(URB002Mapper.class).getTotal();
	}
	
	public List<CodeDto> codeAList() {
		return sqlSession.getMapper(URB002Mapper.class).codeAList();
	}
	
	public List<CodeDto> codeBListAll() {
		return sqlSession.getMapper(URB002Mapper.class).codeBListAll();
	}
	
	public List<CodeDto> codeCListAll() {
		return sqlSession.getMapper(URB002Mapper.class).codeCListAll();
	}
	
	public List<CodeDto> codeEList(){
		return sqlSession.getMapper(URB002Mapper.class).codeEList();
	}
	
	public List<CodeDto> codeBList(String codeA) {
		return sqlSession.getMapper(URB002Mapper.class).codeBList(codeA);
	}
	
	public List<CodeDto> codeCList(String codeA, String codeB){
		return sqlSession.getMapper(URB002Mapper.class).codeCList(codeA, codeB);
	}
	
	public void Register(Map<String, Object> map) {
		URB002Mapper mapper = sqlSession.getMapper(URB002Mapper.class);
		mapper.Register(map);
	}
	
	public URB002Dto detail(int zone_registerNo) {
		URB002Mapper mapper = sqlSession.getMapper(URB002Mapper.class);
		return mapper.detail(zone_registerNo);
	}
	
	public void Update(Map<String, Object> map) {
		URB002Mapper mapper = sqlSession.getMapper(URB002Mapper.class);
		mapper.Update(map);
	}
}
