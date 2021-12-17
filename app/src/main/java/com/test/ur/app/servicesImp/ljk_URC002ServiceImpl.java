package com.test.ur.app.servicesImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ur.app.dao.ljk_URC002Dao;
import com.test.ur.app.dto.ljk_URC002Dto;
import com.test.ur.app.services.ljk_URC002Service;

@Service
public class ljk_URC002ServiceImpl implements ljk_URC002Service {

	
	@Autowired
	public ljk_URC002Dao dao;
	
	
	@Override
	public ljk_URC002Dto get(int consulting_registerNo) {
		return dao.get(consulting_registerNo);
	}

	
	

}
