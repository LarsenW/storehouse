package com.storehouse.persistance.dao.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.storehouse.common.entity.User;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		// User u = new User();
		// u.setName("James Bond");
		// UserService s = (UserService) context.getBean("userServiceImpl");
		// s.persistUser(u);
		for (String s : context.getBeanDefinitionNames()) {
			System.out.println(s);
		}
		// List<User> us;
		// // UserService s = (UserService) context.getBean("userServiceImpl");
		// UserService s = new UserServiceImpl();
		// us = s.findAll();
		// for (User u : us) {
		// System.out.println(u);
		// }
	}
}
