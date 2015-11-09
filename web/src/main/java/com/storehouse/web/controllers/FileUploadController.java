package com.storehouse.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.ItemService;
import com.storehouse.common.entity.Item;

@Controller
public class FileUploadController {
	@Autowired
	ItemService itemService;

	@RequestMapping(value = { "/upload" }, method = RequestMethod.GET)
	public String showUploadForm(Model model) {
		model.addAttribute("itemForm", new Item());
		return "upload";
	}

	@RequestMapping(value = { "/upload" }, method = RequestMethod.POST)
	public String handleFileUpload(@ModelAttribute("itemForm") Item item, BindingResult result, Model model) {
		itemService.persistItem(item);
		return "main";
	}
}
