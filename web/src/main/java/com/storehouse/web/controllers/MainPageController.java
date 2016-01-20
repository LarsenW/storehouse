package com.storehouse.web.controllers;

import javax.ejb.Remove;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.web.utils.RemoteServerConnector;
import com.storehouse.web.utils.RemoteServerParamsResolver;

@Controller
public class MainPageController {
	@Autowired
	RemoteServerConnector connector;

	@RequestMapping(value = { "/main", "/" }, method = RequestMethod.GET)
	public String showMainPage(ModelMap model, HttpServletRequest request) {
		connector.establishConnection();
		return "main";
	}
}