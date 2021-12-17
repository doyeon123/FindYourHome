package com.test.ur.app.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ur.app.dao.GoodsDao;
import com.test.ur.app.dto.GoodsDto;
import com.test.ur.app.services.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;

	@Override
	public GoodsDto selectGoods() {
		GoodsDto goodsDto = goodsDao.selectGoods();
		return goodsDto;
	}

	@Override
	public List<GoodsDto> findAll() {
		// TODO Auto-generated method stub
		List<GoodsDto> list = goodsDao.findAll();
		return list;
	}
  
}
