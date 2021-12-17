package com.test.ur.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.dto.URN002Dto;
import com.test.ur.app.dto.URU002Dto;

public interface URU002Mapper {

	List<URU002Dto> findAll();

	List<CodeDto> kokuseki();

	int insertapplicant(URU002Dto applicant);

	public URU002Dto findDetail(int notice_registerNo);

	URU002Dto readInDetails(int applicant_applyNo);

	URU002Dto getReceipt(int receipt_registerNo);
	
	int updateReceipt(URU002Dto updateReceipt);
	
	List<URB002Dto> buildSearch(@Param("zone_entireRegionalCode")String zone_entireRegionalCode, @Param("zone_areaRegionalCode")String zone_areaRegionalCode, 
			@Param("zone_stateRegionalCode")String zone_stateRegionalCode, @Param("zone_officalName")String zone_officalName);

}
