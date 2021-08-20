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

@WebServlet("/EditNotesServlet")
public class EditNotesServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		try {
			
			Integer noteid = Integer.parseInt(request.getParameter("noteid"));
			String title = request.getParameter("ptitle");
			String content = request.getParameter("pcontent");

			postDAO dao=new postDAO(DBConnect.getConn());
			boolean f=dao.updatePost(noteid, title, content);
			
			if(f)
			{
				//System.out.println("Updated");
				HttpSession session=request.getSession();
				session.setAttribute("upmsg","Post Updated Successfully!");
				response.sendRedirect("ShowNotes.jsp");
			}
			else
			{
				System.out.println("Not Updated");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
