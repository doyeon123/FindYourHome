package com.test.ur.app.controller;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.ur.app.controller.base.BaseController;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.URA001Dto;
import com.test.ur.app.enums.CodeEnum;
import com.test.ur.app.services.CodeService;

//AreaController
@Controller
public class URA001Controller extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(URA001Controller.class);
	
	@Autowired
	private CodeService codeService;

	
	@RequestMapping(value = "/area/", method = RequestMethod.GET)
	public String area(Model model) {
		
		logger.info("Area");
		
		return loadAreaSelectPage(model);
		
	}
	
	@RequestMapping(value = "/area/{prefectureCode}", method = RequestMethod.GET)
	public String prefecture(Locale locale, Model model, @PathVariable("prefectureCode") String prefectureCode) {
		
		
		List<CodeDto> prefectureList = codeService.getPrefectureListByRegional(prefectureCode);
							//key                   value
		
		model.addAttribute("prefectureList", prefectureList);
		return "URA001S02";
	}
	
	@RequestMapping(value = "/area/{prefectureCode}/{cityCode}", method = RequestMethod.GET)
	public String city(Locale locale, Model model, @PathVariable("prefectureCode") String prefectureCode, @PathVariable("cityCode") String cityCode) {
		
		
		List<CodeDto> prefectureList = codeService.getPrefectureListByRegional(prefectureCode);
		List<CodeDto> roomList = codeService.findByCode(CodeEnum.ROOM);
		List<CodeDto> equipList = codeService.findByCode(CodeEnum.EQUIPMENT);
		List<CodeDto> internetList = codeService.findByCode(CodeEnum.INTERNET);
		
							//key                   value
		model.addAttribute("prefectureList", prefectureList);
		model.addAttribute("roomList", roomList);
		model.addAttribute("equipList", equipList);
		model.addAttribute("internetList", internetList);
		return "URA001S03";
	}
	
	
	@RequestMapping(value = "/area/{prefectureCode}/{cityCode}/build", method = RequestMethod.GET)
	public String buildInfo(Model model) {
		
		List<URA001Dto> regno = codeService.findDetail();
		List<URA001Dto> zoneinfo = codeService.findDetail();
		List<URA001Dto> areainfo = codeService.findDetail();
		List<URA001Dto> flowinfo = codeService.findDetail();
		List<URA001Dto> structure = codeService.findDetail();
		List<URA001Dto> sikiking = codeService.findDetail();
		List<URA001Dto> racing = codeService.findDetail();
		List<URA001Dto> yaching = codeService.findDetail();
		List<URA001Dto> nooffloor = codeService.findDetail();
		List<URA001Dto> roomarrange = codeService.findDetail();
		List<URA001Dto> img360 = codeService.findDetail();
		List<URA001Dto> img = codeService.findDetail();
		
		model.addAttribute("regno", regno);
		model.addAttribute("zoneinfo", zoneinfo);
		model.addAttribute("areainfo", areainfo);
		model.addAttribute("flowinfo", flowinfo);
		model.addAttribute("structure", structure);
		model.addAttribute("sikiking", sikiking);
		model.addAttribute("racing", racing);
		model.addAttribute("yaching", yaching);
		model.addAttribute("roomarrange", roomarrange);
		model.addAttribute("img360", img360);
		model.addAttribute("img", img);
		
		return "URB001D01";
	}
	
	@RequestMapping(value = "/area/{prefectureCode}/{cityCode}/build", method = RequestMethod.POST)
	public String build(Model model, HttpServletRequest request) {
		
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		String[] structureList = (String[])request.getParameterValues("room_structure");
		String[] equipList = (String[])request.getParameterValues("zone_note");
		String[] internetList =(String[])request.getParameterValues("internet");
		String[] yachingList = (String[])request.getParameterValues("yaching");
		
		System.out.println("structureList:"+structureList.length);	
		
		System.out.println("equip:"+equipList.length);
		for(String a : equipList)
			System.out.println("jsp:"+a);
		
		
		searchMap.put("structureList", structureList);
		searchMap.put("equipList", equipList);
		searchMap.put("internetList", internetList);
		searchMap.put("yachingList", yachingList);
		
		// DB -> view
		List<URA001Dto> list = codeService.getStructureList(searchMap);
		
		
		System.out.println("=====장비리스트db");
		if(!list.isEmpty())
			System.out.println(list.get(0).getZone_note());
		
		String structure = String.join(",", structureList);
		System.out.println("===== 방구조jsp ");
		System.out.println(structure);
		
		
		String[] structureConversionList = structure.split(",");
		System.out.println("=====방구조 배열 리스트jsp");
		System.out.println(structureConversionList.length);
		
		model.addAttribute("list", list);
		return "URB001D01";

	}
}
