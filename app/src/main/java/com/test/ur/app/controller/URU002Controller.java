package com.test.ur.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.PageNavi;
import com.test.ur.app.dto.PagingDto;
import com.test.ur.app.dto.URB002Dto;
import com.test.ur.app.dto.URU002Dto;
import com.test.ur.app.services.URB002Service;
import com.test.ur.app.services.URU002Service;

@Controller
public class URU002Controller {

	@Autowired
	private URU002Service service;

	@Autowired
	private URB002Service buildsService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(URU002Controller.class);
	
	
	@RequestMapping(value="/admin/receipt/search", method = RequestMethod.GET)
	public String Search_Get(HttpServletRequest req, RedirectAttributes rttr, Model model, PagingDto paging) {
		Map<String, ?> map = RequestContextUtils.getInputFlashMap(req);
		
		int startnum = paging.getPageNo()*paging.getAmount()-10;
		int endnum = paging.getPageNo()*paging.getAmount();
		
		if(map!=null) {
			List<URB002Dto> list = (List<URB002Dto>)map.get("searchList");
			model.addAttribute("list", list);
			model.addAttribute("pageNavi", new PageNavi(paging, buildsService.getTotal()));
		} else {
			System.out.println("#######");
			List<URB002Dto> list = buildsService.boardList(startnum, endnum);
			model.addAttribute("list", list);
			model.addAttribute("pageNavi", new PageNavi(paging, buildsService.getTotal()));
		}
		
		List<CodeDto> codeAList = buildsService.codeAList();
		
		List<CodeDto> codeBListAll = buildsService.codeBListAll();
		List<CodeDto> codeCListAll = buildsService.codeCListAll();
		
		System.out.println("1111"+codeAList);
		model.addAttribute("codeAList",codeAList);
		model.addAttribute("codeBListAll",codeBListAll);				
		model.addAttribute("codeCListAll",codeCListAll);
	return "/admin/URU002S01";
	}
	
