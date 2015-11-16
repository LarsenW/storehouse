package com.storehouse.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

	@RequestMapping(value = { "/main", "/" }, method = RequestMethod.GET)
	public String showMainPage(ModelMap model, HttpServletRequest request) {
		return "main";
	}
}