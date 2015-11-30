package com.storehouse.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.business.services.ItemsGridService;
import com.storehouse.common.dto.ItemDto;
import com.storehouse.common.entity.User;

@Controller
public class ItemsGridController {
	@Autowired
	ItemsGridService itemsGridService;

	@RequestMapping(value = { "/getprivatefiles" }, method = RequestMethod.GET)
	public @ResponseBody List<ItemDto> getUserPrivateFiles() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		List<ItemDto> items = itemsGridService.findAllPrivateByUserId(user.getId());
		return items;
	}
}
