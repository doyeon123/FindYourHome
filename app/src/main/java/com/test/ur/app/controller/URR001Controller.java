package com.test.ur.app.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.ur.app.Util.UploadFileUtils;
import com.test.ur.app.controller.base.BaseController;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.PageNavi;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.URR001Dto;
import com.test.ur.app.enums.CodeEnum;
import com.test.ur.app.services.CodeService;
import com.test.ur.app.services.URR001Service;

@Controller
public class URR001Controller extends BaseController {
	
	@Autowired
	private URR001Service service;
	
	@Autowired
	private CodeService codeService;
	
	private static final Logger logger = LoggerFactory.getLogger(URR001Controller.class);

	// 방 리스트
	@RequestMapping(value = "/admin/room", method = RequestMethod.GET)
	public String roomList(Locale locale, Model model, PagingDto paging, int id, String area, String search, HttpServletRequest request) {
		
		URR001Dto dto = new URR001Dto();
		
		int startnum = paging.getPageNo()*paging.getAmount()-10;
		int endnum = paging.getPageNo()*paging.getAmount();
		List<URR001Dto> list = service.findAll(startnum, endnum, id, search);
		List<CodeDto> roomList = codeService.findByCode(CodeEnum.ROOM);
		model.addAttribute("id", id);
		model.addAttribute("area", area);
		model.addAttribute("roomList", roomList);
		System.out.println(startnum+"/"+endnum);
		model.addAttribute("list", list);
		System.out.println(list.size());
		model.addAttribute("pageNavi", new PageNavi(paging, service.getTotal(id, search)));
		model.addAttribute("dto", dto);
		
		logger.info("roomList page");

		return "/admin/URR002L01";
	}
	
	// 방 상세
	@RequestMapping(value = "/admin/room/detail", method = RequestMethod.GET)
	public String roomDetail(Model model, HttpServletRequest request, int id) {
		URR001Dto dto = service.roomDetail(id);
		model.addAttribute("dto", dto);
		return "/admin/URR002D01";
	}
	
	// 방 등록
	@RequestMapping(value = "/admin/room/create", method = RequestMethod.GET)
	public String loadRoomPage(Model model, int id, String area) {
		List<CodeDto> entireList = service.entireList();
		List<CodeDto> roomStructureList = codeService.findByCode(CodeEnum.ROOM);
		model.addAttribute("entireList", entireList);
		model.addAttribute("roomStructureList", roomStructureList);
		model.addAttribute("id", id);
		model.addAttribute("area", area);
		model.addAttribute("form", "/admin/room/create");
		return "/admin/URR002E02";
	}
	
	//register
	@RequestMapping(value = "/admin/room/create", method = RequestMethod.POST)
	public String insertPage(Model model, MultipartHttpServletRequest mtfRequest, HttpServletRequest request) throws Exception {
		URR001Dto dto = new URR001Dto();
		String filePath ="C:\\images\\20211201\\1831c155440341feb29565c4080135b1.jpg";
		String filePath2 ="C:\\images\\20211201\\1bf0e629df2240cca5c50e625746e6b1.jpg";
		String filePath3 ="C:\\images\\20211201\\1b43365249c24b718ec2ce4e58ad4a77.jpg";
		String zoneId = request.getParameter("room_zoneInfo");
		String area = request.getParameter("room_areaInfo");
		MultipartFile file = mtfRequest.getFile("room_roomArrange");
		MultipartFile file2 = mtfRequest.getFile("room_img360");
		MultipartFile file3 = mtfRequest.getFile("room_img");
		
		if(!file.isEmpty())
			filePath = UploadFileUtils.uploadFile(file);
		if(!file2.isEmpty())
			filePath2 = UploadFileUtils.uploadFile(file2);
		if(!file3.isEmpty())
			filePath3 = UploadFileUtils.uploadFile(file3);
		
		System.out.println(filePath);
		dto.setRoom_zoneInfo(Integer.parseInt(zoneId));
		dto.setRoom_areaInfo(area);
		dto.setRoom_structure(request.getParameter("room_structure"));
		dto.setRoom_flowArea(Integer.parseInt(request.getParameter("room_flowArea")));
		dto.setRoom_sikiking(request.getParameter("room_sikiking"));
		dto.setRoom_racing(request.getParameter("room_racing"));
		dto.setRoom_roomNo(Integer.parseInt(request.getParameter("room_roomNo")));
		dto.setRoom_yaching(Integer.parseInt(request.getParameter("room_yaching")));
		dto.setRoom_numOfFloors(Integer.parseInt(request.getParameter("room_numOfFloors")));
		dto.setRoom_roomArrange(filePath);
		dto.setRoom_img360(filePath2);
		dto.setRoom_img(filePath3);
		
		service.insertRoom(dto);
		
		model.addAttribute("id", zoneId);
		model.addAttribute("area", area);
		
		return "redirect:/admin/room";
	}
	
