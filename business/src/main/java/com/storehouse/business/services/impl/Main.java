package com.storehouse.business.services.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.storehouse.business.services.UserService;
import com.storehouse.common.entity.User;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("business-context.xml");
		// User u = new User();
		// u.setName("Shumaher");
		// UserService s = (UserService) context.getBean("userServiceImpl");
		// s.persistUser(u);
		// List<User> us;
		// UserService s = (UserService) context.getBean("userServiceImpl");
		// us = s.findAll();
		// for (User u : us) {
		// System.out.println(u);
		// }
		int count = 0;
		for (String s : context.getBeanDefinitionNames()) {
			System.out.println(s);
		}
		System.out.println(count);
	}
}
