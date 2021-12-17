package com.test.ur.app.controller;

import java.lang.reflect.Member;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.ur.app.controller.base.BaseController;
import com.test.ur.app.dao.URB002Dao;
import com.test.ur.app.dao.URB010Dao;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.PageNavi;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.URA001Dto;
import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.dto.URB010Dto;
import com.test.ur.app.dto.URN002Dto;
import com.test.ur.app.enums.CodeEnum;
import com.test.ur.app.services.CodeService;
import com.test.ur.app.services.URB002Service;
import com.test.ur.app.services.URB010Service;

@Controller
public class URB010Controller extends BaseController {

	@Autowired
	private URB010Service service;
	

	private static final Logger logger = LoggerFactory.getLogger(URB010Controller.class);

	/**
	 * @param
	 * @return builid
	 */
	

	// 커뮤니티 게시판 리스트 가져오기 + 페이징처리, 현재 페이징처리 안됨
	@RequestMapping(value = "/builid/{buildNo}/community", method = RequestMethod.GET)
	public String communityList(
			Model model, @PathVariable("buildNo") int buildNo, 
			@RequestParam(defaultValue = "1") int page, PagingDto paging) {
		logger.info("community page : " + page);

		System.out.println(buildNo);
		
		int startnum = paging.getPageNo() * paging.getAmount() - 10; // 페이징?
		
		//List<URB010Dto> DTO = service.findAll(startnum);
		List<URB010Dto> DTO = service.findAllByBuildNo(buildNo);
		model.addAttribute("communityList", DTO);
		
		/*
		 * int zone_registerNo = Integer.parseInt(request.getParameter("buildNo"));
		 * dto.setZone_registerNo(buildNo); URB002Dto result = service2.detail(buildNo);
		 * if (result > 0) resultString = "글이 등록되었습니다.";
		 * rttr.addFlashAttribute("result", resultString);
		 */

		// URB010Dto buildNoList = service.findAll(buildNo);

		model.addAttribute("pageNavi", new PageNavi(paging, service.getTotal()));

		return "URB011L01";

	}

	
	
	// 글의 상세정보 가져오기	 
	@RequestMapping(value="/builid/{buildNo}/community/detail", method = RequestMethod.GET)
	public String communityDetail(Model model, int id) {		
	    URB010Dto DTO = service.findDetail(id);
		model.addAttribute("community", DTO);

		return "URB011D01";
	 
	}
	
	
	// 커뮤니티 글 등록 페이지 들어가기
	@RequestMapping(value="/builid/{buildNo}/community/create", method = RequestMethod.GET)
	public String create(Model model, HttpServletRequest request, @PathVariable("buildNo") int buildNo) {	
		//URB010Dto dto = new URB010Dto();
			
		//dto.setCommunity_buildingInfo(buildNo); // buildNo 파라미터 넘기기
		
		return "URB011E01";
	 
	}
	

	
	// 건물 커뮤니티 게시판 등록 페이지	
	@RequestMapping(value = "/builid/{buildNo}/community/create", method = RequestMethod.POST)
	public String communityCreate(Model model, @PathVariable("buildNo") int buildNo, HttpServletRequest request, RedirectAttributes rttr) throws ParseException {
		URB010Dto dto = new URB010Dto(); 
		
		// Calendar cal = Calendar.getInstance();

		// 년월일 제공
		//SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");

		// 등록번호, 작성일, 수정일은 seq 사용했기 때문
		String community_author = request.getParameter("community_author"); // 작성자
		//int community_buildingInfo = Integer.parseInt(request.getParameter("community_buildingInfo")); // 건물번호
		String community_title = request.getParameter("community_title"); // 제목
		String community_password = request.getParameter("community_password"); // 비밀번
		String community_content = request.getParameter("community_content"); // 내용
		
		dto.setCommunity_author(community_author);
		dto.setCommunity_buildingInfo(buildNo);
		//dto.setCommunity_buildingInfo(community_buildingInfo);
		dto.setCommunity_title(community_title);
		dto.setCommunity_password(community_password);
		dto.setCommunity_content(community_content);

		int result = service.createCommunity(dto);

		String resultString = "error";

		if (result > 0) {
			resultString = "글이 등록되었습니다.";
		}
		
		rttr.addFlashAttribute("result", resultString);
		
		System.out.println("글이 등록되었습니다.");
		//System.out.println(dto.toString() + " " + dto.getCommunity_deleteFlag());

		return "redirect:/builid/" + buildNo + "/community"; // redirect는 {} 못넘김. 인코딩 해줘야함
		
	}
	
	
	// 커뮤니티 글 수정 페이지 들어가기
	@RequestMapping(value="/builid/{buildNo}/community/update", method = RequestMethod.GET) 
	public String update(Model model, @PathVariable("buildNo") int buildNo, int id, HttpServletRequest request) {			
	    
	    URB010Dto DTO = service.findDetail(id);
	    	
	    model.addAttribute("community", DTO);
	    
		
		return "URB011E01";
		
	}
		
