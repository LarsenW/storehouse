package com.storehouse.web.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.AutoLoginService;
import com.storehouse.business.services.TokenService;
import com.storehouse.business.services.UserService;
import com.storehouse.common.entity.Token;
import com.storehouse.common.entity.User;

@Controller
public class TokenRecognizerController {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserService userService;

	@Autowired
	private AutoLoginService autoLoginService;

	@RequestMapping(value = { "/email_confirmation" }, method = RequestMethod.GET)
	public String registerNewUser(HttpServletRequest req) {
		Token token = tokenService.getByLink(req.getParameter("val"));
		Date currentDate= new Date();
		if (token != null && currentDate.before(token.getExpirationDate())) {
			User user = userService.getById(token.getUser().getId());
			autoLoginService.autheticateUser(user);
			user.setActive(true);
			userService.updateUser(user);
			return "redirect:/profile";
		}
		return "redirect:/login";
	}
}
