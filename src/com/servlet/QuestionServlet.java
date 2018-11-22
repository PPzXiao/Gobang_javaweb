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
		String question = request.getParameter("Question"); //��ȡjspҳ�洫�����Ĳ���
		String text = request.getParameter("Text");
		String name = request.getParameter("Nickname");
		String QID = request.getParameter("QID");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		System.out.println(df.format(new Date()));
		String date = df.format(new Date());		
		HttpSession session=request.getSession(true);
		User user = (User) session.getAttribute("userInfo"); //ʵ����һ��������װ����
		user.setQuestion(question);
		user.setText(text);
		user.setDate2(date);
		System.out.println(user.getQuestion().equals(""));
		UserDao ud = new UserDaoImpl();
		
		
		if(ud.question(user)){
			request.setAttribute("Question", question);  //��request���з��ò���
			
			
		
			request.getRequestDispatcher("/success.jsp").forward(request, response);  //ת������¼ҳ��
		}else{
			JOptionPane.showMessageDialog(null, "����ʧ��"); 
			response.sendRedirect("message.jsp");//�ض�����ҳ
		}
	}


}
