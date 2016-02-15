package com.storehouse.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.AutoLoginService;
import com.storehouse.common.dto.UserDto;

@Service
public class AutoLoginServiceImpl implements AutoLoginService {

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void autheticateUser(UserDto userDto) {
		UserDetails userDetail = userDetailsService.loadUserByUsername(userDto.getEmail());
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDto.getEmail(),
				userDto.getPassword(), userDetail.getAuthorities());
		Authentication authentication= authManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}
