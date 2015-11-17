package com.storehouse.persistance.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.storehouse.persistance.dao.GenericDao;

//@Transactional(propagation = Propagation.REQUIRED)
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<?> entityClass;

	public GenericDaoImpl() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = (Class<?>) type.getActualTypeArguments()[0];
	}

	public void persist(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);

	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query query = entityManager.createQuery("Select t " + "from " + entityClass.getSimpleName() + " t ");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public T getById(Long id) {
		return (T) entityManager.find(entityClass, id);
	}

}
