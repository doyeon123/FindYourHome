package com.test.ur.app.servicesImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.test.ur.app.dao.URO002Dao;
import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.dto.URO002Dto;
import com.test.ur.app.services.URO002Service;



@Service
public class URO002Servicempl implements URO002Service {

	@Autowired
	private URO002Dao dao;
	
	@Override
	public ArrayList<URO002Dto> getSalesList() {
		ArrayList<URO002Dto> salesList = dao.getSalesList();
		return salesList;
	}
	
	@Override
	public String insertOffice(URO002Dto salesOffice) {
		
		//�۵��
		int cnt = dao.insertOffice(salesOffice);
		
		String path = "";
		
		if(cnt > 0) {
			//�� ��� ����
			path = "redirect:/admin/URO002L01";
		} else {
			//�� ��� ����
			path = "redirect:/admin/URO002E02";
		}
		return path;
	}
	
	@Override
	public URO002Dto readOfficeDetails(int sales_registerNo) {
		
		URO002Dto salesOffice = dao.readOfficeDetails(sales_registerNo);
		
		return salesOffice;
		
	}
	
	//������Ʈ
	@Override
	public String updateOffice(URO002Dto salesOffice) {
		
		//�ۼ���
		int cnt = dao.updateOffice(salesOffice);
		
		String path = "";
		
		if(cnt > 0) {
			
			
			//�� ��� ����
			path = "redirect:/admin/office";
		} else {
			//�� ��� ����
			path = "redirect:/admin/office/update";
		}
		return path;
	}

	//����
	@Override
	public List<URO002Dto> search(int startnum, int endnum, String zone_entireRegionalCode, String zone_areaRegionalCode, String zone_stateRegionalCode, String search_name) {
		// TODO Auto-generated method stub
		List<URO002Dto> list = dao.search(startnum, endnum, zone_entireRegionalCode, zone_areaRegionalCode, zone_stateRegionalCode, search_name);
		return list;
	}
	
	
	@Override
	public int getTotal() {
		int totalPage = dao.getTotal();
		return totalPage;
	}
	
	@Override
	public List<URO002Dto> officeList(int startnum, int endnum) {
		// TODO Auto-generated method stub
		List<URO002Dto> list = dao.officeList(startnum, endnum);
		return list;
	}
	
}
