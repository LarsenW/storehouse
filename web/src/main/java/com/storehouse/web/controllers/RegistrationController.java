package com.storehouse.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.storehouse.business.services.UserService;
import com.storehouse.common.entity.User;

@Controller
public class RegistrationController {
	@Autowired
	UserService userService;

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public String showUserAddForm(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String handleUserForm(@ModelAttribute("userForm") User user, BindingResult result, Model model) {
		userService.persistUser(user);
		return "login";
	}
}
