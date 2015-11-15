package com.storehouse.business.services.impl;

import java.util.Arrays;

import java.util.HashSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.storehouse.business.services.UserService;
import com.storehouse.business.utils.PasswordHelper;
import com.storehouse.common.entity.Role;
import com.storehouse.common.entity.User;
import com.storehouse.common.enums.UserType;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("business-context.xml");
		User u = new User();
		u.setEmail("grisha@gmail.com");

		Role role = new Role();
		role.setUserType(UserType.ROLE_USER);
		u.setUserRoles(new HashSet<Role>(Arrays.asList(role)));
		UserService s = (UserService) context.getBean("userServiceImpl");
		PasswordHelper ph = (PasswordHelper) context.getBean("passwordHelper");
		String encodedPassword = ph.encode("1111");
		u.setPassword(encodedPassword);

		s.persistUser(u);
	}
}
