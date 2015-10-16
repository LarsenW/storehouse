package com.storehouse.persistance.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.storehouse.persistance.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	private EntityTransaction currentTransaction;
	private EntityManager entityManager;
	private EntityManagerFactory factory;

	public void beginTransaction() {
		initializeEntityManager();
		currentTransaction = entityManager.getTransaction();
		currentTransaction.begin();
	}

	public void closeTransaction() {
		if (currentTransaction != null) {
			currentTransaction.commit();
			System.out.println("transaction committed");
		}
		entityManager.close();
		factory.close();
	}

	public void rollbackCurrentTransaction() {
		System.out.println("rollback");
		currentTransaction.rollback();
		currentTransaction = null;
	}

	private void initializeEntityManager() {
		factory = Persistence.createEntityManagerFactory("JpaService");
		entityManager = factory.createEntityManager();
	}

	public void persist(T entity) {
		try {
			entityManager.persist(entity);
			// throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackCurrentTransaction();
		}

	}

	public void update(T entity) {
		try {
			entityManager.merge(entity);
			// throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackCurrentTransaction();
		}

	}

	public void delete(T entity) {
		try {
			entityManager.remove(entity);
		} catch (Exception e) {
			e.printStackTrace();
			rollbackCurrentTransaction();
		}
	}

}