	@ResponseBody
	@RequestMapping(value = "/admin/receipt/search/{codeA}", method = RequestMethod.GET)
	public Map<String, Object> list(@PathVariable("codeA")String codeA) {
		System.out.println("codeA @@@@@@@@@@@@@ : " + codeA);
		Map<String, Object> map = new HashMap<String, Object>();
		List<CodeDto> list = buildsService.codeBList(codeA);
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
		@RequestMapping(value = "/admin/receipt/search/{codeA}/{codeB}", method = RequestMethod.GET)
		public Map<String, Object> list(@PathVariable("codeA")String codeA, @PathVariable("codeB")String codeB) {
			System.out.println("codeA @@@@@@@@@@@@@ : " + codeA);
			System.out.println("codeB @@@@@@@@@@@@@ : " + codeB);
			Map<String, Object> map = new HashMap<String, Object>();
			List<CodeDto> list = buildsService.codeCList(codeA, codeB);
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
	
	
	@RequestMapping(value="/admin/receipt/search", method = RequestMethod.POST)
	public String Search_Post(HttpServletRequest req, RedirectAttributes rttr, Model model) {
		String zone_entireRegionalCode = (String)req.getParameter("zone_entireRegionalCode");
		String zone_areaRegionalCode = (String)req.getParameter("zone_areaRegionalCode");
		String zone_stateRegionalCode = (String)req.getParameter("zone_stateRegionalCode");
		String zone_officalName = (String)req.getParameter("zone_officalName");
		System.out.println("codeA @@@@@@@@@@@@@ : " + zone_entireRegionalCode);
		System.out.println("codeB @@@@@@@@@@@@@ : " + zone_areaRegionalCode);
		System.out.println("codeC @@@@@@@@@@@@@ : " + zone_stateRegionalCode);
		System.out.println("zone_officalName @@@@@@@@@@@@@ : " + zone_officalName);
		List<URB002Dto> searchList = service.bulidSearch(zone_entireRegionalCode, zone_areaRegionalCode, zone_stateRegionalCode, zone_officalName);
		searchList.forEach(a -> System.out.println(a));
		rttr.addFlashAttribute("searchList", searchList);
		
		return "redirect:/admin/receipt/search";
	}
	
	

	
	

	//상세페이지
	@RequestMapping(value = "/admin/receipt/detail", method = RequestMethod.GET)
	public String adminReceiptDetailList(Model model, int no) {

		URU002Dto applicantIn = service.readInDetails(no);
		model.addAttribute("applicantIn", applicantIn);
		model.addAttribute("receipt.applicant_applyNo", no);
		// System.out.println("1234567"+no);
		// System.out.println("applicant_nameKanji"+applicantIn);
		return "/admin/URU002D01";
	}
	
	//수정할 내용 불러오기
	@RequestMapping(value="/admin/receipt/update", method = RequestMethod.GET)
	public String receiptUpdate(Model model, int id) {
		URU002Dto dto = service.getReceipt(id);
		model.addAttribute("receipt", dto);
		model.addAttribute("form", "/admin/receipt/update");
		model.addAttribute("id", id);
		
		
		List<CodeDto> list = service.kokuseki();
		System.out.println(list.size());
		model.addAttribute("kokuseki", list);
		logger.info("Admin main");
		return "/admin/URU002E01";
	}
	
	//수정
	@RequestMapping(value="/admin/receipt/update", method = RequestMethod.POST)
	public String receiptUpdate1(HttpServletRequest request) throws ParseException {
		URU002Dto dto = new URU002Dto();
		
		int id0 = Integer.parseInt(request.getParameter("applicant_applyNo"));
		dto.setApplicant_applyNo(id0);
		
		
		
		
		dto.setApplicant_buildingInfo("18");
		
	
		
		String id1 = request.getParameter("kanjinamae");
		dto.setApplicant_nameKanji(id1);

		String id4 = request.getParameter("furigananamae");
		dto.setApplicant_nameFurigana(id4);

		String id2 = request.getParameter("senengatsunichi");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		System.out.println(format.parse(id2));
		dto.setApplicant_birth(format.parse(id2));

		String id18 = request.getParameter("seibutsu");
		dto.setApplicant_gender(id18);

		String id3 = request.getParameter("flexRadioDefault");
		dto.setApplicant_nationality(id3);

		if ("N2".equals(id3)) {

			String id5 = request.getParameter("zairyukado");

			if (id5 == null) {
				id5 = "0";
			}
			dto.setApplicant_regidentsCardFlag(id5);

			String id6 = request.getParameter("gaikokunyukyobi");
			SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
			System.out.println(format1.parse(id6));
			dto.setApplicant_movingIn(format.parse(id6));

			String id7 = request.getParameter("zairyushikaku");
			if (id7 == null) {
				id7 = "0";
			}
			dto.setApplicant_regidentsEligible(id7);

			String id8 = request.getParameter("zairyukikan");
			dto.setApplicant_regidentsDuration(id8);

			String id9 = request.getParameter("zairyumanryobi");
			SimpleDateFormat format3 = new SimpleDateFormat("yyyyMMdd");
			System.out.println(format3.parse(id9));
			dto.setApplicant_regidentsEndDate(format3.parse(id9));
		}

		String id10 = request.getParameter("fonbango");
		dto.setApplicant_telNum(id10);
		String id11 = request.getParameter("yubinbango");
		dto.setApplicant_postalCode(id11);
		String id12 = request.getParameter("shichusho");
		dto.setApplicant_address(id12);
		String id13 = request.getParameter("shosaijusho");
		dto.setApplicant_addressDetail(id13);
		String id14 = request.getParameter("shokubana");
		dto.setApplicant_workName(id14);
		String id15 = request.getParameter("shokobanajusho");
		dto.setApplicant_workAddress(id15);
		String id16 = request.getParameter("yunyushomesho");
		if (id16 == null) {
			id16 = "0";
		}
		dto.setApplicant_incomeCertfication(id16);
		String id17 = request.getParameter("nenshu");
		dto.setApplicant_incomeYear(id17);
 
		int result = service.updateReceipt(dto);
		
		return "redirect:/admin/receipt";
		
		
		
	}
	
	
	
	
	
	
	//리스트
	@RequestMapping(value = "/admin/receipt", method = RequestMethod.GET)
	public String adminReceiptList(Model model) {

		List<URU002Dto> list = service.findAll();
		model.addAttribute("adminReceiptList", list);
		System.out.println(list.get(0).toString());
		return "/admin/URU002L01";
	}

	@RequestMapping(value = "/admin/receipt/create", method = RequestMethod.GET)
	public String create(Locale locale, Model model) {

		
		model.addAttribute("form", "/admin/receipt/create");
		
		
		List<CodeDto> list = service.kokuseki();
		System.out.println(list.size());
		model.addAttribute("kokuseki", list);
		logger.info("Admin main");
		return "/admin/URU002E01";
	}

	@RequestMapping(value = "/admin/receipt/create", method = RequestMethod.POST)

	public String signUp(HttpServletRequest request) throws Exception {
		// public String signUp(Locale locale, Model model) {

//		List<URA002Dto> list = service.findAll();
//		
//		model.addAttribute("list", list);
//		
//		logger.info("Code upload page");
//		
//		return "/admin/URA002L01";

		URU002Dto dto = new URU002Dto();

		dto.setApplicant_buildingInfo("18");

		String id1 = request.getParameter("kanjinamae");
		dto.setApplicant_nameKanji(id1);

		String id4 = request.getParameter("furigananamae");
		dto.setApplicant_nameFurigana(id4);

		String id2 = request.getParameter("senengatsunichi");
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		System.out.println(format.parse(id2));
		dto.setApplicant_birth(format.parse(id2));

		String id18 = request.getParameter("seibutsu");
		dto.setApplicant_gender(id18);

		String id3 = request.getParameter("flexRadioDefault");
		dto.setApplicant_nationality(id3);

		if ("N2".equals(id3)) {

			String id5 = request.getParameter("zairyukado");

			if (id5 == null) {
				id5 = "0";
			}
			dto.setApplicant_regidentsCardFlag(id5);

			String id6 = request.getParameter("gaikokunyukyobi");
			SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
			System.out.println(format1.parse(id6));
			dto.setApplicant_movingIn(format.parse(id6));

			String id7 = request.getParameter("zairyushikaku");
			if (id7 == null) {
				id7 = "0";
			}
			dto.setApplicant_regidentsEligible(id7);

			String id8 = request.getParameter("zairyukikan");
			dto.setApplicant_regidentsDuration(id8);

			String id9 = request.getParameter("zairyumanryobi");
			SimpleDateFormat format3 = new SimpleDateFormat("yyyyMMdd");
			System.out.println(format3.parse(id9));
			dto.setApplicant_regidentsEndDate(format3.parse(id9));
		}

		String id10 = request.getParameter("fonbango");
		dto.setApplicant_telNum(id10);
		String id11 = request.getParameter("yubinbango");
		dto.setApplicant_postalCode(id11);
		String id12 = request.getParameter("shichusho");
		dto.setApplicant_address(id12);
		String id13 = request.getParameter("shosaijusho");
		dto.setApplicant_addressDetail(id13);
		String id14 = request.getParameter("shokubana");
		dto.setApplicant_workName(id14);
		String id15 = request.getParameter("shokobanajusho");
		dto.setApplicant_workAddress(id15);
		String id16 = request.getParameter("yunyushomesho");
		if (id16 == null) {
			id16 = "0";
		}
		dto.setApplicant_incomeCertfication(id16);
		String id17 = request.getParameter("nenshu");
		dto.setApplicant_incomeYear(id17);

		System.out.println(dto.toString());

		String path = service.insertapplicant(dto);
		System.out.println("11111" + path);

		logger.info("Admin main");
		return path;

	}
	
	

}
