package com.test.ur.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.test.ur.app.Util.UploadFileUtils;
import com.test.ur.app.controller.base.BaseController;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.PageNavi;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.dto.URR001Dto;
import com.test.ur.app.enums.CodeEnum;
import com.test.ur.app.services.CodeService;
import com.test.ur.app.services.URB002Service;
import com.test.ur.app.services.URR001Service;

@Controller
public class URB002Controller extends BaseController {
	
	@Autowired
	private URB002Service service;
	@Autowired
	private CodeService codeService;
	@Autowired
	private URR001Service roomService;
	
	// 리스트 상세보기 테이블 가져오기
	@RequestMapping(value = "/admin/builids", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request, PagingDto paging, String search_codeA, String search_codeB, String search_codeC, String search_name) {
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
		
		int startnum = paging.getPageNo()*paging.getAmount()-10;
		int endnum = paging.getPageNo()*paging.getAmount();
		
        System.out.println("#######");
        List<URB002Dto> list = service.buildList(startnum, endnum, search_codeA, search_codeB, search_codeC, search_name);
        model.addAttribute("list", list);
		
		model.addAttribute("pageNavi", new PageNavi(paging, service.getTotal()));
		List<CodeDto> codeAList = service.codeAList();
		model.addAttribute("codeAList",codeAList);
		return "/admin/URB002L01";
	}
	
	// 리스트부분 2번째 셀렉트박스를 위한 정보 전달
	@ResponseBody
	@RequestMapping(value = "/admin/builids/{codeA}", method = RequestMethod.GET)
	public Map<String, Object> list(@PathVariable("codeA")String codeA) {
		System.out.println("codeA @@@@@@@@@@@@@ : " + codeA);
		Map<String, Object> map = new HashMap<String, Object>();
		List<CodeDto> list = service.codeBList(codeA);
		if(list != null) {
			if(list.size()>0) {
				map.put("result", list);
			} else {
				map.put("result", "error");
			}
		} else {
			map.put("result", "error");
		}
		return map;
	}

	// 리스트부분 3번째 셀렉트박스를 위한 정보 전달
	@ResponseBody
	@RequestMapping(value = "/admin/builids/{codeA}/{codeB}", method = RequestMethod.GET)
	public Map<String, Object> list(@PathVariable("codeA")String codeA, @PathVariable("codeB")String codeB) {
		System.out.println("codeA @@@@@@@@@@@@@ : " + codeA);
		System.out.println("codeB @@@@@@@@@@@@@ : " + codeB);
		Map<String, Object> map = new HashMap<String, Object>();
		List<CodeDto> list = service.codeCList(codeA, codeB);
		if(list != null) {
			if(list.size()>0) {
				map.put("result", list);
			} else {
				map.put("result", "error");
			}
		} else {
			map.put("result", "error");
		}
		return map;
	}
	
	
	
    // 작성페이지 자료 전달
	@RequestMapping(value = "/admin/builids/create", method = RequestMethod.GET)
	public String write(Model model) {
		
		List<CodeDto> codeAList = service.codeAList();
		List<CodeDto> codeEList = service.codeEList();
		List<CodeDto> codeIList = codeService.findByCode(CodeEnum.INTERNET);
		model.addAttribute("codeAList", codeAList);
		model.addAttribute("codeEList", codeEList);
		model.addAttribute("codeIList", codeIList);
		model.addAttribute("form", "/admin/builids/create");
		
		return "/admin/URB002E02";
	}
	
