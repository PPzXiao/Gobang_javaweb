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
		String name = request.getParameter("Nickname"); //��ȡjspҳ�洫�����Ĳ���
		String pwd = request.getParameter("Password");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
//		System.out.println(df.format(new Date()));
		String date = df.format(new Date());
		String email = request.getParameter("Email");
		
		User user = new User(); //ʵ����һ��������װ����
		user.setName(name);
		user.setPwd(pwd);
		user.setDate(date);
		user.setEmail(email);		
		UserDao ud = new UserDaoImpl();
		
		if(ud.register(user)){
			request.setAttribute("NickName", name);  //��request���з��ò���
			request.setAttribute("message", "ע��ɹ�");
			request.getRequestDispatcher("/login.jsp").forward(request, response);  //ת������¼ҳ��
		}else{
			response.sendRedirect("index.jsp");//�ض�����ҳ
		}
	}
}
