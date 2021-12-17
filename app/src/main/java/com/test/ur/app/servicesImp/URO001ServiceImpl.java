package com.test.ur.app.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ur.app.dao.URO001Dao;
import com.test.ur.app.dao.URR001Dao;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.URO001Dto;
import com.test.ur.app.mapper.URO001Mapper;
import com.test.ur.app.services.URO001Service;

@Service
public class URO001ServiceImpl implements URO001Service {
	
	
	@Autowired
	public URO001Dao dao;

	@Override
	public List<URO001Dto> findAll() {
		return dao.findAll();
	}

	@Override
	public int getTotal(String citycode) {
		// TODO Auto-generated method stub
		return dao.getTotal(citycode);
	}
	

	@Override
	public List<URO001Dto> getOfficeListByCity(String citycode) {
		// TODO Auto-generated method stub
		return dao.getOfficeListByCity(citycode);
	}

	@Override
	public URO001Dto getOfficeById(int id) {
		// TODO Auto-generated method stub
		return dao.getOfficeById(id);
	}

}
