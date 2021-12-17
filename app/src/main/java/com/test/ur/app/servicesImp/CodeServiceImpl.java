package com.test.ur.app.servicesImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ur.app.dao.CodeDao;
import com.test.ur.app.dao.GoodsDao;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URA001Dto;
import com.test.ur.app.enums.CodeEnum;
import com.test.ur.app.services.CodeService;

@Service
public class CodeServiceImpl implements CodeService {
	
	@Autowired
	private CodeDao codeDao;

	@Override
	public List<CodeDto> findByCode(CodeEnum code) {
		// TODO Auto-generated method stub
		List<CodeDto> res = codeDao.getCode(code);
		return res;
	}
	

	@Override
	public void insertCode(List<CodeDto> list, String updateCode) throws SQLException {
		codeDao.insertCode(list, updateCode);
	}

	@Override
	public List<CodeDto> getCityListByRegional(String regionalcode) {
		// TODO Auto-generated method stub
		return codeDao.getCityListByRegional(regionalcode);
	}


	@Override
	public List<CodeDto> getRegionalListByArea(String areacode) {
		// TODO Auto-generated method stub
		return codeDao.getRegionalListByArea(areacode);
	}


	@Override	
	public List<CodeDto> getPrefectureListByRegional(String prefectureCode) {
		// TODO Auto-generated method stub
		return codeDao.getPrefectureListByRegional(prefectureCode);
	}


	@Override
	public List<CodeDto> getCityListByPrefecture(String prefectureCode, String cityCode) {
		// TODO Auto-generated method stub
		return codeDao.getCityListByPrefecture(prefectureCode, cityCode);
	}


	@Override
	public List<URA001Dto> findDetail() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<URA001Dto> getStructureList(Map<String, Object> searchMap) {
		// TODO Auto-generated method stub
		return codeDao.getStructureList(searchMap);
	}
	
}