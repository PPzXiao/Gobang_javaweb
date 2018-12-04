package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		UserDao ud = new UserDaoImpl();
		List<User> questionAll = ud.getQuestionAll();
		@Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String p = req.getParameter("page");
	        int page;
	        try {
	            //��ǰҳ��
	            page = Integer.valueOf(p);
	        } catch (NumberFormatException e) {
	            page = 1;
	        }
	        //�û�����
	        int totalUsers = questionAll.size();
	        //ÿҳ�û���
	        int usersPerPage = 8;
	        //��ҳ��
	        int totalPages = totalUsers % usersPerPage == 0 ? totalUsers / usersPerPage : totalUsers / usersPerPage + 1;
	        //��ҳ��ʼ�û����
	        int beginIndex = (page - 1) * usersPerPage;
	        //��ҳĩβ�û���ŵ���һ��
	        int endIndex = beginIndex + usersPerPage;
	        if (endIndex > totalUsers)
	            endIndex = totalUsers;
	        req.setAttribute("totalUsers", totalUsers);
	        req.setAttribute("usersPerPage", usersPerPage);
	        req.setAttribute("totalPages", totalPages);
	        req.setAttribute("beginIndex", beginIndex);
	        req.setAttribute("endIndex", endIndex);
	        req.setAttribute("page", page);
	        req.setAttribute("questionAll", questionAll);
	        req.getRequestDispatcher("showallq.jsp").forward(req, resp);
	    }

	    @Override
	    public void init() throws ServletException {
	    	UserDao ud = new UserDaoImpl();
	    	questionAll = ud.getQuestionAll();
	    }
	}