    // 등록을 위한 컨트롤러 이미지파일업로드와 테이블조인을 이용하여 mapper 작성
	@RequestMapping(value="/admin/builids/create", method = RequestMethod.POST)
	public String Register(HttpServletRequest req, MultipartHttpServletRequest mtfRequest, @RequestParam Map<String, Object> map) throws Exception {
		
		String filePath = "";
		String filePath2 = "";
		String filePath3 = "";
		String filePath4 = "";
		String filePath5 = "";
		
		MultipartFile file = mtfRequest.getFile("zone_layout"); // 이미지 파일을 저장후 업로드
		MultipartFile file2 = mtfRequest.getFile("zone_buildingImg");
		MultipartFile file3 = mtfRequest.getFile("zone_locationImg");
		MultipartFile file4 = mtfRequest.getFile("zone_regionalImg");
		
		// 여러 파일을 배열로 받아 스트링형태로 추가한다.
		List<String> sImges = new ArrayList<String>();
		
		List<MultipartFile> zone_surroundingFiles = mtfRequest.getFiles("surroundingImg_images");
		if(zone_surroundingFiles.get(0).getSize() != 0) {
			System.out.println("@@@@@@"+zone_surroundingFiles.size());
			for(int i=0; i<zone_surroundingFiles.size(); i++) {
				sImges.add(UploadFileUtils.uploadFile(zone_surroundingFiles.get(i)));
			}
		}
		
		if(!file.isEmpty()) {
			filePath = UploadFileUtils.uploadFile(file);
		}
		if(!file2.isEmpty())
			filePath2 = UploadFileUtils.uploadFile(file2);
		if(!file3.isEmpty())
			filePath3 = UploadFileUtils.uploadFile(file3);
		if(!file4.isEmpty())
			filePath4 = UploadFileUtils.uploadFile(file4);
		
		filePath5 = String.join(",", sImges);
		
		map.put("zone_layout", filePath);
		map.put("zone_buildingImg", filePath2);
		map.put("zone_locationImg", filePath3);
		map.put("zone_regionalImg", filePath4);
		map.put("zone_surroundingImg", filePath5);
		
        // 체크박스 배열로 받아서 스트링으로 풀어주기
		String[] sttr = req.getParameterValues("zone_note");
		
		String zonote = String.join(",", sttr);
		
		map.put("zone_note", zonote);
		
		System.out.println(zonote);
		
		System.out.println("Register @@@@@@@@ : "+ map.toString());
		
		System.out.println( map.values() );
		
		service.Register(map);
		
		return "redirect:/admin/builids";
	}
	
    // 등록부분 2번째 셀렉트박스를 위한 정보 전달
	@ResponseBody
	@RequestMapping(value = "/admin/builids/create/{codeA}", method = RequestMethod.GET)
	public Map<String, Object> write(@PathVariable("codeA")String codeA) {
		System.out.println("codeA @@@@@@@@@@@@@ : " + codeA);
		Map<String, Object> map = new HashMap<String, Object>();
		List<CodeDto> list = service.codeBList(codeA);
		if(list != null) {
			if(list.size()>0) {
				map.put("result", list);
			} else {
				map.put("result", "error");
			}
		} else {
			map.put("result", "error");
		}
		return map;
	}

    // 등록부분 3번째 셀렉트박스를 위한 정보 전달
	@ResponseBody
	@RequestMapping(value = "/admin/builids/create/{codeA}/{codeB}", method = RequestMethod.GET)
	public Map<String, Object> write(@PathVariable("codeA")String codeA, @PathVariable("codeB")String codeB) {
		System.out.println("codeA @@@@@@@@@@@@@ : " + codeA);
		System.out.println("codeB @@@@@@@@@@@@@ : " + codeB);
		Map<String, Object> map = new HashMap<String, Object>();
		List<CodeDto> list = service.codeCList(codeA, codeB);
		if(list != null) {
			if(list.size()>0) {
				map.put("result", list);
			} else {
				map.put("result", "error");
			}
		} else {
			map.put("result", "error");
		}
		return map;
	}
	
	// 리스트 불러오기
	@RequestMapping(value = "/admin/builds", method = RequestMethod.GET)
	public String detail(Model model, int no, PagingDto paging) {
		System.out.println(no);
		
		int startnum = paging.getPageNo()*paging.getAmount()-10;
		int endnum = paging.getPageNo()*paging.getAmount();
		
		URB002Dto list = service.detail(no);
		List<CodeDto> equipList = codeService.findByCode(CodeEnum.EQUIPMENT);
		List<CodeDto> IList = codeService.findByCode(CodeEnum.INTERNET);
		System.out.println("@@@@@@@@@"+equipList.size());
		model.addAttribute("equipList", equipList);
        model.addAttribute("detail", list); // 리스트로 받은것은 사용할때 한번 풀어주고 사용한다. c:forEach 사용
		model.addAttribute("IList",IList);
		return "/admin/URB002D01";
	}
	
