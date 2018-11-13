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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//    public DeleteServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		String i = request.getParameter("UserID");
		int ID = Integer.parseInt(i);
		System.out.println(ID);
		if(ud.delete(ID)){
			request.setAttribute("message", "É¾³ý³É¹¦");
			request.getRequestDispatcher("/Searchall").forward(request, response);
		}else{
			response.sendRedirect("index.jsp");
		}
	}

}
