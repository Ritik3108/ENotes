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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer noteid=Integer.parseInt(request.getParameter("note_id"));
		
		postDAO dao=new postDAO(DBConnect.getConn());
		boolean f=dao.delPost(noteid);
		
		if(f)
		{
			//System.out.println("deleted");
            HttpSession session=request.getSession();
            
            session.setAttribute("delmsg", "Post Deleted Successfully!");
            response.sendRedirect("ShowNotes.jsp");
            }
		else
		{
			System.out.println("not deleted");

		}
		
		
	}

}
