package com.storehouse.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.storehouse.business.services.FileService;
import com.storehouse.common.entity.File;
import com.storehouse.persistance.dao.FileDao;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FileServiceImpl implements FileService{

	@Autowired
	private	FileDao fileDao;
	
	public void persistFile(File file) {
		fileDao.persist(file);
	}

	public void updateFile(File file) {
		fileDao.update(file);
		
	}

	public void deleteFile(File file) {
		fileDao.delete(file);
		
	}

	public File getById(Long id) {
		return fileDao.getById(id);
	}

}
