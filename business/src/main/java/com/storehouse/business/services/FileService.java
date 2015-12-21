package com.storehouse.business.services;

import com.storehouse.common.entity.File;

public interface FileService {
	public void persistFile(File file);

	public void updateFile(File file);

	public void deleteFile(File file);
	
	public File getById(Long id);
}
