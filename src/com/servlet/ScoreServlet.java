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

@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    public RankingServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud = new UserDaoImpl();
		HttpSession session=request.getSession();
		int count = Integer.parseInt(request.getParameter("page"));
		System.out.println(count);
		session.setAttribute("initpage", count);
		User user = (User) session.getAttribute("userInfo");
		count = (count-1)*5;
		System.out.println(count);
		List<User> userAll = ud.getScore(user.getID(),count);
		session.setAttribute("userScore", userAll);
		int i = ud.getScorecount(user.getID());
		session.setAttribute("count1", i);
		request.getRequestDispatcher("/score.jsp").forward(request, response);
	}

}