	// 커뮤니티 글 수정 페이지
	@RequestMapping(value="/builid/{buildNo}/community/update", method = RequestMethod.POST)
	public String communityUpdate(Model model, @PathVariable("buildNo") int buildNo, HttpServletRequest request, RedirectAttributes rttr) throws ParseException {		
		URB010Dto dto = new URB010Dto();		
		
		int community_registerNo = Integer.parseInt(request.getParameter("community_registerNo")); //no
		String community_author = request.getParameter("community_author"); // 작성자
		String community_title = request.getParameter("community_title"); // 제목
		String community_password = request.getParameter("community_password"); // 패스워드 
		String community_content = request.getParameter("community_content"); // 내용
			
		dto.setCommunity_registerNo(community_registerNo);
		dto.setCommunity_author(community_author);
		dto.setCommunity_buildingInfo(buildNo);
		dto.setCommunity_title(community_title);
		dto.setCommunity_password(community_password);
		dto.setCommunity_content(community_content);
		System.out.println(dto.toString()+" "+dto.getCommunity_registerNo());
		int result = service.updateCommunity(dto);

		String resultString = "error";

		if (result > 0) {
			resultString = "글이 수정되었습니다.";
		}
		
		rttr.addFlashAttribute("result", resultString);
		
		System.out.println("글이 수정되었습니다.");
		System.out.println(buildNo);		
		
		return "redirect:/builid/" + buildNo + "/community";
	}
	

	
	// 커뮤니티 글 삭제(삭제 플래그 이용)
	@RequestMapping(value="/builid/{buildNo}/community/remove", method = RequestMethod.GET) 
	public String communityRemove(Model model, int id, @PathVariable("buildNo") int buildNo, HttpServletRequest request, RedirectAttributes rttr) {			
		URB010Dto dto = new URB010Dto();	
		
		String resultString = "error";		
		int result = service.removeCommunity(id);
		
		if (result > 0) {
			resultString = "글이 삭제되었습니다.";
		}		
		rttr.addFlashAttribute("result", resultString);	
		
		System.out.println("글이 삭제되었습니다.");	
        
		return "redirect:/builid/" + buildNo + "/community";
		
	}
	
	
	// 커뮤니티 답글 
	@RequestMapping(value = "/builid/{buildNo}/community/comment/create", method = RequestMethod.POST)
	public String replyCreate(Model model, @PathVariable("buildNo") int buildNo, HttpServletRequest request, RedirectAttributes rttr) throws ParseException {
		URB010Dto dto = new URB010Dto(); 
				
		String reply_author = request.getParameter("reply_author"); // 작성자
		String reply_password = request.getParameter("reply_password"); // 비밀번호
		String reply_content = request.getParameter("reply_content"); // 내용
		
		dto.setReply_author(reply_author);
		dto.setReply_password(reply_password);
		dto.setReply_content(reply_content);

		int result = service.createReply(dto);

		String resultString = "error";

		if (result > 0) {
			resultString = "답글이 등록되었습니다.";
		}
		
		rttr.addFlashAttribute("result", resultString);
		
		System.out.println("답글이 등록되었습니다.");

		return "redirect:/builid/" + buildNo + "/community"; // redirect는 {} 못넘김. 인코딩 해줘야함
		
	}
	
		
	
}
