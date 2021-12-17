package com.test.ur.app.services;

import java.util.List;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URR001Dto;
	
public interface URR001Service {
	
	// 건물 번호에 해당하는 방 리스트
	public List<URR001Dto> findAll(int startnum, int endnum, int id, String search);
	
	// 건물 번호에 해당하는 방 리스트 개수
	public int getTotal(int room_zoneInfo, String search);
	
	// 방 등록
	public void insertRoom(URR001Dto dto);
	
	// 코드마스터 지역코드
	public List<CodeDto> entireList();
	
	// 코드마스터 방코드
	public List<CodeDto> roomCode();
	
	// 방 번호 가져오기
	public URR001Dto getRoom(int no);

	// 방 등록
	public int updateRoom(URR001Dto dto);
	
	// 방 상세
	public URR001Dto roomDetail(int room_registerNo);
}