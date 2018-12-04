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
 * Servlet implementation class SearchallQ
 */
@WebServlet("/SearchallQ")
public class SearchallQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				UserDao ud = new UserDaoImpl();
				List<User> questionAll = ud.getQuestionAll();
				
			        String p = request.getParameter("page");
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
			        request.setAttribute("totalUsers", totalUsers);
			        request.setAttribute("usersPerPage", usersPerPage);
			        request.setAttribute("totalPages", totalPages);
			        request.setAttribute("beginIndex", beginIndex);
			        request.setAttribute("endIndex", endIndex);
			        request.setAttribute("page", page);
			        request.setAttribute("questionAll", questionAll);
		            request.getRequestDispatcher("/showallq.jsp").forward(request, response);
	}
	@Override
    public void init() throws ServletException {
		UserDao ud = new UserDaoImpl();
		List<User> questionAll = ud.getQuestionAll();
	}

}
