package com.test.ur.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.URO001Dto;

public interface URO001Mapper {

	/**
	 * select * from salesoffice
	 * @return
	 */
	List<URO001Dto> findAll();
	
	/**
	 * getAllOfficeNumberByAreaCode
	 * @param citycode
	 * @return maxPageNum
	 */
	int getTotal(@Param(value = "citycode") String citycode);

	/**
	 * get Office list for page
	 * @param page : currentPage
	 * @param amount : number of elements per page
	 * @param areacode : areacode(都道府県)
	 * @return Office list for page
	 */
	List<URO001Dto> getOfficeListByCity(@Param(value = "citycode")String citycode);
	
	/**
	 * get Office by id
	 * @param page : currentPage
	 * @param count : number of elements per page
	 * @return Office list for page
	 */
	URO001Dto getOfficeById(@Param(value = "id") int id);
	
}
