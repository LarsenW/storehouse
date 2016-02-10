package com.storehouse.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.UserService;
import com.storehouse.common.entity.User;

@Controller
public class AdminProfileController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = { "user/{id}" }, method = RequestMethod.GET)
	public String showUserInfo(@PathVariable Long id, Model model) {
		User user = userService.getById(id);
		model.addAttribute("userName", user.getName());
		return "userinfo";
	}
	@RequestMapping(value = { "admin" }, method = RequestMethod.GET)
	public String showAdminProfile() {
		return "adminpage";
	}
}
