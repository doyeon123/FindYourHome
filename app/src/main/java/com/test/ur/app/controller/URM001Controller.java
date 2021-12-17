package com.test.ur.app.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.ur.app.controller.base.BaseController;
import com.test.ur.app.dto.CodeDto;
import com.test.ur.app.enums.CodeEnum;
import com.test.ur.app.services.CodeService;


//MainMenuController
@Controller
public class URM001Controller extends BaseController {

	
	private static final Logger logger = LoggerFactory.getLogger(URM001Controller.class);
	
	/**
	 * @param model object
	 * @return mainPage
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("home");
		return "/";
	}
	
	
}
