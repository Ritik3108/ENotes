package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.postDAO;
import com.db.DBConnect;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		
		String title=request.getParameter("ptitle");
		String content=request.getParameter("pcontent");
		
		postDAO dao=new postDAO(DBConnect.getConn());
		boolean f=dao.addNotes(title,content,uid);
		
		if(f)
		{
			System.out.println("Success");
			response.sendRedirect("ShowNotes.jsp");
		}
		else
		{
			System.out.println("Not Success");
	
		}
		

		
	}

}
