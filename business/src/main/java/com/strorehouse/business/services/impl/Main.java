package com.strorehouse.business.services.impl;

import com.storehouse.common.entity.Item;
import com.storehouse.common.entity.User;

public class Main {
	public static void main(String[] args) {
//		User user = new User();
//		user.setName("Olia");
//		UserServiceImpl service = new UserServiceImpl();
//		service.persistUser(user);
//		UserServiceImpl service2 = new UserServiceImpl();
//		user.setEmail("olia@mail.ru");
//		service2.updateUser(user);
		
		
		Item item=new Item();
		item.setDescription("some Item");
		ItemServiceImpl serviceI=new ItemServiceImpl();
		serviceI.persistItem(item);
	}
}
