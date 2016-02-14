package com.storehouse.web.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.business.services.AccountUpdatingService;
import com.storehouse.common.entity.User;

@Controller
@RequestMapping(value = "/account")
public class AccountSettingsController {

	private final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Autowired
	private AccountUpdatingService accountUpdatingService;

	@RequestMapping(value = { "/email" }, method = RequestMethod.GET)
	public @ResponseBody boolean showMainPage(HttpServletRequest req) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String newEmail = req.getParameter("email");
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(newEmail);
		if (matcher.matches() && accountUpdatingService.updateEmail(user, newEmail)) {
			return true;
		} else {
			return false;
		}
	}
}