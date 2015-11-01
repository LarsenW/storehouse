package com.storehouse.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getlocale")
public class GetLocale extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the client's Locale
		Locale locale = request.getLocale();
		String language = locale.getLanguage();
		String country = locale.getCountry();

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String title = "Detecting Locale";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(
				docType + "<html>\n" + "<head><title>" + title + "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n"
						+ "<h1 align=\"center\">" + language + "</h1>\n" + "<h2 align=\"center\">" + country + "</h2>\n"
						+ "</body></html>" + "<h2 align=\"center\">" + locale + "</h2>\n" + "</body></html>");
	}

}
