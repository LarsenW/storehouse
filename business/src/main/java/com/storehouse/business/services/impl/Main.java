package com.storehouse.business.services.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.storehouse.business.services.UserService;
import com.storehouse.common.entity.Role;
import com.storehouse.common.entity.User;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("business-context.xml");
		User u = new User();
		u.setEmail("admin@gmail.com");
		u.setPassword("1111");
		//u.setUserRoles(new HashSet<Role>(Arrays.asList(role)));
		UserService s = (UserService) context.getBean("userServiceImpl");
		s.persistUser(u);

//		Role r = new Role();
//		r.setUserType(UserType.ROLE_USER);
//		RoleDao rd = (RoleDao) context.getBean("roleDaoImpl");
//		rd.persist(r);
	}
}
