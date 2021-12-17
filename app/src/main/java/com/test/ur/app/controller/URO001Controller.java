
package com.test.ur.app.controller;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.ur.app.controller.base.BaseController;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.PageNavi;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.URO001Dto;
import com.test.ur.app.enums.CodeEnum;
import com.test.ur.app.services.CodeService;
import com.test.ur.app.services.URO001Service;
import com.test.ur.app.servicesImp.URO001ServiceImpl;

@Controller
public class URO001Controller extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(URO001Controller.class);
	
	@Autowired
	private URO001Service service;
	
	@Autowired
	private CodeService codeService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	/**
	 * Office AreaSelect
	 * @param model 모델 객체
	 * @return areaSelectPage
	 */
	@RequestMapping(value = "/office/", method = RequestMethod.GET)
	public String home(Model model) {
		List<CodeDto> areaList = codeService.findByCode(CodeEnum.ENTIRE_REGIONAL);
		List<List<CodeDto>> regionalList = new ArrayList<List<CodeDto>>();
		for(CodeDto area : areaList) {
			regionalList.add(codeService.getRegionalListByArea(area.getCode()));
		}
		model.addAttribute("areaList", areaList);
		model.addAttribute("regionalList", regionalList);
		return "URO001S01";
	}
	
	/**
	 * officeList splitted by area
	 * @param model 모델 객체
	 * @param areacode 도도부현 코드
	 * @return officeListpage
	 */
	@RequestMapping(value = "/office/{regionalcode}/", method = RequestMethod.GET)
	public String home(Model model,@PathVariable String regionalcode) {
		
		logger.info("office/" + regionalcode);
		//needs areacode validation
		
		model.addAttribute("regionalcode", regionalcode);
		model.addAttribute("cityList",codeService.getCityListByRegional(regionalcode));
		return "URO001R01";
	}
	
	/**
	 * process AJAX request from office table
	 * @param model 모델 객체
	 * @param areacode 도도부현 코드
	 * @param page 페이지네이션 현재 페이지
	 * @return officeListpage
	 */
	@RequestMapping(value = "/office/{areacode}/{citycode}/", method = RequestMethod.GET)
	public String home(Model model,@PathVariable String areacode,@PathVariable String citycode) {
		
		logger.info("office/" + areacode  + "/" + citycode);
		List<URO001Dto> list = service.getOfficeListByCity(citycode);
		//needs areacode validation
		model.addAttribute("officeList", list);
		model.addAttribute("citycode", citycode);
		return "contents/URO001R01_detail";
	}
	
	@RequestMapping(value = "/office/{areacode}/{citycode}/detail", method = RequestMethod.GET)
	public String home(Model model,@PathVariable String areacode,@PathVariable String citycode,int id) {
		
		logger.info("office/" + areacode  + "/" + citycode + "/detail?id=" + id);
		URO001Dto office = service.getOfficeById(id);
		//needs areacode validation
		model.addAttribute("office", office);
		
		return "URO001D01";
	}
	
}
