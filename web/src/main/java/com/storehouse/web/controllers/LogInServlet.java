package com.storehouse.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/enter")
public class LogInServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		session.setAttribute("login", req.getParameter("login"));
		System.out.println("Current login is:" + session.getAttribute("login"));
		req.getRequestDispatcher("afterlogin.jsp").forward(req, resp);
	}
}
