package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.UserDao;
import com.dao.UserDaoImpl;
//import com.entity.User;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
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
		String name = request.getParameter("Nickname");
		String pwd = request.getParameter("Password");
		String date = request.getParameter("RegisterDate");
		String email = request.getParameter("Email");
		
		System.out.println("------------------------------------"+ID);
		
		UserDao ud = new UserDaoImpl();
		
		if(ud.update(ID, name, pwd, date, email)){
			request.setAttribute("message", "更新成功");
			request.getRequestDispatcher("/Searchall").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}
}