    // 수정하기 컨트롤러
	@RequestMapping(value="/admin/builids/update" , method=RequestMethod.GET)
	public String update(Model model, int zone_registerNo) {
		System.out.println("update @@@@@@@@ : " + zone_registerNo);
		URB002Dto list = service.detail(zone_registerNo);
		String[] temp = list.getZone_note().split(",");
		model.addAttribute("update", list);
		model.addAttribute("temp", temp);
		System.out.println("@@@@@@"+list.getZone_registerNo());
		
		List<CodeDto> codeIList = codeService.findByCode(CodeEnum.INTERNET);
 		List<CodeDto> codeAList = service.codeAList();
		List<CodeDto> codeBListAll = service.codeBListAll();
		List<CodeDto> codeCListAll = service.codeCListAll();
		List<CodeDto> codeEList = service.codeEList();
		model.addAttribute("codeAList", codeAList);
		model.addAttribute("codeBListAll", codeBListAll);
		model.addAttribute("codeCListAll", codeCListAll);
		model.addAttribute("codeEList", codeEList);
		model.addAttribute("codeIList", codeIList);
		model.addAttribute("form", "/admin/builids/update");
		
		return "/admin/URB002E02";
	}
	
    // 수정을 위한 컨트롤러 이미지파일업로드와 테이블조인을 이용하여 mapper 작성
	@RequestMapping(value="/admin/builids/update", method = RequestMethod.POST)
	public String update(HttpServletRequest req, MultipartHttpServletRequest mtfRequest, @RequestParam Map<String, Object> map) throws Exception {
		
		String filePath = "";
		String filePath2 = "";
		String filePath3 = "";
		String filePath4 = "";
		String filePath5 = "";
		
        MultipartFile file = mtfRequest.getFile("zone_layout"); // 이미지 파일을 저장후 업로드
		MultipartFile file2 = mtfRequest.getFile("zone_buildingImg");
		MultipartFile file3 = mtfRequest.getFile("zone_locationImg");
		MultipartFile file4 = mtfRequest.getFile("zone_regionalImg");
		
		List<String> sImges = new ArrayList<String>();
		
		List<MultipartFile> zone_surroundingFiles = mtfRequest.getFiles("surroundingImg_images");
		if(zone_surroundingFiles.get(0).getSize() != 0) {
			System.out.println("@@@@@@"+zone_surroundingFiles.size());
			for(int i=0; i<zone_surroundingFiles.size(); i++) {
				sImges.add(UploadFileUtils.uploadFile(zone_surroundingFiles.get(i)));
			}
		}
			
		
		if(!file.isEmpty()) {
			filePath = UploadFileUtils.uploadFile(file);
			
		}
		if(!file2.isEmpty())
			filePath2 = UploadFileUtils.uploadFile(file2);
		if(!file3.isEmpty())
			filePath3 = UploadFileUtils.uploadFile(file3);
		if(!file4.isEmpty())
			filePath4 = UploadFileUtils.uploadFile(file4);
		
		filePath5 = String.join(",", sImges);
		
		map.put("zone_layout", filePath);
		map.put("zone_buildingImg", filePath2);
		map.put("zone_locationImg", filePath3);
		map.put("zone_regionalImg", filePath4);
		map.put("zone_surroundingImg", filePath5);
		
        // 체크박스 배열로 받아서 스트링으로 풀어주기
		String[] sttr = req.getParameterValues("zone_note");
		
		String zonote = String.join(",", sttr);
		
		map.put("zone_note", zonote);
		
		System.out.println(zonote);
		
		System.out.println("Register @@@@@@@@ : "+ map.toString());
		
		service.Update(map);
		
		return "redirect:/admin/builids";
	}
}
