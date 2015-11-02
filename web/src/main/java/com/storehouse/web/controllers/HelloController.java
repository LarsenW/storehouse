package com.storehouse.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.UserService;
import com.storehouse.common.entity.User;

@Controller
public class HelloController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", userService.getById(1L).getName());
		return "hello";

	}
}