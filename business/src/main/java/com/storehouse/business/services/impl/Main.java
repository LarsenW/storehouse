package com.storehouse.business.services.impl;

import java.util.Arrays;

import java.util.HashSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.storehouse.business.services.UserService;
import com.storehouse.common.entity.Role;
import com.storehouse.common.entity.User;
import com.storehouse.common.enums.UserType;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("business-context.xml");
		User u = new User();
		u.setEmail("user@gmail.com");
		u.setPassword("user");
		Role role = new Role();
		role.setUserType(UserType.ROLE_USER);
		u.setUserRoles(new HashSet<Role>(Arrays.asList(role)));
		UserService s = (UserService) context.getBean("userServiceImpl");
		 s.persistUser(u);
		// System.out.println(s.getById(3l).getUserRoles());
		// System.out.println(s.loadUserByUsername("Alfred"));
	}
}
