package com.test.ur.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.dto.URU002Dto;
import com.test.ur.app.mapper.URB002Mapper;
import com.test.ur.app.mapper.URU002Mapper;

@Repository
public class URU002Dao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<URU002Dto> findAll() {
		URU002Mapper mapper = sqlSession.getMapper(URU002Mapper.class);
		List<URU002Dto> list = mapper.findAll();
		return list;
	}
	
	public List<CodeDto> kokuseki() {
		URU002Mapper mapper = sqlSession.getMapper(URU002Mapper.class);
		List<CodeDto> list = mapper.kokuseki();
		return list;
	}
	
	public int insertapplicant(URU002Dto applicant) {
		URU002Mapper mapper = sqlSession.getMapper(URU002Mapper.class);
		
		int cnt = mapper.insertapplicant(applicant);
		
		return cnt;
		
	}

	public URU002Dto readIndetails(int applicant_applyNo) {
		// TODO Auto-generated method stub
		URU002Mapper mapper = sqlSession.getMapper(URU002Mapper.class);
		URU002Dto applicantIn = mapper.readInDetails(applicant_applyNo);
		
		
		return applicantIn;
	}
	
	public URU002Dto getReceipt(int receipt_registerNo) {
		URU002Mapper mapper = sqlSession.getMapper(URU002Mapper.class);
		URU002Dto dto = mapper.getReceipt(receipt_registerNo);
		return dto;
	}
	
	
	public int updateReceipt(URU002Dto updateReceipt) {
		URU002Mapper mapper = sqlSession.getMapper(URU002Mapper.class);
		System.out.println("111 / " + updateReceipt.getApplicant_applyNo());
		try {
			int a = mapper.updateReceipt(updateReceipt);
			System.out.println("a============"+a);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return 1;
		
	}

	public List<URB002Dto> bulidSearch(String zone_entireRegionalCode, String zone_areaRegionalCode, 
			String zone_stateRegionalCode, String zone_officalName) {
		URU002Mapper mapper = sqlSession.getMapper(URU002Mapper.class);
		List<URB002Dto> bulidSearch = mapper.buildSearch(zone_entireRegionalCode, zone_areaRegionalCode, zone_stateRegionalCode, zone_officalName);
		return bulidSearch;
		
	}

	

}
