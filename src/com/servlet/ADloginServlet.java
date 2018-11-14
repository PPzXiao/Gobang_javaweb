package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
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
		
		AdminDao ud = new AdminDaoImpl();
		
		if(ud.login(name, pwd)){
			request.setAttribute("message", "��ӭ����Ա"+name); //��request���з�����Ϣ
			request.setAttribute("grant", 1);
			request.getRequestDispatcher("/success.jsp").forward(request, response);//ת�����ɹ�ҳ��
		}else{
			response.sendRedirect("login.jsp"); //�ض�����ҳ
		}

	}

}
