<%@page import="com.User.Post"%>
<%@page import="com.db.DBConnect"%>
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
<title>Edit Notes</title>
<%@include file="all_component/allcss.jsp" %>
</head>
<body>

<%
Integer noteid=Integer.parseInt(request.getParameter("note_id"));

postDAO dao=new postDAO(DBConnect.getConn());
Post p=dao.getDataById(noteid);

%>

<%@include file="all_component/navbar.jsp"%>

	<div class="py-3">
	
	<h1 class="text-center mt-4">EDIT YOUR NOTES</h1>

	
	<form action="EditNotesServlet" method="post">
	
	<div class="container ">
			<input type="hidden" value="<%=noteid%>" name="noteid">
	
	

		<label>Note Title</label>
		<input type="text" class="form-control"  value="<%=p.getTitle() %>" name="ptitle" required="required"></input>
		
		</div >
		<div class="container ">
		<label class="mt-4">Note Content</label>
		
				<textarea rows="8" col="" class="form-control" name="pcontent" required="required"><%=p.getContent() %></textarea>
				<div class="text-center"><button type="submit" class="btn btn-primary mt-3 ">Edit</button></div>
				
		
		
		
	</div>
	</form>
	</div>	
	<%@include file="all_component/footer.jsp" %>



</body>
</html>