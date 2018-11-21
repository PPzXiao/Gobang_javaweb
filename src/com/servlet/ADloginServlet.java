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
		String name = request.getParameter("ADname"); //�õ�jspҳ�洫�����Ĳ���
		String pwd = request.getParameter("ADpassword");
		User user = new User();
		HttpSession session=request.getSession();
		UserDao ud = new UserDaoImpl();
		if((user = ud.ADlogin(name, pwd))!=null){
			request.setAttribute("message", "��ӭ����Ա"+name); //��request���з�����Ϣ
			session.setAttribute("grant", 1);
			session.setAttribute("userInfo", user);
			request.getRequestDispatcher("/success.jsp").forward(request, response);//ת�����ɹ�ҳ��
		}else{
			response.sendRedirect("login.jsp"); //�ض�����ҳ
		}

	}

}
