package com.storehouse.persistance.dao.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.storehouse.common.entity.Item;
import com.storehouse.common.entity.User;

public class Main {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

		User u = new User();
		u.setName("Dima");

		Item i1 = new Item();
		i1.setName("item for dima1");

		Item i2 = new Item();
		i2.setName("item for dima2");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(u);
		session.save(i1);
		session.save(i2);

		i1.setUser(u);
		i2.setUser(u);
		u.getItems().add(i1);
		u.getItems().add(i2);
		
		tx.commit();
		session.close();
	}
}
