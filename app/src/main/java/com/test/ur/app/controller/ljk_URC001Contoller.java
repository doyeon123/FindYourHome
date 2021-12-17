package com.test.ur.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.ur.app.controller.base.BaseController;
import com.test.ur.app.dto.PageNavi;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.ljk_URC001Dto;
import com.test.ur.app.services.ljk_URC001Service;



@Controller
public class ljk_URC001Contoller extends BaseController {

	@Autowired
	private ljk_URC001Service service;


	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String boardlist(Model model, @RequestParam(defaultValue = "1") int page, PagingDto paging) {

		int startnum = paging.getPageNo() * paging.getAmount() - 10;
		
		
		List<ljk_URC001Dto> list = service.getList(startnum);

//		int ab = list.get(0).getConsulting_registerno();
//		System.out.println(ab);
		
		
		model.addAttribute("list", list);
		model.addAttribute("pageNavi", new PageNavi(paging, service.getTotal()));
		//startpage,endpage,perv,next값 정함
		
		return "contents/ljk_URC001L01";
	}

	@GetMapping("/consulting/create")
	public String insert() {
		return "contents/ljk_URC001E01";
	}

	@PostMapping("/consulting/create")
	public String insert2(ljk_URC001Dto vo, RedirectAttributes rttr) {
		System.out.println(vo);
		int res = service.insertBoard(vo);
		rttr.addFlashAttribute("resMsg", vo.getConsulting_registerno() + "글이 작성되었습니다");

		return "redirect:/index";
	}

	@RequestMapping(value = "/consulting/update", method = RequestMethod.GET)
	public String update(Model model, int no, HttpServletRequest request) {

		System.out.println(no);
		ljk_URC001Dto vo = service.get(no);
		model.addAttribute("vo", vo);

		model.addAttribute("volist",
				vo.getConsulting_registerno() + '/' + vo.getConsulting_author() + '/' + vo.getConsulting_content() + '/'
						+ vo.getConsulting_deleteflag() + '/' + vo.getConsulting_password() + '/'
						+ vo.getConsulting_title() + '/' + vo.getConsulting_rewritedate() + '/'
						+ vo.getConsulting_writedate());

		return "contents/ljk_URC001E01";
	}

	
	// 에딧(포스트)
	@PostMapping("/consulting/update/{no}")
	public String editExe(@PathVariable("no") int no ,ljk_URC001Dto vo, RedirectAttributes rttr) {
		
		System.out.println(no);
		System.out.println(vo.getConsulting_author());
			int res = service.update(vo);
		
		return "redirect:/index";
	}
	
	
	@GetMapping("/consulting/Popup")
	public String popup() {
		return "contents/Popup";
	}
	
	@RequestMapping(value = "/checkpw", method = RequestMethod.POST)// AJAX와 URL을 매핑시켜줌 
	@ResponseBody
		public Map<String, Object> checkpassword(@RequestBody ljk_URC001Dto vo){
		Map<String, Object> map = new HashMap<>();
		String result = null;
		ljk_URC001Dto vo2 = service.checkpassword(vo);
		
		
		if(vo2 != null) {
			result = "Success";
			map.put("result", result);
			return map;
		}else {
			result = "fail";
			map.put("result", result);
			return map;
		}
		
	}
	
	@RequestMapping(value = "/consulting/remove", method = RequestMethod.GET)
	public String remove(int no ,RedirectAttributes rttr) {
		
		int res = service.remove(no);
		// 삭제 성공 -> 리스트
		if(res>0) {
			return "redirect:/index";
		} else {
		// 삭제 실패 -> 상세화면
			return "redirect:/consulting/update";
		}
		
		
	}

}
