package com.test.ur.app.mapper;

import java.util.List;

import com.test.ur.app.dto.GoodsDto;

public interface GoodsMapper {
	GoodsDto selectGoods();
	List<GoodsDto> findAll();
}
