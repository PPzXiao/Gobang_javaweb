package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

/**
 * Servlet implementation class RespondServlet
 */
@WebServlet("/RespondServlet")
public class RespondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer=request.getParameter("Answer");
		String name = request.getParameter("Nickname");
		System.out.println(name);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));
		String date = df.format(new Date());		
		
		String RID = request.getParameter("RID");
		HttpSession session=request.getSession(true);
		int QID=  (int) session.getAttribute("userInfo2");
		User user = (User) session.getAttribute("userInfo"); //实例化一个对象，组装属性
		user.setAnswer(answer);
		user.setDate2(date);
	    user.setQID(QID);
	  
		System.out.println(user.getAnswer().equals(""));
		UserDao ud = new UserDaoImpl();
		
		if(ud.respond(user)){
			request.setAttribute("Answer", answer);
			
			request.getRequestDispatcher("/SearchallQ?page=1").forward(request, response);  //转发到登录页面
		}else{
			JOptionPane.showMessageDialog(null, "回复失败"); 
			response.sendRedirect("respond.jsp");//重定向到首页
		}
			
		}
	}


