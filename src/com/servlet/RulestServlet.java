package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

/**
 * Servlet implementation class RulestServlet
 */
@WebServlet("/RulestServlet")
public class RulestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
	
		List<User> rulest = ud.rulest();
		
		request.setAttribute("rulest", rulest);
		request.getRequestDispatcher("/rulest.jsp").forward(request, response);
		//request.getRequestDispatcher("/rule.jsp").forward(request, response);
	}
}


