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

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question = request.getParameter("Question"); //获取jsp页面传过来的参数
		String text = request.getParameter("Text");
		String name = request.getParameter("Nickname");
		String QID = request.getParameter("QID");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));
		String date = df.format(new Date());		
		HttpSession session=request.getSession(true);
		User user = (User) session.getAttribute("userInfo"); //实例化一个对象，组装属性
		user.setQuestion(question);
		user.setText(text);
		user.setDate2(date);
		System.out.println(user.getQuestion().equals(""));
		UserDao ud = new UserDaoImpl();
		
		
		if(ud.question(user)){
			request.setAttribute("Question", question);  //向request域中放置参数
			
			
		
			request.getRequestDispatcher("/success.jsp").forward(request, response);  //转发到登录页面
		}else{
			JOptionPane.showMessageDialog(null, "留言失败"); 
			response.sendRedirect("message.jsp");//重定向到首页
		}
	}


}
