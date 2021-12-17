package com.test.ur.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URN002Dto;

public interface URN002Mapper {

	// 숫자만 받아오면 되니까 List아님
	public URN002Dto findDetail(int notice_registerNo);
	
	List<URN002Dto> findAll(@Param ("startnum") int startnum);
	
	int getTotal();
	
	List<CodeDto> codeAList();
	
	List<CodeDto> codeCList();
	
	int createNotice(URN002Dto createNotice);
	
	public URN002Dto getNotice(int notice_registerNo);
	
	int updateNotice(URN002Dto updateNotice);
}
