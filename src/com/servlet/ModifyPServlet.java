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

@WebServlet("/ModifyPServlet")
public class ModifyPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//
//    public UpdateServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i = request.getParameter("UserID");
		int ID = Integer.parseInt(i);
		String password0 = request.getParameter("Password0");	
		String password1 = request.getParameter("Password1");		
		String password2 = request.getParameter("Password2");
		String name = request.getParameter("Nickname");		
		UserDao ud = new UserDaoImpl();
		HttpSession session = request.getSession(true);  
		User user = (User) session.getAttribute("userInfo");
		User user0 = new User();
		if((user0=ud.login(name, password0)) != null&&password1.equals(password2)){
			if(ud.modifyP(ID, password1)) {
				user.setPwd(user0.getPwd());
				session.setAttribute("userInfo", user);
				request.setAttribute("message", "1");
		
				request.getRequestDispatcher("/ModifyP.jsp").forward(request, response);
			}
			else {
				request.setAttribute("message", "0");
				request.getRequestDispatcher("/ModifyP.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("message", "0");
			request.getRequestDispatcher("/ModifyP.jsp").forward(request, response);
		}
	}
}
