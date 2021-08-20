package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.postDAO;
import com.db.DBConnect;


@WebServlet("/runservlet")
public class runservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String runid=request.getParameter("run");
		
	
		
		if(runid!=null)
		{
			//System.out.println("deleted");
            HttpSession session=request.getSession();
            
          //  session.setAttribute("runmsg", "Post Deleted Successfully!");
            response.sendRedirect("index.jsp");
            }
		else
		{
			System.out.println("not deleted");

		}
		
	}}


