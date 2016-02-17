package com.storehouse.persistance.dao.impl;

import org.springframework.stereotype.Repository;

import com.storehouse.common.entity.Token;
import com.storehouse.persistance.dao.TokenDao;

@Repository
public class TokenDaoImpl extends GenericDaoImpl<Token> implements TokenDao {

}
