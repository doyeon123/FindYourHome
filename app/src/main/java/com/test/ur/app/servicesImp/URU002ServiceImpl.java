package com.test.ur.app.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ur.app.dao.URU002Dao;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.dto.URU002Dto;
import com.test.ur.app.services.URU002Service;

@Service
public class URU002ServiceImpl implements URU002Service {

	@Autowired
	public URU002Dao dao;

	@Override
	public List<URU002Dto> findAll() {

		List<URU002Dto> list = dao.findAll();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<CodeDto> kokuseki() {

		List<CodeDto> list = dao.kokuseki();

		// TODO Auto-generated method stub
		return list;
	}

	public String insertapplicant(URU002Dto salesHome) {

		int cnt = dao.insertapplicant(salesHome);
		String path = "";

		if (cnt > 0) {

			path = "redirect:/admin/receipt";
		} else {

			path = "redirect:/admin/URU002L01";
		}

		return path;
	}

	@Override
	public URU002Dto readInDetails(int applicant_applyNo) {

		URU002Dto applicantIn = dao.readIndetails(applicant_applyNo);

		return applicantIn;
	}

	@Override
	public URU002Dto getReceipt(int receipt_registerNo) {

		return dao.getReceipt(receipt_registerNo);
	}

	@Override
	public int updateReceipt(URU002Dto updateReceipt) {
		return dao.updateReceipt(updateReceipt);
	}

	@Override
	public List<URB002Dto> bulidSearch(String zone_entireRegionalCode, String zone_areaRegionalCode, 
			String zone_stateRegionalCode, String zone_officalName) {
		List<URB002Dto> bulidSearch = dao.bulidSearch(zone_entireRegionalCode, zone_areaRegionalCode, zone_stateRegionalCode, zone_officalName);

		return bulidSearch;
	}

	
}
