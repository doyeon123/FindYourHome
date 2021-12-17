package com.test.ur.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.ur.app.controller.base.BaseController;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.PageNavi;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.URN002Dto;
import com.test.ur.app.services.URN002Service;

@Controller
public class URN002Controller extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(URN002Controller.class);
	
	@Autowired
	private URN002Service service;
	
	// 상세페이지 가져오기 int id는 path의 ___?ㅁㅁ= 에서 ㅁㅁ
	@RequestMapping(value="/admin/notice/detail", method = RequestMethod.GET)
	public String adminNoticeDetailList(Model model, int id) {
		URN002Dto DTO = service.findDetail(id);
		model.addAttribute("notice", DTO);
		
		return "/admin/URN002D01";
		
	}
	
	// 리스트 가져오기+페이징
	@RequestMapping(value="/admin/notice", method=RequestMethod.GET)
	public String adminNoticeList(Model model, @RequestParam(defaultValue = "1") int page, PagingDto paging) {
		logger.info("notice page : " + page);
		
		// getPageNo->페이지 수, getAmount->한페이지에 들어있는 게시물 수
		int startnum = paging.getPageNo()*paging.getAmount()-10;
		
		List<URN002Dto> DTO = service.findAll(startnum);
		model.addAttribute("adminNoticeList", DTO);
		model.addAttribute("pageNavi", new PageNavi(paging, service.getTotal()));
		
		return "/admin/URN002D02";
	}
	
	// 지역코드, 카테고리
	@RequestMapping(value="/admin/notice/create", method = RequestMethod.GET)
	public String write(Model model) {
		List<CodeDto> codeAList = service.codeAList();
		List<CodeDto> codeCList = service.codeCList();
		model.addAttribute("codeAList", codeAList);
		model.addAttribute("codeCList", codeCList);
		return "/admin/URN002E02";
	}
	
	// 공지사항 등록
	@RequestMapping(value="/admin/notice/create", method = RequestMethod.POST)
	public String adminregister(Model model, HttpServletRequest request, RedirectAttributes rttr) throws ParseException {
		URN002Dto dto = new URN002Dto();
		//Calendar cal = Calendar.getInstance();
		
		// 년월일 제공
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		
		// 등록번호, 작성일, 수정일은 seq 사용했기 때문
		String notice_category = request.getParameter("notice_category");
		String notice_entireRegionalCode = request.getParameter("notice_entireRegionalCode");
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		String notice_link = request.getParameter("notice_link");
		
		// 분이 한자리 수로 나오는 부분 수정
		/*
		 * if(cal.get(Calendar.HOUR)<10) hour = "0"+cal.get(Calendar.HOUR); else hour =
		 * ""+cal.get(Calendar.HOUR);
		 */
		
		String notice_displyDateString = request.getParameter("notice_displyDate");
		//String notice_displyDateString = request.getParameter("notice_displyDate")+hour+cal.get(Calendar.MINUTE)+cal.get(Calendar.SECOND);
		Date notice_displyDate = fmtDate.parse(notice_displyDateString);
		
		dto.setNotice_category(notice_category);
		dto.setNotice_entireRegionalCode(notice_entireRegionalCode);
		dto.setNotice_title(notice_title);
		dto.setNotice_content(notice_content);
		dto.setNotice_link(notice_link);
		dto.setNotice_displyDate(notice_displyDate);
		
		int result = service.createNotice(dto);
		
		String resultString = "error";
		
		if(result>0)
			resultString = "글이 등록되었습니다.";
			rttr.addFlashAttribute("result", resultString);
		
		return "redirect:/admin/notice";
		}
	
	// 수정할 내용 불러오기
	@RequestMapping(value="/admin/notice/update", method = RequestMethod.GET)
	public String adminUpdate(Model model, int id) {
		URN002Dto dto = service.getNotice(id);
		model.addAttribute("notice", dto);
		
		List<CodeDto> codeAList = service.codeAList();
		List<CodeDto> codeCList = service.codeCList();
		model.addAttribute("codeAList", codeAList);
		model.addAttribute("codeCList", codeCList);
		
		return "/admin/URN002E02";
	}
	
	// 공지사항 수정
	@RequestMapping(value="/admin/notice/update", method = RequestMethod.POST)
	public String adminUpdate1(Model model, HttpServletRequest request, RedirectAttributes rttr) throws ParseException {
		URN002Dto dto = new URN002Dto();
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		Date notice_displyDate = null;
		
		int notice_registerNo = Integer.parseInt(request.getParameter("notice_registerNo"));
		String notice_category = request.getParameter("notice_category");
		String notice_entireRegionalCode = request.getParameter("notice_entireRegionalCode");
		String notice_title = request.getParameter("notice_title");
		String notice_content = request.getParameter("notice_content");
		String notice_link = request.getParameter("notice_content");
		
		String notice_displyDateString = request.getParameter("notice_displyDate");
			
		// 표시기간을 아무것도 설정하지 않았을때
		if(!notice_displyDateString.isEmpty())
			notice_displyDate = fmtDate.parse(notice_displyDateString);
		
		dto.setNotice_registerNo(notice_registerNo);
		dto.setNotice_category(notice_category);
		dto.setNotice_entireRegionalCode(notice_entireRegionalCode);
		dto.setNotice_title(notice_title);
		dto.setNotice_content(notice_content);
		dto.setNotice_link(notice_link);
		dto.setNotice_displyDate(notice_displyDate);
		
		int result = service.updateNotice(dto);
		
		String resultString = "error";
			
		if(result>0)
			resultString = notice_registerNo+"번 글이 수정되었습니다.";
			rttr.addFlashAttribute("result", resultString);
		
		return "redirect:/admin/notice";
		}
}
