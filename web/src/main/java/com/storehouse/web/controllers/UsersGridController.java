package com.storehouse.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.UserService;
import com.storehouse.common.entity.User;

@Controller
public class UsersGridController {
	@Autowired
	UserService userService;

	@RequestMapping(value = { "/users" }, method = RequestMethod.GET)
	public String showUsersGreed(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "usersgreed";
	}
}
