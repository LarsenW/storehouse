package com.storehouse.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.AutoLoginService;
import com.storehouse.business.services.UserCreatingService;
import com.storehouse.common.dto.UserDto;

@Controller
public class RegistrationController {

	@Autowired
	private UserCreatingService userCreatingService;

	@Autowired
	private AutoLoginService autoLoginService;

	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public String showUserAddForm(Model model) {
		model.addAttribute("userForm", new UserDto());
		return "registration";
	}

	@RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
	public String handleUserForm(@Valid @ModelAttribute("userForm") UserDto userDto, BindingResult result,
			ModelMap model) {
		boolean usernameExist = userCreatingService.checkIfUsernameExist(userDto.getUsername());
		boolean emailExist = userCreatingService.checkIfEmailExist(userDto.getEmail());
		if (result.hasErrors()) {
			return "registration";
		} else if (emailExist || usernameExist) {
			if (usernameExist) {
				model.addAttribute("usernameNonUnique", "Username is not unique");
			}
			if (emailExist) {
				model.addAttribute("emailNonUnique", "Email is not unique");
			}
			return "registration";
		} else if (userCreatingService.createUser(userDto)) {
			autoLoginService.autheticateUser(userDto);
			return "redirect:/profile";
		} else {
			return "registration";
		}

	}
}
