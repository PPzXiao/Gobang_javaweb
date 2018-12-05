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
@WebServlet("/SearchallQ")
public class SearchallQ extends HttpServlet {
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				UserDao ud = new UserDaoImpl();
				HttpSession session=request.getSession();
				int count = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("initpage2", count);
				count = (count-1)*8;
				
				System.out.println(count);
				List<User> questionAll = ud.getQuestionAll(count);
				int j = ud.getQuestioncount();
				session.setAttribute("count2", j);
				
				
				request.setAttribute("questionAll", questionAll);
	            request.getRequestDispatcher("/showallq.jsp").forward(request, response);
	}
}
