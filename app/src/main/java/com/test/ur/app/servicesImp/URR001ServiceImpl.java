package com.test.ur.app.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ur.app.dao.URR001Dao;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URR001Dto;
import com.test.ur.app.services.URR001Service;

@Service
public class URR001ServiceImpl implements URR001Service {
	
	@Autowired
	public URR001Dao dao;

	// 건물 번호에 해당하는 방 리스트
	@Override
	public List<URR001Dto> findAll(int startnum, int endnum, int id, String search) {
		List<URR001Dto> list = dao.findAll(startnum, endnum, id, search);
		return list;
	}

	// 건물 번호에 해당하는 방 리스트 개수
	@Override
	public int getTotal(int room_zoneInfo, String search) {
		int totalPage = dao.getTotal(room_zoneInfo, search);
		return totalPage;
	}

	// 방 등록
	@Override
	public void insertRoom(URR001Dto dto) {
		dao.insertRoom(dto);
	}

	// 코드마스터 지역코드
	@Override
	public List<CodeDto> entireList() {
		List<CodeDto> entireList = dao.entireList();
		return entireList;
	}
	
	// 코드마스터 방코드
	@Override
	public List<CodeDto> roomCode() {
		List<CodeDto> roomCode = dao.roomCode();
		return roomCode;
	}

	// 방 번호 가져오기
	@Override
	public URR001Dto getRoom(int no) {
		URR001Dto dto = dao.getRoom(no);
		return dto;
	}

	// 방 등록
	@Override
	public int updateRoom(URR001Dto dto) {
		return dao.updateRoom(dto);
	}

	// 방 상세
	@Override
	public URR001Dto roomDetail(int room_registerNo) {
		URR001Dto dto = dao.roomDetail(room_registerNo);
		return dto;
	}

}
