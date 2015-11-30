package com.storehouse.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.storehouse.common.entity.User;

@Controller
public class FilesGridController {
	@RequestMapping(value = { "/getprivatefiles" }, method = RequestMethod.GET)

	public @ResponseBody User getUserPrivateFiles() {
//		Set<String> records = new HashSet<String>();
//		records.add("Record #1");
//		records.add("Record #2");
		// String records = "record #1";
		 User user = new User();
		 user.setName("ss");
		 user.setEmail("sdasd");
		 return user;
		//return records;
	}
}
