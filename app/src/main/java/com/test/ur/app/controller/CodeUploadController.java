package com.test.ur.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.test.ur.app.Util.CsvUtils;
import com.test.ur.app.constants.URConstants;
import com.test.ur.app.controller.base.BaseController;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.dto.GoodsDto;
import com.test.ur.app.services.CodeService;
import com.test.ur.app.services.GoodsService;

@Controller
public class CodeUploadController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(CodeUploadController.class);
	
	private static final String REDIRECT_PATH = "redirect:/admin/codeUpload";
	
	private List<String[]> csvDatas = new ArrayList<String[]>();
	
	HashMap<String, String> tableMap = new HashMap<String, String>();
	
	@Autowired
	CodeService service;

	@RequestMapping(value = "/admin/codeUpload", method = RequestMethod.GET)
	public String loadCodePage(Locale locale, Model model) {
		
		logger.info("Code upload page start");
		
		setCodeList();
		
		if (!messageList.isEmpty()) {
			model.addAttribute("messages", messageList);
		}
		
		if (tableMap.isEmpty()) {
			setUpdateTableMap();
		}

		// Set code master list
		model.addAttribute("listEntireRegional", lstEntireRegional);
		model.addAttribute("listAreaRegional", lstAreaRegional);
		model.addAttribute("listProgress", lstProgress);
		model.addAttribute("listRoom", lstRoom);
		model.addAttribute("listInternet", lstInternet);
		model.addAttribute("listBusiness", lstBusiness);
		model.addAttribute("listCategory", lstCategory);
		model.addAttribute("listNationality", lstNationality);
		model.addAttribute("listEquipment", lstEquipment);
		
		logger.info("Code upload page end");

		return "/admin/codeUpload";
	}
	
	@RequestMapping(value = "/admin/codeUpload", method = RequestMethod.POST)
	public String insertCodes(HttpServletRequest req, @RequestParam Map<String, Object> map) throws Exception {
		
		logger.info("InsertCodes start");
		
		String updateCd = map.get(URConstants.UPDATE_KEY).toString();

		if (!messageList.isEmpty()) {
			messageList.clear();
		}
				
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) req;
		
		Iterator iter = multipart.getFileNames();
		
		try {
			while (iter.hasNext()) {
				MultipartFile mfile = multipart.getFile(iter.next().toString());
				if (chkCSVFile(mfile)) {
					
					if (mfile.getOriginalFilename().indexOf(tableMap.get(updateCd).toString()) == -1) {
						messageList.add("파일명이 일치하지않습니다.");
						return REDIRECT_PATH;
					}
					
					String path = req.getSession().getServletContext().getRealPath("/resources/temporary");
					csvDatas = CsvUtils.convertCsvData(path, mfile);
				} else {
					messageList.add("CSV파일을 선택해주세요.");
					return REDIRECT_PATH;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("파일취득 실패 : " + e.getLocalizedMessage());
			return REDIRECT_PATH;
		}
		
		if (csvDatas.isEmpty()) {
			messageList.add("Not csvDatas Datas");
			return "redirect:/admin/codeUpload";
		}
		
		List<CodeDto> list = new ArrayList<CodeDto>();

		for (String[] arrStr : csvDatas) {
			switch (arrStr.length) {
				case 6:
					list.add(new CodeDto(arrStr[0], arrStr[1], arrStr[2], arrStr[3], arrStr[4], arrStr[5]));
					break;
				case 3:
					list.add(new CodeDto(arrStr[0], arrStr[1], arrStr[2]));
					break;
				case 2:
					list.add(new CodeDto(arrStr[0], arrStr[1]));
					break;
				default:
					break;
			}
		}
		
		// Save code master
		try {
			service.insertCode(list, updateCd);
		} catch (Exception e) {
			// TODO: handle exception
			messageList.add("Fail insert " + e.getLocalizedMessage());
		}
		
		logger.info("InsertCodes end");
		
		return REDIRECT_PATH;
	}
	
	private void setUpdateTableMap() {
		tableMap.put("1", "entireRegionalCode");
		tableMap.put("2", "areaRegionalCode");
		tableMap.put("3", "stateRegionalCode");
		tableMap.put("4", "progressCode");
		tableMap.put("5", "roomCode");
		tableMap.put("6", "internetCode");
		tableMap.put("7", "businessCode");
		tableMap.put("8", "categoryCode");
		tableMap.put("9", "nationalityCode");
		tableMap.put("10", "equipmentCode");
	}
	
}
