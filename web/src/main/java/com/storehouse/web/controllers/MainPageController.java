package com.storehouse.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.storehouse.business.services.UserService;

@Controller
public class MainPageController {
	@Autowired
	UserService userService;

	@RequestMapping(value ={ "/main","/"}, method = RequestMethod.GET)
	public String printWelcome(ModelMap model, HttpServletRequest request) {
		model.addAttribute("message", userService.getById(1L).getName());
		return "main";

	}
}