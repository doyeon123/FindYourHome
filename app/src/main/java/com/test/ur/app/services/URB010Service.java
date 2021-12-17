package com.test.ur.app.services;

import java.util.List;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB010Dto;

public interface URB010Service {

	public URB010Dto findDetail(int community_registerNo);

	public List<URB010Dto> findAll(int startnum);
	
	public int getTotal();
	
	public List<CodeDto> codeAList();
	
	public List<CodeDto> codeCList();
	
	int createCommunity(URB010Dto createCommunity);
	
	public URB010Dto getCommunity(int community_registerNo);
	
	int updateCommunity(URB010Dto updateCommunity);
	
	public List<URB010Dto> findAllByBuildNo(int buildNo);

	public int removeCommunity(int removeCommunity);

	public int createReply(URB010Dto dto);
	
}
