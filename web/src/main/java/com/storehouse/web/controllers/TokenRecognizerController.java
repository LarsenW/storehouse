package com.storehouse.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.TokenService;
import com.storehouse.common.entity.Token;

@Controller
public class TokenRecognizerController {

	@Autowired
	private TokenService tokenService;

	@RequestMapping(value = { "/email_confirmation" }, method = RequestMethod.GET)
	public String registerNewUser(HttpServletRequest req) {
		Token token;
		if ((token = tokenService.getByLink(req.getParameter("val"))) != null) {
			System.out.println("id = " + token.getId());
		}
		return "redirect:/main";
	}
}
