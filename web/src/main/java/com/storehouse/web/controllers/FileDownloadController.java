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

import com.storehouse.business.services.ItemService;
import com.storehouse.common.entity.Item;

@Controller
public class FileDownloadController {
//	@Autowired
//	ItemService itemService;
//
//	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
//	public void handleFileDownloading(@PathVariable Long id, HttpServletResponse response) {
//
//		Item item = itemService.getById(id);
//		byte[] data = item.getFile().getData();
//
//		response.setContentType("application/octet-stream");
//		response.setHeader("Content-Disposition", "attachment; filename=\"" + item.getName() + "\"");
//		response.setContentLength(data.length);
//
//		InputStream in = new ByteArrayInputStream(data);
//		try {
//			ServletOutputStream out = response.getOutputStream();
//			while (in.read(data, 0, data.length) != -1) {
//				out.write(data, 0, data.length);
//			}
//			in.close();
//			out.flush();
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}

}
