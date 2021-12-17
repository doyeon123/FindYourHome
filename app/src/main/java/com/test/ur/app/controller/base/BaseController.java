package com.test.ur.app.controller.base;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.test.ur.app.Util.CsvUtils;
import com.test.ur.app.Util.UploadFileUtils;
import com.test.ur.app.constants.URConstants;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.enums.CodeEnum;
import com.test.ur.app.services.CodeService;

import au.com.bytecode.opencsv.CSVReader;

@Controller
public class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	public
	CodeService codeService;
	
	protected List<String> lstSaveFile = new ArrayList<String>();
	protected List<CodeDto> lstCode = new ArrayList<CodeDto>();
	
	protected List<String> messageList = new ArrayList<String>();
		
	public List<CodeDto> lstEntireRegional = null;
	public List<CodeDto> lstAreaRegional = null;
	public List<CodeDto> lstStateRegional = null;
	public List<CodeDto> lstProgress = null;
	public List<CodeDto> lstRoom = null;
	public List<CodeDto> lstInternet = null;
	public List<CodeDto> lstBusiness = null;
	public List<CodeDto> lstCategory = null;
	public List<CodeDto> lstNationality = null;
	public List<CodeDto> lstEquipment = null;

	
	public void setCodeList() {
		
		if (lstEntireRegional == null || lstEntireRegional.isEmpty()) {
			lstEntireRegional = codeService.findByCode(CodeEnum.ENTIRE_REGIONAL);		
		}

		if (lstAreaRegional == null || lstAreaRegional.isEmpty()) {
			lstAreaRegional = codeService.findByCode(CodeEnum.AREA_REGIONAL);
		}

		if (lstStateRegional == null || lstStateRegional.isEmpty()) {
			lstStateRegional = codeService.findByCode(CodeEnum.STATE_REGIONAL);
		}
		
		if (lstProgress == null || lstProgress.isEmpty()) {
			lstProgress = codeService.findByCode(CodeEnum.PROGRESS);
		}
		
		if (lstRoom == null || lstRoom.isEmpty()) {
			lstRoom = codeService.findByCode(CodeEnum.ROOM);
		}

		if (lstInternet == null || lstInternet.isEmpty()) {
			lstInternet = codeService.findByCode(CodeEnum.INTERNET);
		}

		if (lstBusiness == null || lstBusiness.isEmpty()) {
			lstBusiness = codeService.findByCode(CodeEnum.BUSINESS);
		}

		if (lstCategory == null || lstCategory.isEmpty()) {
			lstCategory = codeService.findByCode(CodeEnum.CATEGORY);
		}

		if (lstNationality == null || lstNationality.isEmpty()) {
			lstNationality = codeService.findByCode(CodeEnum.NATIONALITY);
		}

		if (lstEquipment == null || lstEquipment.isEmpty()) {
			lstEquipment = codeService.findByCode(CodeEnum.EQUIPMENT);
		}
	}
	
	public void imageUpload(HttpServletRequest request) throws Exception {
		
		logger.info("UploadFile start");
	
		try {
			
			MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
			
			Iterator iter = multipart.getFileNames();

			while (iter.hasNext()) {
				MultipartFile mfile = multipart.getFile(iter.next().toString());
				System.out.println(mfile.getOriginalFilename());
				// image check(csv, png, jpg, jpng) 
				if (chkImageFile(mfile)) {

					if (!lstSaveFile.isEmpty()) {
						lstSaveFile.clear();
					}

					lstSaveFile.add(UploadFileUtils.uploadFile(mfile));					
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getLocalizedMessage());
		}
		
		logger.info("UploadFile end");
	}
	
	/**
	 * 
	 * 
	 * @param MultipartFile mfile
	 * @return
	 */
	public boolean chkCSVFile(MultipartFile mfile) {
		String originFileName = mfile.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf(".") + 1).toUpperCase();
		return URConstants.CSV_FILE_EXTENSION.equals(ext);
	}
	
	/**
	 * 
	 * 
	 * @param MultipartFile mfile 
	 * @return
	 */
	public boolean chkImageFile(MultipartFile mfile) {
		String originFileName = mfile.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf(".") + 1).toUpperCase();
		return Arrays.asList(URConstants.IMAGE_FILE_EXTENSION).contains(ext);
	}
	
	/**
	 *
	 * @param model
	 * @return
	 */
	public String loadAreaSelectPage(Model model) {
		List<CodeDto> areaList = codeService.findByCode(CodeEnum.ENTIRE_REGIONAL);
		List<List<CodeDto>> regionalList = new ArrayList<List<CodeDto>>();
		for(CodeDto area : areaList) {
			regionalList.add(codeService.getRegionalListByArea(area.getCode()));
		}
		model.addAttribute("areaList", areaList);
		model.addAttribute("regionalList", regionalList);
		return "URA001S01";
	}
	

	/**
	 * 
	 * @param page
	 * @param total
	 * @return Map
	 * attributes(pageBegin, pageEnd, maxPage)
	   @see
		12
		123
		1234
		12345

		12345...6
		1...23456

		12345...7

		1...23456...7

		1...34567
		
		1...page-2,page-1,page,page+1,page+2...maxPage
		pagenation example
	 */
	public static Map<String,Object> addPagingInformation(int page,int total) {	
		int pageEnd;
		int pageBegin;
		int maxPage = total/10 + (total % 10 > 0 ? 1 : 0);
		logger.debug("page : " + maxPage);
		logger.debug("total : " + maxPage);
		logger.debug("maxPage : " + maxPage);
		//total = 0 -> maxPage = 0
		//total = 1~10 -> maxPage = 1
		//total = 11~20 -> maxPage = 2
		//...
		maxPage = maxPage == 0 ? 1 : maxPage;
		//total = 0 -> maxPage = 1
		
		if(maxPage <= 5) {
			pageBegin = 1;
			pageEnd= maxPage;
		}
		else {
			pageBegin = page -2;
			pageEnd = page + 2;
			if(page - 2 < 1) {
				pageBegin += 3- page;
				pageEnd += 3- page;
			} else if(page + 2 > maxPage) {
				pageBegin -= page + 2 - maxPage;
				pageEnd -= page + 2 - maxPage;
			}		
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("pageBegin", pageBegin);
		ret.put("pageEnd", pageEnd);
		ret.put("maxPage", maxPage);
		logger.debug("pageBegin : " + pageBegin);
		logger.debug("pageEnd : " + pageEnd);
		
		return ret;
	}
	
	
	/**
	 * CSV�뙆�씪 �뜲�씠�꽣 �벑濡�
	 * 
	 * @param path
	 * @throws Exception
	 */
	
	
	
}
