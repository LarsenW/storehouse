package com.strorehouse.business.services.impl;

import java.util.List;

import com.storehouse.common.entity.Item;
import com.storehouse.common.entity.User;

public class Main {
	public static void main(String[] args) {
		User user = new User();
		// user.setName("Masha");
		//
		// Item item1 = new Item();
		// item1.setDescription("Item for Masha1");
		// Item item2 = new Item();
		// item2.setDescription("Item for Masha2");
		// // ItemServiceImpl serviceI = new ItemServiceImpl();
		// // serviceI.persistItem(item);
		// user.setItems(new HashSet<Item>(Arrays.asList(item1, item2)));
		ItemServiceImpl service = new ItemServiceImpl();
		List<Item> items = service.findAllByUserId(1l);
		for (Item i : items) {
			System.out.println(i);
		}
	}
}
