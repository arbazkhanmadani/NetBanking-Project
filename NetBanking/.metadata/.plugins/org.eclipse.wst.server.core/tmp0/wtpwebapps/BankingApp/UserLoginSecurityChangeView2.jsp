<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security Question Change</title>
</head>
<body>
	<jsp:include page="UserLoginHeader.jsp" />
	<br>
	<center>
	<% String msg=(String) request.getAttribute("msg");
	
	if(msg!=null){
	%> <h4 style="color:green;"><%=msg %></h4>
	<%} %>
	<form action="UserLoginSecurityChangeCtl2" method="post">
		<br> <label> Security Question : </label> <select name="question">

			<option type="text" value="What is your mother's maiden name?">What
				is your mother's maiden name?</option>
			<option type="text" value="What is the name of your first pet?">What
				is the name of your first pet?</option>
			<option type="text" value="What was your first car?">What
				was your first car?</option>
			<option type="text" value="What elementary school did you attend?">What
				elementary school did you attend?</option>
			<option type="text"
				value="What is the name of the town where you were born?">What
				is the name of the town where you were born?</option>
			<option type="text" value="Who was your childhood hero?">Who
				was your childhood hero?</option>
		</select> <br> <br> Answer : <input type="text" name="answer">
		<br> <br>
		<button>
			<input type="submit" value="Login"
				style="padding: 8px; background-color: lightblue;">
		</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</form>
	<br>
	</center>
	<jsp:include page="FooterView.jsp" />
</body>
</html>