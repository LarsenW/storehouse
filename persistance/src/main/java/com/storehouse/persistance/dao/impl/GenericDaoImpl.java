package com.storehouse.persistance.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.storehouse.persistance.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	private Session currentSession;
	private Transaction currentTransaction;

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
		System.out.println("close session");
	}

	public void rollbackCurrentTransaction() {
		System.out.println("rollback");
		currentTransaction.rollback();
		currentTransaction = null;
	}

	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;

	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(T entity) {
		try {
			currentTransaction = currentSession.beginTransaction();
			getCurrentSession().save(entity);
			// throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackCurrentTransaction();
		} finally {
			if (currentTransaction != null) {
				currentTransaction.commit();
				System.out.println("transaction committed");
			}
		}
	}

	public void update(T entity) {
		try {
			currentTransaction = currentSession.beginTransaction();
			getCurrentSession().update(entity);
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackCurrentTransaction();
		} finally {
			if (currentTransaction != null) {
				currentTransaction.commit();
				System.out.println("transaction committed");
			}
		}
	}

	public void delete(T entity) {
		try {
			currentTransaction = currentSession.beginTransaction();
			getCurrentSession().delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
			rollbackCurrentTransaction();
		} finally {
			if (currentTransaction != null) {
				currentTransaction.commit();
				System.out.println("transaction committed");
			}
		}
	}

}
