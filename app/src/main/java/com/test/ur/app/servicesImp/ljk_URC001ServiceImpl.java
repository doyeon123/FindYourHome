package com.test.ur.app.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ur.app.dao.ljk_URC001Dao;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.ljk_URC001Dto;
import com.test.ur.app.mapper.ljk_URC001Mapper;
import com.test.ur.app.services.ljk_URC001Service;

@Service
public class ljk_URC001ServiceImpl implements ljk_URC001Service {

	@Autowired
	public ljk_URC001Dao dao;
	
	@Override
	public List<ljk_URC001Dto> getList(int startnum) {
		// TODO Auto-generated method stub
		return dao.getList(startnum);
	}
	
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return dao.getTotal();
	}

	@Override
	public int insertBoard(ljk_URC001Dto vo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(vo);
	}
	
	@Override
	public ljk_URC001Dto get(int consulting_registerNo) {
		// TODO Auto-generated method stub
		return dao.get(consulting_registerNo);
	}
	
	@Override
	public int update(ljk_URC001Dto vo) {
		// TODO Auto-generated method stub
		return dao.update(vo);
	}
	
	@Override
	public ljk_URC001Dto checkpassword(ljk_URC001Dto vo) {
		// TODO Auto-generated method stub
		return dao.checkpassword(vo);
	}
	
	@Override
	public int remove(int consulting_registerNo) {
		// TODO Auto-generated method stub
		return dao.remove(consulting_registerNo);
	}
	
	/* ===== */
	


	

	



	

	



	


}
