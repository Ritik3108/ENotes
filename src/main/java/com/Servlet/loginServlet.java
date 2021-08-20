package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.User.UserDetails;
import com.db.DBConnect;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email=request.getParameter("lgemail");
		String pass=request.getParameter("lgpass");
		
		UserDetails us=new UserDetails();
		us.setEmail(email);
		us.setPassword(pass);
		
		UserDAO udao=new UserDAO(DBConnect.getConn());
		UserDetails user=udao.loginUser(us);
		HttpSession session;
		
		if(user!=null)
		{
			session=request.getSession();
			session.setAttribute("userD", user);
			response.sendRedirect("Home.jsp");
		}
		else
		{
			session=request.getSession();
	    	session.setAttribute("fail-login", "Invalid Login!");
			response.sendRedirect("login.jsp");

		}


	}

}
