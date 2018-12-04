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
 * Servlet implementation class SearchmyQ
 */
@WebServlet("/SearchmyQ")
public class SearchmyQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
					UserDao ud = new UserDaoImpl();
				
					HttpSession session=request.getSession(true);
					User user = (User)  session.getAttribute("userInfo");
					String Nickname=user.getName();
					System.out.println(Nickname);
					List<User> myQuestion = ud.getMyQuestion(Nickname);
					
				        request.setAttribute("myQuestion", myQuestion);
			            request.getRequestDispatcher("/showmyq.jsp").forward(request, response);
		}
}
