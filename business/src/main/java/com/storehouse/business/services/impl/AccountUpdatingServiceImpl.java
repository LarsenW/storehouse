package com.storehouse.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.AccountUpdatingService;
import com.storehouse.business.services.UserCreatingService;
import com.storehouse.business.services.UserService;
import com.storehouse.common.entity.User;

@Service
public class AccountUpdatingServiceImpl implements AccountUpdatingService {

	@Autowired
	private UserService userService;

	@Autowired
	private UserCreatingService userCreatingService;

	public boolean updateEmail(User user, String email) {
		if (!userCreatingService.checkIfEmailExist(email)) {
			user.setEmail(email);
			userService.updateUser(user);
			return true;
		} else {
			return false;
		}

	}

}
