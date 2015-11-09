package com.storehouse.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.storehouse.business.services.UserService;
import com.storehouse.common.entity.User;

@Controller
public class UserProfileController {
	@Autowired
	UserService userService;

	@RequestMapping("profile/{id}")
	public String showUserProfile(@PathVariable Long id, Model model) {
		User user = userService.getById(id);
		model.addAttribute("userName", user.getName());
		return "profile";
	}
}
