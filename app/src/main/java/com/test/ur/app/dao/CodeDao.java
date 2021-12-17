package com.test.ur.app.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.ur.app.constants.URConstants;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URA001Dto;
import com.test.ur.app.enums.CodeEnum;
import com.test.ur.app.mapper.CodeListMapper;

@Repository
public class CodeDao {

	@Autowired
	SqlSession sqlSession;
	
	public List<CodeDto> getPrefectureListByRegional(String prefectureCode){
		CodeListMapper mapper = sqlSession.getMapper(CodeListMapper.class);
		return mapper.getPrefectureListByRegional(prefectureCode);
	}
	
	
	public List<CodeDto> getCityListByRegional(String regionalcode) {
		CodeListMapper mapper = sqlSession.getMapper(CodeListMapper.class);
		
		return mapper.getCityListByRegional(regionalcode);
	}
	
	public List<CodeDto> getRegionalListByArea(String areacode) {
		CodeListMapper mapper = sqlSession.getMapper(CodeListMapper.class);
		
		return mapper.getRegionalListByArea(areacode);
	}
	
	public List<CodeDto> getCityListByPrefecture(String prefectureCode, String cityCode){
		CodeListMapper mapper = sqlSession.getMapper(CodeListMapper.class);
		
		return mapper.getCityListByPrefecture(prefectureCode, cityCode);
	}
	

	public List<URA001Dto> getRegNo(String regno, String zoneinfo) {
		CodeListMapper mapper = sqlSession.getMapper(CodeListMapper.class);
		
		return mapper.getList(regno, zoneinfo);
	}
	
	public List<URA001Dto> findDetail() {
		CodeListMapper mapper = sqlSession.getMapper(CodeListMapper.class);
		List<URA001Dto> list = mapper.findDetail();
		return list;
	}
	
	public List<URA001Dto> getStructureList(Map<String, Object> searchMap) {
		CodeListMapper mapper = sqlSession.getMapper(CodeListMapper.class);
		List<URA001Dto> list = mapper.getStructureList(searchMap);
		return list;
	}
	
	public List<CodeDto> getCode(CodeEnum code) {
		
		CodeListMapper mapper = sqlSession.getMapper(CodeListMapper.class);
		
		List<CodeDto> res = new ArrayList<>();
		
		if (code == CodeEnum.ENTIRE_REGIONAL) {
			res = mapper.findAllEntireRegionalCode();
		} else if(code == CodeEnum.AREA_REGIONAL) {
			res = mapper.findAllAreaRegionalCode();
		} else if(code == CodeEnum.PROGRESS) {
			res = mapper.findAllProgressCode();
		} else if(code == CodeEnum.ROOM) {
			res = mapper.findAllRoomCode();
		} else if(code == CodeEnum.INTERNET) {
			res = mapper.findAllInternetCode();
		} else if(code == CodeEnum.BUSINESS) {
			res = mapper.findAllBusinessCode();
		} else if(code == CodeEnum.CATEGORY) {
			res = mapper.findAllCategoryCode();
		} else if(code == CodeEnum.NATIONALITY) {
			res = mapper.findAllNationalitycode();
		} else if(code == CodeEnum.EQUIPMENT) {
			res = mapper.findAllEquipmentCode();
		} 
		
		return res;
	}
	
	public void insertCode(List<CodeDto> list, String updateCode) throws SQLException {
		
		CodeListMapper mapper = sqlSession.getMapper(CodeListMapper.class);
						
		try {
			switch (updateCode) {
				case URConstants.ENTIRE_REGIONAL:
					insertEntireRegionalCode(mapper, list);
					break;
				case URConstants.AREA_REGIONAL:
					insertAreaRegionalCode(mapper, list);
					break;
				case URConstants.STATE_REGIONAL:
					insertStateRegionalCode(mapper, list);
					break;
				case URConstants.PROGRESS:
					insertProgressCode(mapper, list);
					break;
				case URConstants.ROOM:
					insertRoomCode(mapper, list);
					break;
				case URConstants.INTERNET:
					insertInternetCode(mapper, list);
					break;
				case URConstants.BUSINESS:
					insertBusinessCode(mapper, list);
					break;
				case URConstants.CATEGORY:
					insertCategoryCode(mapper, list);	
					break;
				case URConstants.NATIONALITY:
					insertNationalityCode(mapper, list);
					break;
				case URConstants.EQUIPMENT:
					insertEquipmentCode(mapper, list);
					break;
			}
		} catch (SQLException e) {
			System.err.println(e.getLocalizedMessage());
			throw e;
		}
	}
	
	private void insertEntireRegionalCode(CodeListMapper mapper, List<CodeDto> list) throws SQLException {
		mapper.deleteEntireRegionalCode();
		for (CodeDto codeDto : list) {
			
			mapper.insertEntireRegionalCode(codeDto);
		}
	}
	
	private void insertAreaRegionalCode(CodeListMapper mapper, List<CodeDto> list) throws SQLException {
		mapper.deleteAreaRegionalCode();
		for (CodeDto codeDto : list) {
			mapper.insertAreaRegionalCode(codeDto);
		}	
	}
	
	private void insertStateRegionalCode(CodeListMapper mapper, List<CodeDto> list) throws SQLException {
		mapper.deleteStateregionalcode();
		for (CodeDto codeDto : list) {
			mapper.insertStateRegionalCode(codeDto);
		}
	}
	
	private void insertProgressCode(CodeListMapper mapper, List<CodeDto> list) throws SQLException {
		mapper.deleteProgressCode();
		for (CodeDto codeDto : list) {
			mapper.insertProgressCode(codeDto);
		}
	}
	
	private void insertRoomCode(CodeListMapper mapper, List<CodeDto> list) throws SQLException {
		mapper.deleteRoomCode();
		for (CodeDto codeDto : list) {
			mapper.insertRoomCode(codeDto);
		}
	}
	
	private void insertInternetCode(CodeListMapper mapper, List<CodeDto> list) throws SQLException {
		mapper.deleteInternetCode();
		for (CodeDto codeDto : list) {
			mapper.insertInternetCode(codeDto);
		}
	}
	
	private void insertBusinessCode(CodeListMapper mapper, List<CodeDto> list) throws SQLException {
		mapper.deleteBusinessCode();
		for (CodeDto codeDto : list) {
			mapper.insertBusinessCode(codeDto);
		}
	}

	private void insertCategoryCode(CodeListMapper mapper, List<CodeDto> list) throws SQLException {
		mapper.deleteCategoryCode();
		for (CodeDto codeDto : list) {
			mapper.insertCategoryCode(codeDto);
		}
	}

	private void insertNationalityCode(CodeListMapper mapper, List<CodeDto> list) throws SQLException {
		mapper.deleteNationalityCode();
		for (CodeDto codeDto : list) {
			mapper.insertNationalityCode(codeDto);
		}
	}


	private void insertEquipmentCode(CodeListMapper mapper, List<CodeDto> list) throws SQLException {
		mapper.deleteEquipmentCode();
		for (CodeDto codeDto : list) {
			mapper.insertEquipmentCode(codeDto);
		}
	}




	

	

	
}
