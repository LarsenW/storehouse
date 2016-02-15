package com.storehouse.business.services;

import com.storehouse.common.dto.UserDto;

public interface AutoLoginService {

	public void autheticateUser(UserDto userDto);
}
