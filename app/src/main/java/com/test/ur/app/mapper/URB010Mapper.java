package com.test.ur.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB010Dto;
import com.test.ur.app.dto.URN002Dto;

public interface URB010Mapper {

	// 숫자만 받아오면 되니까 List아님
	public URB010Dto findDetail(int community_registerNo);
	
	List<URB010Dto> findAll(@Param ("startnum") int startnum);
	
	int getTotal();
	
	List<CodeDto> codeAList();
	
	List<CodeDto> codeCList();
	
	int createCommunity(URB010Dto createCommunity);
	
	public URB010Dto getCommunity(int community_registerNo);
	
	int updateCommunity(URB010Dto updateCommunity);

	public List<URB010Dto> findAllByBuildNo(int buildNo);
	
	int removeCommunity(URB010Dto removeCommunity);

	public int removeCommunity(int removeCommunity);

	public int createReply(URB010Dto createReply);
}
