package com.storehouse.persistance.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.storehouse.common.entity.User;

public class TestEntityManager {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JpaService");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		User user = new User();
		user.setName("Gena");
		entitymanager.persist(user);

		entitymanager.getTransaction().commit();
		entitymanager.close();
	}

}
