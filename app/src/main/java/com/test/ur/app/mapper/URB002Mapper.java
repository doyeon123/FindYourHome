package com.test.ur.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB002Dto;

public interface URB002Mapper {
    
	List<URB002Dto> buildList(@Param ("startnum") int startnum, @Param ("endnum") int endnum, 
			@Param ("search_codeA") String search_codeA, @Param ("search_codeB") String search_codeB, @Param ("search_codeC") String search_codeC,
			@Param ("search_name") String search_name);
	
	public int getTotal();
	
	List<CodeDto> codeAList();
	
	List<CodeDto> codeBListAll();
	
	List<CodeDto> codeCListAll();
	
	List<CodeDto> codeBList(String codeA);
	
	List<CodeDto> codeCList(@Param("codeA")String codeA, @Param("codeB") String codeB);
	
	List<CodeDto> codeEList();
	
	public void Register(Map<String, Object> map);
	
	public URB002Dto detail(int zone_registerNo);
	
	public void Update(Map<String, Object> map);

	
}
