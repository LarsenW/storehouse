package com.storehouse.business.services.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.storehouse.business.services.ItemService;
import com.storehouse.common.entity.Item;
import com.storehouse.common.enums.FileCategory;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("business-context.xml");
		// User u = new User();
		// u.setEmail("admin@gmail.com");
		// u.setPassword("1111");
		// //u.setUserRoles(new HashSet<Role>(Arrays.asList(role)));
		// UserService s = (UserService) context.getBean("userServiceImpl");
		// s.persistUser(u);

		// Role r = new Role();
		// r.setUserType(UserType.ROLE_USER);
		// RoleDao rd = (RoleDao) context.getBean("roleDaoImpl");
		// rd.persist(r);

		Item item = new Item();
		item.setName("ddt rodina");
		item.setFileCategory(FileCategory.AUDIO);
		ItemService is = (ItemService) context.getBean("itemServiceImpl");
		is.persistItem(item);
	}
}
