package com.storehouse.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		if (error != null) {
			modelAndView.addObject("error", "Incorrect email or password!");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String redirectTo(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin";
		} else
			return "redirect:/profile";
	}
}
