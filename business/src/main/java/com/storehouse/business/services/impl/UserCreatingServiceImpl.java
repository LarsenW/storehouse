package com.storehouse.business.services.impl;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.UserCreatingService;
import com.storehouse.business.services.UserService;
import com.storehouse.common.dto.UserDto;
import com.storehouse.common.mapper.UserMapper;

@Service
public class UserCreatingServiceImpl implements UserCreatingService {
	@Autowired
	UserService userService;

	@Autowired
	FTPClient ftpClient;

	@Override
	public boolean createUser(UserDto userDto) {
		try {
			ftpClient.makeDirectory(userDto.getUsername());
			UserMapper userMapper = new UserMapper();
			userService.persistUser(userMapper.dtoToEntity(userDto));
			return true;

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("User`s folder is not created, cannot establish connection with remote server");	
		}
		return false;
	}
}
