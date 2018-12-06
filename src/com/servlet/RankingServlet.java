package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.User;
import com.dao.UserDaoImpl;
import com.dao.UserDao;

@WebServlet("/RankingServlet")
public class RankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RankingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		HttpSession session=request.getSession();
		int count = Integer.parseInt(request.getParameter("page"));
		session.setAttribute("initpage", count);
		User user = (User)session.getAttribute("userInfo");
		user =ud.getAll1(user);
		session.setAttribute("userInfo", user);
		count = (count-1)*5;
		System.out.println("servlet"+count);
		List<User> userAll = ud.getUserAll1(count);
		session.setAttribute("userRanking", userAll);
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

}
