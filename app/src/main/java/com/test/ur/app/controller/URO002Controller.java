package com.test.ur.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.crypto.SealedObject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
import com.test.ur.app.dto.URO002Dto;
import com.test.ur.app.enums.CodeEnum;
import com.test.ur.app.services.CodeService;
import com.test.ur.app.services.URB002Service;
import com.test.ur.app.services.URO002Service;

@Controller
public class URO002Controller extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(URO002Controller.class);

	@Autowired
	private URO002Service service;

	@Autowired
	private CodeService codeService;

	@Autowired
	private URB002Service service2;
	
	

	// ������ ����Ʈ ��ü �������� 
		@RequestMapping(value = "/admin/office", method = RequestMethod.GET)
		public String list(Model model, HttpServletRequest request, PagingDto paging, String search_codeA, String search_codeB, String search_codeC) {
			
			Map<String, ?> map = RequestContextUtils.getInputFlashMap(request);
			
			int startnum = paging.getPageNo()*paging.getAmount()-10;
			int endnum = paging.getPageNo()*paging.getAmount();
			
		
			
			if(map!=null) {
				List<URO002Dto> list = (List<URO002Dto>)map.get("searchList");
				
				String search_name = (String)map.get("search_name");
				
				System.out.println("�˻����̸�?????" + search_name );
				
				model.addAttribute("list", list);
				
				model.addAttribute("search_name" + search_name);
				
			} else {
				System.out.println("#######");
				List<URO002Dto> list = service.officeList(startnum, endnum);
				model.addAttribute("list", list);
			}
			
			model.addAttribute("pageNavi", new PageNavi(paging, service.getTotal()));

			List<CodeDto> codeAList = service2.codeAList();
			model.addAttribute("codeAList",codeAList);
			return "/admin/URO002L01";
		}
		
		
		
		
		// ����Ʈ�κ� 2��° ����Ʈ�ڽ��� ���� ���� ����
		@ResponseBody
		@RequestMapping(value = "/admin/office/{codeA}", method = RequestMethod.GET)
		public Map<String, Object> list(@PathVariable("codeA")String codeA) {
			System.out.println("codeA @@@@@@@@@@@@@ : " + codeA);
			Map<String, Object> map = new HashMap<String, Object>();
			List<CodeDto> list = service2.codeBList(codeA);
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

		// ����Ʈ�κ� 3��° ����Ʈ�ڽ��� ���� ���� ����
		@ResponseBody
		@RequestMapping(value = "/admin/office/{codeA}/{codeB}", method = RequestMethod.GET)
		public Map<String, Object> list(@PathVariable("codeA")String codeA, @PathVariable("codeB")String codeB) {
			System.out.println("codeA @@@@@@@@@@@@@ : " + codeA);
			System.out.println("codeB @@@@@@@@@@@@@ : " + codeB);
			Map<String, Object> map = new HashMap<String, Object>();
			List<CodeDto> list = service2.codeCList(codeA, codeB);
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
		
	
	
	
	

	/**
	 * ������ ��Ʈ�ѷ�(������ ����Ʈ) //������ ����Ʈ �������� /** ID������ ���ĵ� ��ü ������ ��� �б�
	 * 
	 * @param model �� ��ü
	 * @return ��� ������ ������ ��� ����Ʈ
	 */
//	@RequestMapping(value = "/admin/office", method = RequestMethod.GET)
//	public String salesList(Model model) {
//
//		logger.info("salesoffice");
//
//		ArrayList<URO002Dto> salesList = new ArrayList<URO002Dto>();
//
//		// ������ ����Ʈ
//		salesList = service.getSalesList();
//
//		// model�� ������ ����Ʈ �ֱ�
//		model.addAttribute("salesList", salesList);
//
//		// URO002L01.jsp (/admin/office?page=) �� �̵�
//		return "/admin/URO002L01";
//	}

	// ������ ���� ����ϴ� �������� �̵�
	@RequestMapping(value = "/admin/office/officeWriteForm", method = RequestMethod.GET)
	public String writeForm(Model model) {

		List<CodeDto> codeAList = service2.codeAList();
		List<CodeDto> codeEList = service2.codeEList();
		List<CodeDto> codeIList = codeService.findByCode(CodeEnum.INTERNET);
		model.addAttribute("codeAList", codeAList);
		model.addAttribute("codeEList", codeEList);
		model.addAttribute("codeIList", codeIList);
		
		model.addAttribute("form", "/admin/office/create");

		// ������ �ۼ��� �̵��ϱ�
		return "/admin/URO002E02";
	}
	
	
	
	// ������ form db ����
	@RequestMapping(value = "/admin/office/create", method = RequestMethod.POST)
	public String writeOffice(MultipartHttpServletRequest mtpRequest, HttpServletRequest request, MultipartFile[] file) throws Exception {

		URO002Dto salesOffice = new URO002Dto();
		
		//String sales_businessCode = request.getParameter("sales_businessCode");
		salesOffice.setSales_businessCode(request.getParameter("sales_businessCode"));
		salesOffice.setSales_officeName(request.getParameter("sales_officeName"));
		salesOffice.setSales_telNum(request.getParameter("sales_telNum"));
		//postal
		salesOffice.setSales_address(request.getParameter("sales_address"));
		//�����ð�
		salesOffice.setSales_holiday(request.getParameter("sales_holiday"));
		salesOffice.setSales_transportation(request.getParameter("sales_transportation"));
		
		
		salesOffice.setSales_officeHours(request.getParameter("sales_officeHours"));
		salesOffice.setSales_postalCode(request.getParameter("sales_postalCode"));
		
		
		//�����ڵ�
		String sales_areaCode = request.getParameter("zone_stateRegionalCode");

		salesOffice.setSales_areaCode(sales_areaCode);

	
		List<MultipartFile> fileList = mtpRequest.getFiles("sales_img");
		
		List<String> sImges = new ArrayList<String>();

		//String strImage = new String();
		
		for (int i=0; i<fileList.size(); i++) {
			System.out.println("filelist ����");
			System.out.println(fileList.get(i));
			System.out.println(fileList.get(i).getOriginalFilename());
			
			////////////////////////////////
			sImges.add(UploadFileUtils.uploadFile(fileList.get(i)));

		}
		
		String strImage = "";
		
		for (String str : sImges) {
			strImage += str + ",";
		}
		
		
		salesOffice.setSales_img(strImage);	
		
		System.out.println("������''''");
		System.out.println(salesOffice);
		
		System.out.println(salesOffice.getSales_img());
		
		String path = service.insertOffice(salesOffice);
		
		return path;
	}

	// ������ �󼼺��� �������� �̵�
	/**
	 * �󼼺����̵�
	 * 
	 * @param id ������id
	 */
	@RequestMapping(value = "/admin/office/detail", method = RequestMethod.GET)
	public String officeDetails(int no, Model model, PagingDto paging) {

		System.out.println(no);
		
	

		// Ư�� ������ ��������
		URO002Dto salesOffice = service.readOfficeDetails(no);

		// ������ ������ ID�� �𵨿� �ֱ�
		model.addAttribute("salesOffice", salesOffice);
		model.addAttribute("sales_registerNo", no);
		
	

		return "/admin/URO002D01";
	}

	/////////////////////////////////////////////
	

	
	/////////////////////////////////////////////////////////////////////
	
	// ������ �����ϱ� form �������� �̵�
//	@RequestMapping(value = "/admin/goUpdateForm", method = RequestMethod.GET)
//	public String updateForm(Model model) {
//
//		List<CodeDto> codeAList = service2.codeAList();
//		List<CodeDto> codeEList = service2.codeEList();
//		
//		model.addAttribute("codeAList", codeAList);
//		model.addAttribute("codeEList", codeEList);
//
//		// ������ ������ �̵��ϱ�
//		return "/admin/URO002U03";
//	}

	//������ �����ϱ�
	 // �����ϱ� ��Ʈ�ѷ�
		@RequestMapping(value="/admin/office/update" , method=RequestMethod.GET)
		public String update(Model model, int sales_registerNo) {
			System.out.println("update @@@@@@@@ : " + sales_registerNo);
	
			
			URO002Dto list = service.readOfficeDetails(sales_registerNo);
			
			model.addAttribute("update", list);
			
			model.addAttribute("update.sales_registerNo",sales_registerNo);
			
			
			
			System.out.println("@@@@@@"+list.getSales_registerNo());
			
			List<CodeDto> codeIList = codeService.findByCode(CodeEnum.INTERNET);
	 		List<CodeDto> codeAList = service2.codeAList();
			List<CodeDto> codeBListAll = service2.codeBListAll();
			List<CodeDto> codeCListAll = service2.codeCListAll();
			List<CodeDto> codeEList = service2.codeEList();
			model.addAttribute("codeAList", codeAList);
			model.addAttribute("codeBListAll", codeBListAll);
			model.addAttribute("codeCListAll", codeCListAll);
			model.addAttribute("codeEList", codeEList);
			model.addAttribute("codeIList", codeIList);
			model.addAttribute("form", "/admin/office/update");
			
			return "/admin/URO002E02";
		}
	
	
	
	
	// ������ form db �����ϱ�
	@RequestMapping(value = "/admin/office/update", method = RequestMethod.POST)
	public String updateOffice(MultipartHttpServletRequest mtpRequest, HttpServletRequest request, @RequestParam MultipartFile[] file) throws Exception {
		
		URO002Dto salesOffice = new URO002Dto();
		
		//salesOffice.setSales_registerNo((request.getParameter("sales_registerNo")));
		
		
		String no = request.getParameter("sales_registerNo");
		
		int number = Integer.parseInt(no);
		
		System.out.println("���"+number);
		
		salesOffice.setSales_registerNo(number);
		
		
		salesOffice.setSales_businessCode(request.getParameter("sales_businessCode"));
		salesOffice.setSales_officeName(request.getParameter("sales_officeName"));
		salesOffice.setSales_telNum(request.getParameter("sales_telNum"));
		//postal
		salesOffice.setSales_address(request.getParameter("sales_address"));
		//�����ð�
		salesOffice.setSales_holiday(request.getParameter("sales_holiday"));
		salesOffice.setSales_transportation(request.getParameter("sales_transportation"));
		
		salesOffice.setSales_officeHours(request.getParameter("sales_officeHours"));
		salesOffice.setSales_postalCode(request.getParameter("sales_postalCode"));
		
		//�����ڵ�
		String sales_areaCode = request.getParameter("zone_stateRegionalCode");

		salesOffice.setSales_areaCode(sales_areaCode);

//	
//		String sales_officeHours1 =request.getParameter("sales_officeHours1");
//		String sales_officeHours2 =request.getParameter("sales_officeHours2");
//		String sales_postalCode1 =request.getParameter("sales_postalCode1");
//		String sales_postalCode2 =request.getParameter("sales_postalCode2");


		

		
		List<MultipartFile> fileList = mtpRequest.getFiles("sales_img");

		//String strImage = new String();
		
		if(!fileList.isEmpty()) {
			
			List<String> sImges = new ArrayList<String>();
			
			for (int i=0; i<fileList.size(); i++) {
				System.out.println("filelist ����");
				System.out.println(fileList.get(i));
				System.out.println(fileList.get(i).getOriginalFilename());
				
				////////////////////////////////
				sImges.add(UploadFileUtils.uploadFile(fileList.get(i)));

			}
			
			String strImage = "";
			
			for (String str : sImges) {
				strImage += str + ",";
			}
			
			
			salesOffice.setSales_img(strImage);	
		} else {
			
			salesOffice.setSales_img(null);
			
		}
		
		
		System.out.println("������''''");
		System.out.println(salesOffice);
		
		System.out.println(salesOffice.getSales_img());
		
		String path = service.updateOffice(salesOffice);
		
		return path;
				
		//"redirect:/admin/office";
	}

	
	
	// �󼼺κ� 2��° ����Ʈ�ڽ��� ���� ���� ����
		@ResponseBody
		@RequestMapping(value = "/admin/office/create/{codeA}", method = RequestMethod.GET)
		public Map<String, Object> write(@PathVariable("codeA")String codeA) {
			System.out.println("codeA @@@@@@@@@@@@@ : " + codeA);
			Map<String, Object> map = new HashMap<String, Object>();
			List<CodeDto> list = service2.codeBList(codeA);
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

		// ��Ϻκ� 3��° ����Ʈ�ڽ��� ���� ���� ����
		@ResponseBody
		@RequestMapping(value = "/admin/office/create/{codeA}/{codeB}", method = RequestMethod.GET)
		public Map<String, Object> write(@PathVariable("codeA")String codeA, @PathVariable("codeB")String codeB) {
			System.out.println("codeA @@@@@@@@@@@@@ : " + codeA);
			System.out.println("codeB @@@@@@@@@@@@@ : " + codeB);
			Map<String, Object> map = new HashMap<String, Object>();
			List<CodeDto> list = service2.codeCList(codeA, codeB);
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
		
		
		// �˻���ư ������ �ڵ�A�� �޾Ƽ� �˻��� ����Ʈ�� �ǹ�����Ʈ ��Ʈ�ѷ��� �ѱ�
		@RequestMapping(value = "/admin/office/search", method = RequestMethod.POST)
		public String Search(HttpServletRequest req, RedirectAttributes rttr, Model model, PagingDto paging) {
			
			int startnum = paging.getPageNo() * paging.getAmount() - 10;
			int endnum = paging.getPageNo() * paging.getAmount();

			String zone_entireRegionalCode = (String) req.getParameter("zone_entireRegionalCode");
			String zone_areaRegionalCode = (String) req.getParameter("zone_areaRegionalCode");
			String zone_stateRegionalCode = (String) req.getParameter("zone_stateRegionalCode");
			String search_name = (String) req.getParameter("search_name");

			
			
			System.out.println("codeA @@@@@@@@@@@@@ : " + zone_entireRegionalCode);
			System.out.println("�˻� �̸� @@@@@@@ : " + search_name);

			List<URO002Dto> list = service.search(startnum, endnum, zone_entireRegionalCode, zone_areaRegionalCode,
					zone_stateRegionalCode, search_name);

			rttr.addFlashAttribute("searchList", list);

			rttr.addFlashAttribute("search_name", search_name);

			return "redirect:/admin/office";
		
		}
}
