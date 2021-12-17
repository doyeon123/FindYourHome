      package com.test.ur.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.dto.URO002Dto;

public interface URO002Service {

	ArrayList<URO002Dto> getSalesList();

	String insertOffice(URO002Dto salesOffice);

	URO002Dto readOfficeDetails(int sales_registerNo);
	
	String updateOffice(URO002Dto salesOffice);
	
	//寃��깋
	public List<URO002Dto> search(int startnum, int endnum, String zone_entireRegionalCode, String zone_areaRegionalCode, String zone_stateRegionalCode, String search_name);

	///////////////
	public int getTotal();
	
	public List<URO002Dto> officeList(int startnum, int endnum);

}
