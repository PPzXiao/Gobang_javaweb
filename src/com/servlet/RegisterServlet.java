package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    public RegisterServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Nickname"); //获取jsp页面传过来的参数
		String pwd = request.getParameter("Password");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		System.out.println(df.format(new Date()));
		String date = df.format(new Date());
		String email = request.getParameter("Email");
		
		User user = new User(); //实例化一个对象，组装属性
		user.setName(name);
		user.setPwd(pwd);
		user.setDate(date);
		user.setEmail(email);		
		UserDao ud = new UserDaoImpl();
		
		if(ud.register(user)){
			request.setAttribute("NickName", name);  //向request域中放置参数
			request.setAttribute("message", "注册成功");
			request.getRequestDispatcher("/login.jsp").forward(request, response);  //转发到登录页面
		}else{
			response.sendRedirect("index.jsp");//重定向到首页
		}
	}
}
