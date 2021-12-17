package com.test.ur.app.services;

import java.sql.SQLException;
import java.util.List;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.enums.CodeEnum;

public interface URA001Service {

public List<CodeDto> findByCode(CodeEnum code);
	
	public List<CodeDto> getCityListByRegional(String regionalcode);
	
	public List<CodeDto> getRegionalListByArea(String areacode);
	
	public List<CodeDto> getPrefectureListByRegional(String prefectureCode);
	
	public List<CodeDto> getCityListByPrefecture(String prefectureCode, String cityCode);
	
	void insertCode(List<CodeDto> list, String updateCode) throws SQLException;
	
}
