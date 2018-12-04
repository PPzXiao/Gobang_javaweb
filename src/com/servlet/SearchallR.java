package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

/**
 * Servlet implementation class SearchallQ
 */
@WebServlet("/SearchallR")
public class SearchallR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		String QID = (String) request.getParameter("QID");
		int ID = Integer.parseInt(QID);
		System.out.println("SERVLET"+ID);
		List<User> replyAll = ud.getReplyAll(ID);
	
		
		request.setAttribute("replyAll", replyAll);
		request.getRequestDispatcher("/showallr.jsp").forward(request, response);
	}

}
