package com.test.ur.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.ur.app.dto.URN001Dto;

public interface URN001Mapper {
	/**
	 * select * from notice
	 * @return
	 */
	List<URN001Dto> findAll(@Param(value = "startnum")int startnum,@Param(value = "endnum")int endnum);

	int getTotal();

	URN001Dto getNoticeById(@Param(value = "id")int id);
}
