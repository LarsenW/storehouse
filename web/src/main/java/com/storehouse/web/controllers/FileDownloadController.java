package com.storehouse.web.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.storehouse.business.services.FileDownloadingService;

@Controller
public class FileDownloadController {

	@Autowired
	FileDownloadingService fileDownloadingService;

	@RequestMapping(value = "profile/download/{id}", method = RequestMethod.GET)
	public void handleFileDownloading(@PathVariable Long id, HttpServletResponse response) {
		InputStream inputStream = fileDownloadingService.downloadFile(id);
		if (inputStream != null) {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + "\"");
			try {
				ServletOutputStream out = response.getOutputStream();
				int c;
				while ((c = inputStream.read()) != -1) {
					out.write(c);
				}
				inputStream.close();
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
