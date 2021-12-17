package com.test.ur.app.mapper;

import java.util.List;

import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.ljk_URC001Dto;

public interface ljk_URC001Mapper {
	
	//게시판맵퍼 
	//게시판 리스트
	//게시판 상세보기
	//게시판 수정
	//게시판 삭제
	//게시판 답글
	
	//작성자 페스워드 체크
	
	public int getTotal();

	public int insertBoard(ljk_URC001Dto vo);
	
	public ljk_URC001Dto get(int consulting_registerNo);
	
	public int update(ljk_URC001Dto vo);
	
	public int remove(int consulting_registerNo);
	
	public List<ljk_URC001Dto> getList(int startnum);

	public ljk_URC001Dto checkpassword(ljk_URC001Dto vo);

}
