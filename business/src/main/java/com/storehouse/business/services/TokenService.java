package com.storehouse.business.services;

import java.util.List;

import com.storehouse.common.entity.Token;

public interface TokenService {

	public void persistToken(Token token);

	public void updateToken(Token token);

	public void deleteToken(Token token);

	public List<Token> findAll();

	public Token getById(Long id);
	
	public Token getByLink(String link);
}
