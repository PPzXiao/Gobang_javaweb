package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DealServlet")
public class DealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String step = request.getParameter("step"); //得到jsp页面传过来的参数	
		String Win = request.getParameter("WorL");
		String time = request.getParameter("time"); 
		System.out.println(step);
		System.out.println(Win);
		System.out.println(time);
	}

}
