package com.storehouse.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.UserService;
import com.storehouse.common.entity.User;

@Controller
public class MainPageController {
	@Autowired
	UserService userService;

	@RequestMapping(value = { "/main", "/" }, method = RequestMethod.GET)
	public String showMainPage(ModelMap model, HttpServletRequest request) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication.getPrincipal() instanceof User) {
//			User user = (User) authentication.getPrincipal();
//			System.out.println(user.getId());
//		}else{
//			System.out.println(authentication.getPrincipal());
//		}

		return "main";
	}
}