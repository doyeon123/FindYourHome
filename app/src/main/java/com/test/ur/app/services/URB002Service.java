package com.test.ur.app.services;

import java.util.List;
import java.util.Map;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB002Dto;

public interface URB002Service {
	
	public List<URB002Dto> buildList(int startnum, int endnum, String search_codeA, String search_codeB, String search_codeC, String search_name);
	public int getTotal();
	public List<CodeDto> codeAList();
	public List<CodeDto> codeBListAll();
	public List<CodeDto> codeCListAll();
	public List<CodeDto> codeEList();
	public List<CodeDto> codeBList(String codeA);
	public List<CodeDto> codeCList(String codeA, String codeB);
	public void Register(Map<String, Object> map);
	public URB002Dto detail(int zone_registerNo);
	public void Update(Map<String, Object> map);
}
