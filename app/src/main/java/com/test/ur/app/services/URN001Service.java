package com.test.ur.app.services;

import java.util.List;

import com.test.ur.app.dto.URN001Dto;

public interface URN001Service {
	
	public List<URN001Dto> findAll(int page);

	public int getTotal();

	public URN001Dto getNoticeById(int id);
}
