package com.test.ur.app.services;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.dto.URU002Dto;

public interface URU002Service {

	List<URU002Dto> findAll();

	List<CodeDto> kokuseki();

	String insertapplicant(URU002Dto salesHome);

	URU002Dto readInDetails(int applicant_applyNo);
	
	public URU002Dto getReceipt(int receipt_registerNo);

	int updateReceipt(URU002Dto updateReceipt);
	
	List<URB002Dto> bulidSearch(@Param("zone_entireRegionalCode")String zone_entireRegionalCode, @Param("zone_areaRegionalCode")String zone_areaRegionalCode, 
			@Param("zone_stateRegionalCode")String zone_stateRegionalCode, @Param("zone_officalName")String zone_officalName);


}
