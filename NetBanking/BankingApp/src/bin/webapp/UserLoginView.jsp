<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Page</title>
</head>
<body>

	<jsp:include page="HeaderView.jsp" />

	<center>
		<br>
		<%
		String userid = (String) session.getAttribute("userid");
		%>
		<%
		if (userid != null) {
		%>
		<h4 style="margin-left: 8%; color: #4992DC;"><%=userid%></h4>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<h5>
			<%=LocalTime.now()%></h5>
		<%
		}
		%>
		<%
		String msg = (String) request.getAttribute("loginfail");
		if (msg != null) {
		%>
		<h4 style="color: red;"><%=msg%></h4>
		<%
		}
		%>

		<%
		String msg1 = (String) request.getAttribute("msg");

		if (msg != null) {
		%>

		<h4 style="color: brown;"><%=msg%></h4>
		<%
		}
		%>

		<form action="UserLoginCtl" method="post">
			<br> Account Number : <input type="text" name="ac"
				required="required"> <br> <br> mPin Number : <input
				type="password" name="mpin" required="required"><br> <br>
			<label> Security Question : </label> <select name="question">

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
			</select> <br> <br> Answer : <input type="text" name="answer"
				required="required"><br> <br>
			<button>
				<input type="submit" value="Login"
					style="padding: 8px; background-color: lightblue;">
			</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</form>
		<a href="UserLoginSecurityChangeView1.jsp"><button>
				<input type="submit" value="Change Secourity Question"
					style="padding: 8px; background-color: lightblue;">
			</button></a><br> <br>
		<h4 style="color: orange;">
			If New User, set up security question &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="UserLoginSecurityChangeView1.jsp"><button>
					<input type="submit" value="Update Security question"
						style="padding: 8px; background-color: lightblue;">
				</button></a>
		</h4>

	</center>

	<jsp:include page="FooterView.jsp"></jsp:include>
</body>
</html>