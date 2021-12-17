package com.test.ur.app.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.ur.app.dto.GoodsDto;
import com.test.ur.app.mapper.GoodsMapper;

@Repository
public class GoodsDao {

	@Autowired
	SqlSession sqlSession;
	
	public GoodsDto	selectGoods() {
		GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
		GoodsDto goodsDto = mapper.selectGoods();
		return goodsDto;
	}
	
	public List<GoodsDto> findAll() {
		GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
		List<GoodsDto> list = mapper.findAll();
		return list;
	}
}
