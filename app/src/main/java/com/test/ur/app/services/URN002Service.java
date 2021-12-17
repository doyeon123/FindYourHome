package com.test.ur.app.services;

import java.util.List;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URN002Dto;

public interface URN002Service {

	public URN002Dto findDetail(int notice_registerNo);

	public List<URN002Dto> findAll(int startnum);
	
	public int getTotal();
	
	public List<CodeDto> codeAList();
	
	public List<CodeDto> codeCList();
	
	int createNotice(URN002Dto createNotice);
	
	public URN002Dto getNotice(int notice_registerNo);
	
	int updateNotice(URN002Dto updateNotice);
}
