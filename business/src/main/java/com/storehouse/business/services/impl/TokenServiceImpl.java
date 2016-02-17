package com.storehouse.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.storehouse.business.services.TokenService;
import com.storehouse.common.entity.Token;
import com.storehouse.persistance.dao.TokenDao;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TokenServiceImpl implements TokenService {

	@Autowired
	private TokenDao tokenDao;

	@Override
	public void persistToken(Token token) {
		tokenDao.persist(token);
	}

	@Override
	public void updateToken(Token token) {
		tokenDao.update(token);
	}

	@Override
	public void deleteToken(Token token) {
		tokenDao.delete(token);
	}

	@Override
	public List<Token> findAll() {
		return tokenDao.findAll();
	}

	@Override
	public Token getById(Long id) {
		return tokenDao.getById(id);
	}

	@Override
	public Token getByLink(String link) {
		return tokenDao.getTokenByLink(link);
	}

}
