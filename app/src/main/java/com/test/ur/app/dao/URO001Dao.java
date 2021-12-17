package com.test.ur.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.ur.app.dto.URO001Dto;
import com.test.ur.app.mapper.URO001Mapper;

@Repository
public class URO001Dao {

	@Autowired
	SqlSession sqlSession;
	

	public List<URO001Dto> findAll() {
		URO001Mapper mapper = sqlSession.getMapper(URO001Mapper.class);
		List<URO001Dto> list = mapper.findAll();
		return list;
	}


	public int getTotal(String citycode) {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<URO001Dto> getOfficeListByCity(String citycode) {
		// TODO Auto-generated method stub
		URO001Mapper mapper = sqlSession.getMapper(URO001Mapper.class);
		return mapper.getOfficeListByCity(citycode);
	}


	public URO001Dto getOfficeById(int id) {
		// TODO Auto-generated method stub
		URO001Mapper mapper = sqlSession.getMapper(URO001Mapper.class);
		return mapper.getOfficeById(id);
	}

}
