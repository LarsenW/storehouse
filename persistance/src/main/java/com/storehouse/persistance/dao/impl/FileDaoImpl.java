package com.storehouse.persistance.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.storehouse.common.entity.File;
import com.storehouse.persistance.dao.FileDao;

@Repository
public class FileDaoImpl extends GenericDaoImpl<File> implements FileDao {

	public File findFileByItemId(Long id) {
		Query jpqlQuery = entityManager.createQuery("Select f from File f where f.item.id= :id");
		jpqlQuery.setParameter("id", id);
		return (File) jpqlQuery.getSingleResult();
	}

}
