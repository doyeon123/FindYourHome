package com.test.ur.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.dto.URO002Dto;

/**
 * ������ mapper
 */


public interface URO002Mapper {
	
	//��ü ������ ����Ʈ ��������
	ArrayList<URO002Dto> getSalesList();

	//������ db �ֱ�
	int insertOffice(URO002Dto salesOffice);

	//���ǽ� �󼼺��� ��������
	URO002Dto readOfficeDetails(int sales_registerNo);

	//������ ����
	int updateOffice(URO002Dto salesOffice);

	
	/////////////////////
	List<URO002Dto> search(@Param ("startnum") int startnum, @Param ("endnum") int endnum, @Param("zone_entireRegionalCode")String zone_entireRegionalCode, @Param("zone_areaRegionalCode")String zone_areaRegionalCode, @Param("zone_stateRegionalCode")String zone_stateRegionalCode, @Param("search_name")String search_name);
	

	

	////////////////////
	List<URO002Dto> officeList(@Param ("startnum") int startnum, @Param ("endnum") int endnum);

	
	public int getTotal();

}
