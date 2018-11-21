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
 * Servlet implementation class DeleteQServlet
 */
@WebServlet("/DeleteQServlet")
public class DeleteQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		String i = request.getParameter("QID");
		int QID = Integer.parseInt(i);
		System.out.println(QID);
		if(ud.deleteq(QID)){
//			request.setAttribute("message", "É¾³ý³É¹¦");
			request.getRequestDispatcher("/SearchallQ").forward(request, response);
		}else{
			response.sendRedirect("showallq.jsp");
		}
	}



}
