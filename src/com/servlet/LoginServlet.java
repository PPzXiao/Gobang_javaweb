package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//    public LoginServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Nickname"); //�õ�jspҳ�洫�����Ĳ���
		String pwd = request.getParameter("Password");
		User user = new User();
		UserDao ud = new UserDaoImpl();
		List<User> userAll = ud.getUserAll();
		HttpSession session=request.getSession();
		if((user=ud.login(name, pwd)) != null){
			user=ud.getAll1(user);
			userAll = ud.getUserAll1(0);
			int count = ud.getAll1count();
			request.setAttribute("message", "��ӭ�û�"+name); //��request���з�����Ϣ
			session.setAttribute("userInfo", user);
			session.setAttribute("count", count);
			session.setAttribute("initpage", 1);
			session.setAttribute("userRanking", userAll);
			session.setAttribute("grant", 0);
			request.getRequestDispatcher("/success.jsp").forward(request, response);//ת�����ɹ�ҳ��
		}else{
			response.sendRedirect("login.jsp"); //�ض�����ҳ
		}

	}

}