	// 방 수정
	@RequestMapping(value = "/admin/room/builids", method = RequestMethod.GET)
	public String editRoom(Locale locale, Model model, int no) {
		URR001Dto dto = service.getRoom(no);
		List<CodeDto> roomStructureList = codeService.findByCode(CodeEnum.ROOM);
		model.addAttribute("roomStructureList", roomStructureList);
		model.addAttribute("dto", dto);
		model.addAttribute("id", dto.getRoom_zoneInfo());
		model.addAttribute("area", dto.getRoom_areaInfo());
		model.addAttribute("form", "/admin/room/builids");
		System.out.println(dto);
		return "/admin/URR002E02";
	}
	
	// update
	@RequestMapping(value = "/admin/room/builids", method = RequestMethod.POST)
	public String editRoom2(Model model, MultipartHttpServletRequest mtfRequest, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
		URR001Dto dto = new URR001Dto();
		String filePath ="";
		String filePath2 ="";
		String filePath3 ="";
		MultipartFile file = mtfRequest.getFile("room_roomArrange");
		MultipartFile file2 = mtfRequest.getFile("room_img360");
		MultipartFile file3 = mtfRequest.getFile("room_img");
	
		if(!file.isEmpty())
			filePath = UploadFileUtils.uploadFile(file);
		if(!file2.isEmpty())
			filePath2 = UploadFileUtils.uploadFile(file2);
		if(!file3.isEmpty())
			filePath3 = UploadFileUtils.uploadFile(file3);
		
		System.out.println(filePath);
		
		String zoneId = request.getParameter("room_zoneInfo");
		int roomRegisterNO = Integer.parseInt(request.getParameter("room_registerNo"));
		System.out.println(zoneId);
		dto.setRoom_zoneInfo(Integer.parseInt(zoneId));
		String area = request.getParameter("room_areaInfo");
		dto.setRoom_areaInfo(area);
		dto.setRoom_registerNo(roomRegisterNO);
		dto.setRoom_structure(request.getParameter("room_structure"));
		dto.setRoom_flowArea(Integer.parseInt(request.getParameter("room_flowArea")));
		dto.setRoom_sikiking(request.getParameter("room_sikiking"));
		dto.setRoom_racing(request.getParameter("room_racing"));
		dto.setRoom_roomNo(Integer.parseInt(request.getParameter("room_roomNo")));
		dto.setRoom_yaching(Integer.parseInt(request.getParameter("room_yaching")));
		dto.setRoom_numOfFloors(Integer.parseInt(request.getParameter("room_numOfFloors")));
		dto.setRoom_roomArrange(filePath);
		dto.setRoom_img360(filePath2);
		dto.setRoom_img(filePath3);
		
		int res = service.updateRoom(dto);
		String resMsg = "";
		rttr.addAttribute("id", zoneId);
		rttr.addAttribute("area", area);
		
		if(res>0) {
			resMsg = "업데이트에 성공했습니다.";
			System.out.println(resMsg);
			return "redirect:/admin/room";
		}
		else {
			resMsg = "업데이트에 실패했습니다.";
			System.out.println(resMsg);
			return "redirect:/admin/room";
		}
		
//		model.addAttribute("id", zoneId);
//		model.addAttribute("area", area);
		
	}
	
	// 이미지 보여주기
	@ResponseBody
	@RequestMapping(value = "/fileDisplay", method = RequestMethod.GET)
	public ResponseEntity<byte[]> fileDisplay(@Param("file_name") String file_name){
		//log.info("fileDisplay...."+file_name);
		HttpHeaders headers = new HttpHeaders();
		File file = new File(file_name);
		System.out.println("file_name"+file.getName());
		//log.info(file);
		if(file.exists()) {
			try {
				headers.add("Content-Type", Files.probeContentType(file.toPath()));
				return new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
