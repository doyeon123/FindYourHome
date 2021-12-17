package com.test.ur.app.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ur.app.dao.URB010Dao;
import com.test.ur.app.dao.URN002Dao;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB010Dto;
import com.test.ur.app.dto.URN002Dto;
import com.test.ur.app.services.URB010Service;
import com.test.ur.app.services.URN002Service;

@Service
public class URB010ServiceImpl implements URB010Service {

	@Autowired
	public URB010Dao dao;
	
	
	@Override
	public List<URB010Dto> findAll(int startnum) {
		return dao.findAll(startnum);
	}
	
	@Override
	public List<URB010Dto> findAllByBuildNo(int buildNo) {
		return dao.findAllByBuildNo(buildNo);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return dao.getTotal();
	}
	
	@Override
	public URB010Dto findDetail(int community_registerNo) {
		// TODO Auto-generated method stub
		return dao.findDetail(community_registerNo);
	}
	
	@Override
	public List<CodeDto> codeAList() {
		List<CodeDto> list = dao.codeAList();
		return list;
	}
	
	@Override
	public List<CodeDto> codeCList() {
		List<CodeDto> list = dao.codeCList();
		return list;
	}



	@Override
	public int createCommunity(URB010Dto createCommunity) {
		return dao.createCommunity(createCommunity);
	}

	@Override
	public URB010Dto getCommunity(int community_registerNo) {
		return dao.getCommunity(community_registerNo);
	}

	@Override
	public int updateCommunity(URB010Dto updateCommunity) {
		return dao.updateCommunity(updateCommunity);
	}

	@Override
	public int removeCommunity(int removeCommunity) {
		return dao.removeCommunity(removeCommunity);
	}
	

	@Override
	public int createReply(URB010Dto createReply) {
		return dao.createReply(createReply);

	}
	



}
