package com.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;
import com.mysql.cj.Session;


@WebServlet("/DealServlet")
public class DealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int step = Integer.parseInt(request.getParameter("step")); //得到jsp页面传过来的参数	
		String Win = request.getParameter("WorL");
		int time = Integer.parseInt(request.getParameter("time"));
		double num = (double)time/1000;
		BigDecimal b = new BigDecimal(num);
		double second = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		String date = request.getParameter("date");
		HttpSession session = request.getSession(true);  
		User user = (User) session.getAttribute("userInfo");
		user.setStep(step);
		user.setWorL(Win);
		user.setTime(second);
		user.setGameDate(date);
		UserDao ud = new UserDaoImpl();
		if(ud.AddScore(user)){
			session.setAttribute("userInfo", user);
			request.getRequestDispatcher("RankingServlet?page=1").forward(request, response);  //转发到登录页面
		}else{
			JOptionPane.showMessageDialog(null, "出错啦"); 
			response.sendRedirect("success.jsp");//重定向到首页
		}
//		System.out.println(user.getID());
//		System.out.println(num);
//		System.out.println(second);
//		System.out.println(time);
//		System.out.println(date);
	}

}
