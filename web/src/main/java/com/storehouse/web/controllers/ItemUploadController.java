package com.storehouse.web.controllers;

import java.util.Calendar;

import javax.jcr.Credentials;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;
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

		if (!file.isEmpty()) {
			try {
				Repository repository = JcrUtils.getRepository("http://localhost:2627/rmi");
				Credentials credentials = new SimpleCredentials("admin", "admin".toCharArray());
				Session session = repository.login(credentials);
				Node node1 = (Node) session.getItem("/dept");
				Node node2 = node1.addNode("folder", "nt:file");
				Node content = node2.addNode("jcr:content", "nt:resource");
				// content.setProperty("jcr:mimeType", "rtf");
				content.setProperty("jcr:lastModified", Calendar.getInstance());
				content.setProperty("jcr:data", session.getValueFactory().createBinary(file.getInputStream()));
				// content.getSession().getValueFactory().createBinary(fis);
				session.save();
				System.out.println(file.getBytes().length);
				itemCreatingService.createItem(itemDto);
				return "profile";
			} catch (Exception e) {
				return "upload";
			}
		} else {
			return "upload";
		}
	}

}
