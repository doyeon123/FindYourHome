package com.test.ur.app.services;

import java.util.List;

import com.test.ur.app.dto.GoodsDto;

public interface GoodsService {
	public GoodsDto selectGoods();
	public List<GoodsDto> findAll();
}
