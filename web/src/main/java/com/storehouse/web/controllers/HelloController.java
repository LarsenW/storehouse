package com.storehouse.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.storehouse.business.services.UserService;

@Controller
public class HelloController {
	@Autowired
	UserService userService;
	@Autowired
	ApplicationContext wac;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, HttpServletRequest request) {
		model.addAttribute("message", userService.getById(1L).getName());
		return "hello";

	}
}