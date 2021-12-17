package com.test.ur.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.test.ur.app.dto.URO002Dto;

import com.test.ur.app.mapper.URO002Mapper;

/**
 * ������ DAO
 */

@Repository
public class URO002Dao {

	@Autowired
	SqlSession sqlSession;
	
	public ArrayList<URO002Dto> getSalesList() {
		
		URO002Mapper mapper = sqlSession.getMapper(URO002Mapper.class);
		
		ArrayList<URO002Dto> salesList = new ArrayList<URO002Dto>();
		
		salesList = mapper.getSalesList();
		
		return salesList;
	}

	public int insertOffice(URO002Dto salesOffice) {
		
		URO002Mapper mapper = sqlSession.getMapper(URO002Mapper.class);
		
		int cnt = mapper.insertOffice(salesOffice);
		
		
		
		return cnt;
	}
	
	public URO002Dto readOfficeDetails(int sales_registerNo) {
		URO002Mapper mapper = sqlSession.getMapper(URO002Mapper.class);
		
		URO002Dto salesOffice = mapper.readOfficeDetails(sales_registerNo);
		
		return salesOffice;
	}

	public int updateOffice(URO002Dto salesOffice) {
	
		URO002Mapper mapper = sqlSession.getMapper(URO002Mapper.class);
		
		int cnt = mapper.updateOffice(salesOffice);
		
		
		return cnt;
	}
	
	
	
	////////////////////////////////////////////////////////////////

	public List<URO002Dto> search(int startnum, int endnum, String zone_entireRegionalCode, String zone_areaRegionalCode, String zone_stateRegionalCode, String search_name) {
		
		return sqlSession.getMapper(URO002Mapper.class).search(startnum, endnum, zone_entireRegionalCode, zone_areaRegionalCode, zone_stateRegionalCode, search_name);
	}
	
	
	
	//////////////
	public List<URO002Dto> officeList(int startnum, int endnum) {
		return sqlSession.getMapper(URO002Mapper.class).officeList(startnum, endnum);
	}

	public int getTotal() {
		return sqlSession.getMapper(URO002Mapper.class).getTotal();

	}



	
	
}
