package com.test.ur.app.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.ur.app.controller.base.BaseController;
import com.test.ur.app.dto.URN001Dto;
import com.test.ur.app.services.URN001Service;

//Notice Controller
@Controller
public class URN001Controller extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(URN001Controller.class);

	@Autowired
	private URN001Service service;
	
	@RequestMapping(value = "/notice/", method = RequestMethod.GET)
	public String noticeList(Locale locale, Model model,@RequestParam(defaultValue = "1") int page) {
		
		logger.info("notice page : " + page);
		
		List<URN001Dto> noticeList = service.findAll(page);
		logger.debug("notice size : " + noticeList.size());
		model.addAttribute("noticeList",noticeList);
		model.addAttribute("paging", addPagingInformation(page, service.getTotal()));
		return "URN001L01";
	}
	
	@RequestMapping(value = "/notice/detail", method = RequestMethod.GET)
	public String noticeDetail(Locale locale, Model model,@RequestParam(required = true) int id) {
		
		logger.info("noticeDetail id : " + id);
		model.addAttribute("notice", service.getNoticeById(id));
		return "URN001D01";
	}
}
