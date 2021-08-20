<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
	UserDetails user1=(UserDetails)session.getAttribute("userD");
	if(user1==null)
	{
		response.sendRedirect("login.jsp");
		session.setAttribute("Login-error", "Login First...");
	}
	
	
	
	%>
	
	
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD NOTES</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>

	<%@include file="all_component/navbar.jsp"%>

	<div class="py-3">
	
	<h1 class="text-center mt-4">ADD YOUR NOTES</h1>

	
	<form action="AddNotesServlet" method="post">
	<div class="container ">
	
	<%
	 UserDetails us =(UserDetails)session.getAttribute("userD");
	if(us!=null)
	{%>
			<input type="hidden" value="<%= us.getId() %>" name="uid">
		
	<%}
	
	%>
	

		<label>Note Title</label>
		<input type="text" class="form-control"  placeholder="Enter Here" name="ptitle" required="required"</input>
		
		</div >
		<div class="container ">
		<label class="mt-4">Note Content</label>
		
				<textarea rows="8" col="" class="form-control"  placeholder="Enter Description" name="pcontent" required="required"></textarea>
				<div class="text-center"><button type="submit" class="btn btn-primary mt-3 ">Submit</button></div>
				
		
		
		
	</div>
	</form>
	</div>	
	<%@include file="all_component/footer.jsp" %>

</body>
</html>