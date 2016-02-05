package com.storehouse.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.UserService;
import com.storehouse.common.dto.ItemDto;
import com.storehouse.common.entity.User;

@Controller
public class UserProfileController {
	@Autowired
	UserService userService;

	@RequestMapping(value = { "user/{id}" }, method = RequestMethod.GET)
	public String showUserInfo(@PathVariable Long id, Model model) {
		User user = userService.getById(id);
		model.addAttribute("userName", user.getName());
		return "userinfo";
	}

	@RequestMapping(value = { "profile" }, method = RequestMethod.GET)
	public String showCurrentUserProfile(ModelMap model, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		model.addAttribute("name", user.getName());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("itemForm", new ItemDto());
		return "profile";
	}

	@RequestMapping(value = { "admin" }, method = RequestMethod.GET)
	public String showAdminProfile() {
		return "adminpage";
	}
}
