package com.storehouse.business.services.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.FileDownloadingService;
import com.storehouse.business.services.ItemService;
import com.storehouse.common.entity.Item;

@Service
public class FileDownloadingServiceImpl implements FileDownloadingService {

	@Autowired
	private ItemService itemService;

	@Autowired
	private FTPClient ftpClient;

	@Override
	public InputStream downloadFile(Long itemId) {
		Item item = itemService.getById(itemId);
		String link = item.getLink();
		InputStream inputStream = null;
		try {
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			inputStream = ftpClient.retrieveFileStream(link);
			return inputStream;

		} catch (IOException ex) {
			return inputStream;
		}
	}

}
