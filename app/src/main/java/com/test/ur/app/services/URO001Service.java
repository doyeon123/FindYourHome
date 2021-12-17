package com.test.ur.app.services;

import java.util.List;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.URO001Dto;

public interface URO001Service {

	/**
	 * select * from salesoffice
	 * @return
	 */
	List<URO001Dto> findAll();
	
	
	/**
	 * getAllOfficeNumberByCityCode
	 * @param areacode : number of elements per page
	 * @return maxPageNum
	 */
	int getTotal(String citycode);

	/**
	 * get Office list
	 * @param cityCode : areacode(市、区)
	 * @return Office list
	 */
	List<URO001Dto> getOfficeListByCity(String citycode);
	
	/**
	 * get Office by id
	 * @param page : currentPage
	 * @param count : number of elements per page
	 * @return Office list for page
	 */
	URO001Dto getOfficeById(int id);

	
	
}
