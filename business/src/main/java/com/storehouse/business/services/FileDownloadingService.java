package com.storehouse.business.services;

import java.io.InputStream;

public interface FileDownloadingService {
	
	public InputStream downloadFile(Long itemId);
	
}
