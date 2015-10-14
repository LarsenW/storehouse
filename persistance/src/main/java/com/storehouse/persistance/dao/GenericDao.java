package com.storehouse.persistance.dao;

import java.util.List;

public interface GenericDao<T> {

	public void persist(T object);

	public void update(T object);

	public void delete(T object);

	public List<T> findAll();

	public T getById(Long id);
}
