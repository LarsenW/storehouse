package com.storehouse.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.TokenCreatingService;
import com.storehouse.business.utils.MailSendingTool;

@Controller
public class MainPageController {

	@Autowired
	MailSendingTool mst;

	@Autowired
	TokenCreatingService ts;

	@RequestMapping(value = { "/main", "/" }, method = RequestMethod.GET)
	public String showMainPage(ModelMap model, HttpServletRequest request) {
		return "main";
	}
}