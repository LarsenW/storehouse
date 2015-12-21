package com.storehouse.persistance.dao;

import com.storehouse.common.entity.File;

public interface FileDao extends GenericDao<File> {
	public File findFileByItemId(Long id);

}