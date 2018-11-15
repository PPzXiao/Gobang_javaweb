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
		HttpSession session=request.getSession();
		if((user=ud.login(name, pwd)) != null){
			request.setAttribute("message", "��ӭ�û�"+name); //��request���з�����Ϣ
			session.setAttribute("userInfo", user);
			request.setAttribute("grant", 0);
			request.getRequestDispatcher("/success.jsp").forward(request, response);//ת�����ɹ�ҳ��
		}else{
			response.sendRedirect("login.jsp"); //�ض�����ҳ
		}

	}

}
