<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<title>Login Page</title>
<%@ include file="all_component/allcss.jsp"%>

</head>
<body>
<%@ include file="all_component/navbar.jsp"%>

	<div class="container-fluid div-color">

		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-5">

					<div class="card-header text-center text-white bg-custom">
					<i
			class="fa fa-user" aria-hidden="true"></i>
			<h4>Login</h4>
					
					</div>
					<%
					String FailMsg = (String) session.getAttribute("fail-login");
					if (FailMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=FailMsg%>

					</div>
					<%
					session.removeAttribute("fail-login");

					}
					%>
					
					
					<%
					String withoutlogin=(String)session.getAttribute("Login-error");
					if(withoutlogin!=null)
					{%>
											<div class="alert alert-danger" role="alert"><%=withoutlogin%></div>
						
					<%
					session.removeAttribute("Login-error");

					}
					%>
					
					
					<%
					String logoutmsg=(String)session.getAttribute("LogoutMsg");
					if(logoutmsg!=null)
					{%>
											<div class="alert alert-success" role="alert"><%=logoutmsg%></div>
						
					<%
					session.removeAttribute("LogoutMsg");

					}
					%>
					
						<div class="card-body mt-4">
							<form action="loginServlet" method="post">
							
							
								<div class="form-group">
															<label >Enter Email</label> 
								
									<input
										type="email" class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" name="lgemail">
									
								</div>
								<div class="form-group">
									<label >Password</label> <input
										type="password" class="form-control"
										id="exampleInputPassword1" name="lgpass">
								</div>
								
								<button type="submit" class="btn btn-primary badge-pill btn-block mb-2">Login</button>
							</form>
						</div>
				</div>
			</div>
		</div>

	</div>
	
<div class="container-fluid bg-dark">
	<p class="text-center text-white">
		Note: If any Error occurs,contact <b>RITIK GARG</b>.Designed &
		Developed by <b>RITIK GARG</b>
	</p>
	
	<p class="text-center text-white">@contact no. <b>8077849802</b></p>

</div>
	

</body>
</html>