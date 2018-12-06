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
 * Servlet implementation class UpdateRServlet
 */
@WebServlet("/UpdatesServlet")
public class UpdatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("each1");
		int each1 = Integer.parseInt(a);
		
		UserDao ud = new UserDaoImpl();
		
		if(ud.changerules(each1)){
			System.out.println("³É¹¦");
	
			request.getRequestDispatcher("/RuleServlet").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}
}
