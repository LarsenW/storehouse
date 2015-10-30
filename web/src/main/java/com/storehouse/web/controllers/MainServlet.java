package com.storehouse.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String n = "Dmitry";
		req.setAttribute("name", n);
		Cookie cookie = new Cookie("name", n);
		cookie.setMaxAge(60 * 60 * 24);
		resp.addCookie(cookie);
		req.getRequestDispatcher("mypage.jsp").forward(req, resp);
		;
	}

}
