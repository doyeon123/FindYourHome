package com.test.ur.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.ur.app.controller.base.BaseController;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.ljk_URC002Dto;
import com.test.ur.app.services.ljk_URC002Service;


@Controller
public class ljk_URC002Contoller extends BaseController{
	
	@Autowired
	private ljk_URC002Service service;
	
	@GetMapping("/admin/consulting/detail")
	public String get(PagingDto paging, int no,ljk_URC002Dto vo,Model model) {
		// 상세정보 조회
		vo = service.get(no);
		System.out.println(no);
		//모델에 담아서 화면에 전달
		model.addAttribute("vo", vo);
		//리턴이 없으므로 페이지 연결
		
		return "contents/admin/ljk_URC002E01";
	}
}
