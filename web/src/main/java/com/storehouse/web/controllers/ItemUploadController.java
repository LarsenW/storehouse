package com.storehouse.web.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.storehouse.business.services.ItemCreatingService;
import com.storehouse.common.dto.ItemDto;
import com.storehouse.common.entity.User;

@Controller
public class ItemUploadController {
	@Autowired
	ItemCreatingService itemCreatingService;

	@RequestMapping(value = { "/upload" }, method = RequestMethod.GET)
	public String showUploadForm(Model model) {
		model.addAttribute("itemForm", new ItemDto());
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFileUpload(@ModelAttribute("itemForm") ItemDto itemDto,
			@RequestParam("file") MultipartFile file) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		itemDto.setUser(user);
		return "profile";
	}

}
