<%@page import="com.db.DBConnect"%>
<%@page import="com.User.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.DAO.postDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
UserDetails user3 = (UserDetails) session.getAttribute("userD");
if (user3 == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("Login-error", "Login First...");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Notes</title>

<%@include file="all_component/allcss.jsp"%>
</head>
<body>

	<%@include file="all_component/navbar.jsp"%>
	
	<%
	String updmsg=(String)session.getAttribute("upmsg");
	if(updmsg!=null)
	{%>
		<div class="alert alert-success" role="alert"><%=updmsg%>

		</div>
	<%
	
	session.removeAttribute("upmsg");
}
	
	%>
	
	
	<%
	String delemsg=(String)session.getAttribute("delmsg");
	if(delemsg!=null)
	{%>
		<div class="alert alert-success" role="alert"><%=delemsg%>

		</div>
	<%
	
	session.removeAttribute("delmsg");
}
	
	%>
	
	<div class="container">

		<h2 class="text-center">All Notes</h2>

		<div class="row">
		<div class="col-md-12"> 


			<%
			if(user3!=null)
			{
				postDAO ob = new postDAO(DBConnect.getConn());
				List<Post> post=ob.getData(user3.getId());
				for(Post po:post) 
				{
			%>


			<div class="card mt-3">
				<img alt="" src="img/Notes.jpg" class="card-img-top mt-2 mx-auto"
					style="max-width: 100px;">

				<div class="card-body p-4">
									<h5 class="card-title"><%= po.getTitle() %></h5>

					<p><%=po.getContent() %></p>

					<p>
						<b class="text-success">Published By:<%=user3.getFirstname() %></b></br> <b class="text-primary"></b>
					</p>

					<p>
						<b class="text-success">Date:<%=po.getPdate() %></b></br> <b class="text-success"></b>
					</p>

					<div class="container text-center mt-2">

						<a href="DeleteServlet?note_id=<%=po.getId()%>" class="btn btn-danger">Delete</a>
						
						<a href="edit.jsp?note_id=<%=po.getId() %>" class="btn btn-primary">Edit</a>
					</div>
				</div>
			</div>

			<%
			}
			}
			%>

		</div>
		</div>
	</div>

</body>
</html>