package com.storehouse.persistance.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.storehouse.persistance.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	private EntityTransaction currentTransaction;
	protected EntityManager entityManager;
	private EntityManagerFactory factory;
	private Class<?> entityClass;

	public GenericDaoImpl() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = (Class<?>) type.getActualTypeArguments()[0];
	}

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

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query query = entityManager.createQuery("Select t" + "from "+ entityClass.getSimpleName() +" t ");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public T getById(Long id) {
		return (T) entityManager.find(entityClass, id);
		// return null;
	}

}
