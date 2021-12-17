package com.test.ur.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URR001Dto;
import com.test.ur.app.mapper.URR001Mapper;

@Repository
public class URR001Dao {

	@Autowired
	SqlSession sqlSession;
	
	// 건물 번호에 해당하는 방 리스트
	public List<URR001Dto> findAll(int startnum, int endnum, int id, String search) {
		URR001Mapper mapper = sqlSession.getMapper(URR001Mapper.class);
		System.out.println(id);
		List<URR001Dto> list = mapper.findAll(startnum, endnum, id, search);
//		List<URR001Dto> list = new ArrayList<URR001Dto>();
		return list;
	}
	
	// 건물 번호에 해당하는 방 리스트 개수
	public int getTotal(int room_zoneInfo, String search) {
		URR001Mapper mapper = sqlSession.getMapper(URR001Mapper.class);
		int totalPage = mapper.getTotal(room_zoneInfo, search);
		return totalPage;
	}
	
	// 방 등록
	public void insertRoom(URR001Dto dto) {
		URR001Mapper mapper = sqlSession.getMapper(URR001Mapper.class);
		mapper.insertRoom(dto);
	}
	
	// 코드마스터 지역코드
	public List<CodeDto> entireList() {
		URR001Mapper mapper = sqlSession.getMapper(URR001Mapper.class);
		List<CodeDto> entireList = mapper.entireList();
		return entireList;
	}
	
	// 코드마스터 방코드
	public List<CodeDto> roomCode() {
		URR001Mapper mapper = sqlSession.getMapper(URR001Mapper.class);
		List<CodeDto> roomCode = mapper.roomCode();
		return roomCode;
	}
	
	// 방 번호 가져오기
	public URR001Dto getRoom(int no) {
		URR001Mapper mapper = sqlSession.getMapper(URR001Mapper.class);
		URR001Dto dto = mapper.getRoom(no);
		return dto;
	}
	
	// 방 등록
	public int updateRoom(URR001Dto dto) {
		URR001Mapper mapper = sqlSession.getMapper(URR001Mapper.class);
		int result = mapper.updateRoom(dto);
		return result;
	}

	 // 방 상세
	public URR001Dto roomDetail(int room_registerNo) {
		URR001Mapper mapper = sqlSession.getMapper(URR001Mapper.class);
		URR001Dto dto = mapper.roomDetail(room_registerNo);
		return dto;
	}
}
