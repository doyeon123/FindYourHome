package com.test.ur.app.mapper;

import java.util.List;

import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.ljk_URC001Dto;

public interface ljk_URC001Mapper {
	
	//�Խ��Ǹ��� 
	//�Խ��� ����Ʈ
	//�Խ��� �󼼺���
	//�Խ��� ����
	//�Խ��� ����
	//�Խ��� ���
	
	//�ۼ��� �佺���� üũ
	
	public int getTotal();

	public int insertBoard(ljk_URC001Dto vo);
	
	public ljk_URC001Dto get(int consulting_registerNo);
	
	public int update(ljk_URC001Dto vo);
	
	public int remove(int consulting_registerNo);
	
	public List<ljk_URC001Dto> getList(int startnum);

	public ljk_URC001Dto checkpassword(ljk_URC001Dto vo);

}
