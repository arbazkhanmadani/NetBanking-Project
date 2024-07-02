<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login Page</title>
<link rel="stylesheet" type="text/css" media="screen" href="style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

</head>
<body>
	<jsp:include page="HeaderView.jsp"/>
	<br>

	<center>
	<% String msg=(String)request.getAttribute("error");
		 if(msg!=null){
		 %>
		<h5 style="color:red;"><%=msg %></h5>
		<%
		} 
		%>  
		<h2>Admin Login Page</h2>
		<br> <br>

		<div class="adminlogin">
			<form id="login" method="post" action="AdminLoginCtl"
				autocomplete="off">
				<label><b>Admin Id : </b> </label> <input type="text" name="uid"
					id="Uname" placeholder="admin id" required="required"> <br> <br> <label><b>Password
						: </b> </label> <input type="Password" name="pwd" id="Pass"
					placeholder="Password" required="required"> <br> <br> <label><b>Security
						Question : </b> </label> <select name="securityquestion">
					<option values="What is your nickname?">What is your
						nickname?</option>
					<option values="Where was you born?">Where was you born?</option>
					<option values="Your favourite teacher name?">Your
						favourite teacher name?</option>
					<option values="What was your favourite subject?">What was
						your favourite subject?</option>
				</select> <br> <br> <label><b>Security Answer : </b> </label> <input
					type="text" name="securityanswer" id="Uname"
					placeholder="type security answer"> <br> <br> <input
					type="submit" name="log" id="log" value="Log In Here" required="required"> <br>
			</form>

			<form action="AdminSecurityChange.jsp" method="post">
				<br> <br> <label><b>Change Security Question :
				</b> </label> <input type="submit" value="Change Security">
			</form>
		</div>
	</center>
	<jsp:include page="FooterView.jsp"></jsp:include>
</body>
</html>