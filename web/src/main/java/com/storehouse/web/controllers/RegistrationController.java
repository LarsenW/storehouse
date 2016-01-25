package com.storehouse.web.controllers;

import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.UserCreatingService;
import com.storehouse.common.dto.UserDto;
import com.storehouse.common.entity.User;

@Controller
public class RegistrationController {
	@Autowired
	UserCreatingService userCreatingService;

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public String showUserAddForm(Model model) {
		model.addAttribute("userForm", new UserDto());
		return "registration";
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String handleUserForm(@Valid @ModelAttribute("userForm") UserDto userDto, BindingResult result) {
		if (result.hasErrors()) {
			return "registration";
		} else if (userCreatingService.createUser(userDto)) {
			return "login";
		} else {
			return "registration";
		}

	}
}
