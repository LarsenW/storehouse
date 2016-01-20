package com.storehouse.web.controllers;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.web.utils.RemoteServerParamsResolver;

@Controller
public class MainPageController {
	@Autowired
	ServletContext servletContext;
	@Autowired
	RemoteServerParamsResolver paramsResolver;

	@RequestMapping(value = { "/main", "/" }, method = RequestMethod.GET)
	public String showMainPage(ModelMap model, HttpServletRequest request) {
		paramsResolver.parse(servletContext.getRealPath("/WEB-INF/ftp-server-params.xml"));
		return "main";
	}
}