package com.test.ur.app.servicesImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ur.app.dao.URB002Dao;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.services.URB002Service;

@Service
public class URB002ServiceImp implements URB002Service{

	@Autowired
	private URB002Dao dao;
	
	@Override
	public List<URB002Dto> buildList(int startnum, int endnum, String search_codeA, String search_codeB, String search_codeC, String search_name) {
		// TODO Auto-generated method stub
		List<URB002Dto> list = dao.buildList(startnum, endnum, search_codeA, search_codeB, search_codeC, search_name);
		return list;
	}
	
	@Override
	public int getTotal() {
		int totalPage = dao.getTotal();
		return totalPage;
	}

	@Override
	public List<CodeDto> codeAList() {
		// TODO Auto-generated method stub
		List<CodeDto> list = dao.codeAList();
		return list;
	}

	@Override
	public List<CodeDto> codeBList(String codeA) {
		// TODO Auto-generated method stub
		List<CodeDto> list = dao.codeBList(codeA);
		return list;
	}

	@Override
	public List<CodeDto> codeCList(String codeA, String codeB) {
		// TODO Auto-generated method stub
		List<CodeDto> list = dao.codeCList(codeA, codeB);
		return list;
	}

	@Override
	public void Register(Map<String, Object> map) {
		// TODO Auto-generated method stub
		dao.Register(map);
	}

	@Override
	public URB002Dto detail(int zone_registerNo) {
		// TODO Auto-generated method stub
		URB002Dto list = dao.detail(zone_registerNo);
		return list;
	}

	@Override
	public List<CodeDto> codeEList() {
		// TODO Auto-generated method stub
		List<CodeDto> list = dao.codeEList();
		return list;
	}

	@Override
	public List<CodeDto> codeBListAll() {
		// TODO Auto-generated method stub
		List<CodeDto> list = dao.codeBListAll();
		return list;
	}

	@Override
	public List<CodeDto> codeCListAll() {
		// TODO Auto-generated method stub
		List<CodeDto> list = dao.codeCListAll();
		return list;
	}

	@Override
	public void Update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		dao.Update(map);
	}
}
