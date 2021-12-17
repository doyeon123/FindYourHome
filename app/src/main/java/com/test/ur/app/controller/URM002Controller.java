package com.test.ur.app.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.ur.app.controller.base.BaseController;

@Controller
public class URM002Controller extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(URM002Controller.class);

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Admin home");
		return "/admin/URM002L01";
	}
}
