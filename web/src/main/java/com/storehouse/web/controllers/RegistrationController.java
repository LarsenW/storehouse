package com.storehouse.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public String printWelcome(ModelMap model, HttpServletRequest request) {
		return "registration";

	}
}
