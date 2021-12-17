package com.test.ur.app.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ur.app.dao.URN002Dao;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URN002Dto;
import com.test.ur.app.services.URN002Service;

@Service
public class URN002ServiceImpl implements URN002Service {

	@Autowired
	public URN002Dao dao;
	
	// 리스트+페이징
	@Override
	public List<URN002Dto> findAll(int startnum) {
		return dao.findAll(startnum);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return dao.getTotal();
	}
	
	// 상세페이지
	@Override
	public URN002Dto findDetail(int notice_registerNo) {
		// TODO Auto-generated method stub
		return dao.findDetail(notice_registerNo);
	}
	
	// 지역코드
	@Override
	public List<CodeDto> codeAList() {
		List<CodeDto> list = dao.codeAList();
		return list;
	}
	
	// 카테고리
	@Override
	public List<CodeDto> codeCList() {
		List<CodeDto> list = dao.codeCList();
		return list;
	}

	// 등록
	@Override
	public int createNotice(URN002Dto createNotice) {
		return dao.createNotice(createNotice);
	}
	
	// 수정시 내용 불러오기
	@Override
	public URN002Dto getNotice(int notice_registerNo) {
		return dao.getNotice(notice_registerNo);
	}
	
	// 수정
	@Override
	public int updateNotice(URN002Dto updateNotice) {
		return dao.updateNotice(updateNotice);
	}
}
