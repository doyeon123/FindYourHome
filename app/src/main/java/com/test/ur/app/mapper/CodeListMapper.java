package com.test.ur.app.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URA001Dto;

public interface CodeListMapper {
	
	List<CodeDto> findAllEntireRegionalCode();
	
	List<CodeDto> findAllAreaRegionalCode();
	
	List<CodeDto> findAllProgressCode();

	List<CodeDto> findAllRoomCode();
	
	List<CodeDto> findAllInternetCode();
	
	List<CodeDto> findAllBusinessCode();
	
	List<CodeDto> findAllCategoryCode();
	
	List<CodeDto> findAllNationalitycode();
	
	List<CodeDto> findAllEquipmentCode();
	
	// 嶺뚯쉻�삕�뜝�럥�뿴占쎄턀�겫�뼔援�1
	void insertEntireRegionalCode(CodeDto codeDto) throws SQLException;
	// 嶺뚯쉻�삕�뜝�럥�뿴占쎄턀�겫�뼔援�2
	void insertAreaRegionalCode(CodeDto codeDto) throws SQLException;
	// 嶺뚯쉻�삕�뜝�럥�뿴占쎄턀�겫�뼔援�3
	void insertStateRegionalCode(CodeDto codeDto) throws SQLException;
	// 嶺뚯쉳�뫓筌묒뼍援쒒겫�뼔援�
	void insertProgressCode(CodeDto codeDto) throws SQLException;
	// �뛾�렮維뺧옙�윞�댖怨ㅼ삕
	void insertRoomCode(CodeDto codeDto) throws SQLException;
	// �뜝�럩逾ε뜝�럡�댉�뜝�럡�돩占쎄턀�겫�뼔援�
	void insertInternetCode(CodeDto codeDto) throws SQLException;
	// �뜝�럥�뵜�뜝�럥爰뽳옙援쒒겫�뼔援�
	void insertBusinessCode(CodeDto codeDto) throws SQLException;
	// �뇖�궠�샑占쎈�ㅿ옙�뫁伊볩옙遊�
	void insertCategoryCode(CodeDto codeDto) throws SQLException;
	// 占쎈쨨�뜝�룞�삕占쎌쓤占쎄턀�겫�뼔援�
	void insertNationalityCode(CodeDto codeDto) throws SQLException;
	// �뜝�럩�궋占쎈쑏�뜝占�(佯몃돍�삕�뜝�럡�룑)
	void insertEquipmentCode(CodeDto codeDto) throws SQLException;
	
	void deleteEntireRegionalCode() throws SQLException;
	
	void deleteAreaRegionalCode() throws SQLException;
	
	void deleteStateregionalcode() throws SQLException;
	
	void deleteProgressCode() throws SQLException;
	
	void deleteRoomCode() throws SQLException;
	
	void deleteInternetCode() throws SQLException;
	
	void deleteBusinessCode() throws SQLException;
	
	void deleteCategoryCode() throws SQLException;
	
	void deleteNationalityCode() throws SQLException;
	
	void deleteEquipmentCode() throws SQLException;
	
	//�떆
	List<CodeDto> getCityListByRegional(String regionalcode);
	
	//�떆 CODE -> @RESULT �쁽
	List<CodeDto> getRegionalListByArea(String areacode);
	
	//�쁽 CODE -> @RESULT �쁽
	List<CodeDto> getPrefectureListByRegional(String prefectureCode);

	List<CodeDto> getCityListByPrefecture(String prefectureCode, String cityCode);

	List<URA001Dto> getList(String regno, String zoneinfo);
	
	List<URA001Dto> getStructureList(Map<String, Object> searchMap);
	
	

	List<URA001Dto> findDetail();

	

	
	
	
	

	
}
  