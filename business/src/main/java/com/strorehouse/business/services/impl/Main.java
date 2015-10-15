package com.strorehouse.business.services.impl;

import java.util.List;

import com.storehouse.common.entity.Item;
import com.storehouse.common.entity.User;
import com.strorehouse.business.services.ItemService;

public class Main {
	public static void main(String[] args) {
//		User user = new User();
//		user.setName("Mex");
//		user.setEmail("tex@gmail.com");
//		user.setPassword("ttttx");
		//
		// Item item1 = new Item();
		// item1.setName("item1");
		//
		// Item item2 = new Item();
		// item2.setName("item2");
		//
		ItemService serviceI = new ItemServiceImpl();
		List<Item> items = serviceI.findAllByUserId(1l);
		for (Item i : items) {
			System.out.println(i);
		}
		// serviceI.persistItem(item1);
		// serviceI.persistItem(item2);
		//
		// user.setItems(new HashSet<Item>(Arrays.asList(item1, item2)));
		//
		// UserService serviceU = new UserServiceImpl();
		//
		// User user = serviceU.getById(4l);
		// for (Item i : user.getItems()) {
		// System.out.println(i);
		// }
		// List<User> users = service.findAll();
		// for (User u : users) {
		// System.out.println(u);
		// }
		// serviceU.persistUser(user);
		// user.setPassword("0000");
		// service.updateUser(user);

		// User user;
		// user = service.getById(9l);
		// System.out.println(user);
	}
}
