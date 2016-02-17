package com.storehouse.business.services.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.TokenCreatingService;
import com.storehouse.business.services.TokenService;
import com.storehouse.common.entity.Token;

@Service
public class TokenCreatingServiceImpl implements TokenCreatingService {
	@Autowired
	private TokenService tokenService;

	@Override
	public Token createToken() {
		Token token = new Token();
		Date currentDate = new Date();
		token.setExpirationDate(new Date(currentDate.getTime() + 5 * 60_000));
		String link = "http://localhost:8080/web/" + UUID.randomUUID().toString();
		token.setLink(link);
		return token;
	}

}
