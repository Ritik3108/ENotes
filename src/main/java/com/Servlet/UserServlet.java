package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.User.UserDetails;
import com.db.DBConnect;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet
{
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
{
	String name=request.getParameter("ufname");
	String email=request.getParameter("uemail");
	String pass=request.getParameter("upass");
	
	UserDetails us=new UserDetails();
	us.setFirstname(name);
	us.setEmail(email);
	us.setPassword(pass);
	
	UserDAO udao=new UserDAO(DBConnect.getConn());
    boolean f=udao.addUser(us);
	//PrintWriter out=response.getWriter();
    HttpSession session;

    if(f)
    {
    	//out.print("User Added Successfully");
    	session=request.getSession();
    	session.setAttribute("reg-success", "Registration Successful!");
    	response.sendRedirect("register.jsp");
    	
    	
    }
    else
    {
    	//out.print("Error!");
    	session=request.getSession();

    	session.setAttribute("fail-msg", "Something went wrong!");
    	response.sendRedirect("register.jsp");

    }
	
}
}
