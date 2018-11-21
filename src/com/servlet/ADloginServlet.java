package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;
@WebServlet("/ADloginServlet")
public class ADloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//       
//    public ADloginServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("ADname"); //得到jsp页面传过来的参数
		String pwd = request.getParameter("ADpassword");
		User user = new User();
		HttpSession session=request.getSession();
		UserDao ud = new UserDaoImpl();
		if((user = ud.ADlogin(name, pwd))!=null){
			request.setAttribute("message", "欢迎管理员"+name); //向request域中放置信息
			session.setAttribute("grant", 1);
			session.setAttribute("userInfo", user);
			request.getRequestDispatcher("/success.jsp").forward(request, response);//转发到成功页面
		}else{
			response.sendRedirect("login.jsp"); //重定向到首页
		}

	}

}
