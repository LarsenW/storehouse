package com.storehouse.business.services.impl;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.AutoLoginService;
import com.storehouse.common.entity.User;

@Service
public class AutoLoginServiceImpl implements AutoLoginService {

	@Override
	public void autheticateUser(User user) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(user, null,
				AuthorityUtils.createAuthorityList("ROLE_USER"));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}
