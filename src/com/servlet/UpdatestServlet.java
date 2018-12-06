package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

/**
 * Servlet implementation class UpdatestServlet
 */
@WebServlet("/UpdatestServlet")
public class UpdatestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i = request.getParameter("PID");
		int PID = Integer.parseInt(i);
		String b = request.getParameter("Startstep");
		int Startstep = Integer.parseInt(b);
		String c = request.getParameter("Endstep");
		int Endstep = Integer.parseInt(c);
		String d = request.getParameter("eachS");
		int eachS = Integer.parseInt(d);

		UserDao ud = new UserDaoImpl();
		
		if(ud.changerulest(PID,Startstep, Endstep, eachS)){
	System.out.println("´ó³É¹¦");
			request.getRequestDispatcher("/RulestServlet").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}
}
