package com.storehouse.business.services.impl;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.RoleService;
import com.storehouse.business.services.TokenCreatingService;
import com.storehouse.business.services.UserCreatingService;
import com.storehouse.business.services.UserService;
import com.storehouse.business.utils.MailSendingTool;
import com.storehouse.business.utils.PasswordHelper;
import com.storehouse.common.dto.UserDto;
import com.storehouse.common.entity.Role;
import com.storehouse.common.entity.Token;
import com.storehouse.common.entity.User;
import com.storehouse.common.enums.UserType;
import com.storehouse.common.mapper.UserMapper;

@Service
public class UserCreatingServiceImpl implements UserCreatingService {

	@Autowired
	private UserService userService;

	@Autowired
	private FTPClient ftpClient;

	@Autowired
	private PasswordHelper passwordHelper;

	@Autowired
	private TokenCreatingService tokenCreatingService;

	@Autowired
	private MailSendingTool mailSendingTool;

	@Override
	public boolean createUser(UserDto userDto) {
		try {
			ftpClient.makeDirectory(userDto.getUsername());
			UserMapper userMapper = new UserMapper();
			User user = userMapper.dtoToEntity(userDto);
			user.setPassword(passwordHelper.encode(user.getPassword()));
			Token token = tokenCreatingService.createToken();

			mailSendingTool.sendRegistrationEmail(user.getEmail(), token.getLink());

			userService.persistUser(user);
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("User`s folder is not created, cannot establish connection with remote server");
		}
		return false;
	}

	public boolean checkIfEmailExist(String email) {
		try {
			userService.loadUserByUsername(email);
			return true;
		} catch (UsernameNotFoundException e) {
			return false;
		}
	}

	public boolean checkIfUsernameExist(String username) {
		if (userService.getByName(username) != null) {
			return true;
		} else {
			return false;
		}

	}
}
