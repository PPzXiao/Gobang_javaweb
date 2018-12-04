package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

@WebServlet("/ModifyMServlet")
public class ModifyMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//
//    public UpdateServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i = request.getParameter("UserID");
		int ID = Integer.parseInt(i);
		String email = request.getParameter("Email");		
		UserDao ud = new UserDaoImpl();
		HttpSession session = request.getSession(true);  
		User user = (User) session.getAttribute("userInfo");
		if(ud.modifyM(ID, email)){
			user.setEmail(email);
			session.setAttribute("userInfo", user);
			request.setAttribute("message", "1");
			request.getRequestDispatcher("/Modify.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "0");
			request.getRequestDispatcher("/Modify.jsp").forward(request, response);
		}
	}
}
