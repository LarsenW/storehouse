package com.strorehouse.business.services.impl;

import java.util.List;

import com.storehouse.common.entity.User;
import com.strorehouse.business.services.UserService;

public class Main {
	public static void main(String[] args) {
		// User user = new User();
		// user.setName("Ann");
		// user.setEmail("ann@gmail.com");
		// user.setPassword("1annnn1");
		UserService service = new UserServiceImpl();
		// List<User> users = service.findAll();
		// for (User u : users) {
		// System.out.println(u);
		// }
		// service.persistUser(user);
		// user.setPassword("0000");
		// service.updateUser(user);

		User user;
		user = service.getById(9l);
		System.out.println(user);
	}
}
