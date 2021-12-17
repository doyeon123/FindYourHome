package com.test.ur.app.services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URA001Dto;
import com.test.ur.app.enums.CodeEnum;

public interface CodeService {

	public List<CodeDto> findByCode(CodeEnum code);
	
	public List<CodeDto> getCityListByRegional(String regionalcode);
	
	public List<CodeDto> getRegionalListByArea(String areacode);
	
	public List<CodeDto> getPrefectureListByRegional(String prefectureCode);
	
	public List<CodeDto> getCityListByPrefecture(String prefectureCode, String cityCode);
	
	public List<URA001Dto> findDetail();
	
	public List<URA001Dto> getStructureList(Map<String, Object> searchMap);
	
	
	
	void insertCode(List<CodeDto> list, String updateCode) throws SQLException;

	

	

	

	
	

	

	
}
