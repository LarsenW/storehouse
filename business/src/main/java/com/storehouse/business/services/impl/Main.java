package com.storehouse.business.services.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.storehouse.business.services.RoleService;
import com.storehouse.common.entity.Role;
import com.storehouse.common.enums.UserType;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("business-context.xml");
		// User u = new User();
		// u.setName("Vasyl");
		// u.setEmail("user@gmail.com");
		// u.setPassword("1111");
		// Role role = new Role();
		// role.setUserType(UserType.ROLE_USER);
		// u.setUserRoles(new HashSet<Role>(Arrays.asList(role)));
		// UserService s = (UserService) context.getBean("userServiceImpl");
		// s.persistUser(u);
		RoleService s = (RoleService) context.getBean("roleServiceImpl");
		Role role = s.getRoleByUserType(UserType.ROLE_ADMIN);
		System.out.println(role.getId());

	}
}
