package com.storehouse.persistance.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.storehouse.common.entity.Token;
import com.storehouse.persistance.dao.TokenDao;

@Repository
public class TokenDaoImpl extends GenericDaoImpl<Token> implements TokenDao {

	@Override
	public Token getTokenByLink(String link) {
		Query query = entityManager.createQuery("Select t FROM Token t WHERE t.link = :link");
		query.setParameter("link", link);
		Token token = null;
		try {
			token = (Token) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("no result");
			return token;
		}
		return token;
	}

}
