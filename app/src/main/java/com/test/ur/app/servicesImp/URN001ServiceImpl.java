package com.test.ur.app.servicesImp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ur.app.dto.URN001Dto;
import com.test.ur.app.mapper.URN001Mapper;
import com.test.ur.app.services.URN001Service;


@Service
public class URN001ServiceImpl implements URN001Service{
	
	@Autowired
	private SqlSession sqlSession;
	
	private URN001Mapper mapper;
	
	public URN001ServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(URN001Mapper.class);
	}

	@Override
	public List<URN001Dto> findAll(int page) {
		// TODO Auto-generated method stub
		int startnum = (page-1)*10;
		int endnum = startnum + 10;
		return mapper.findAll(startnum,endnum);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return mapper.getTotal();
	}

	@Override
	public URN001Dto getNoticeById(int id) {
		// TODO Auto-generated method stub
		return mapper.getNoticeById(id);
	}
	
	
	
}
