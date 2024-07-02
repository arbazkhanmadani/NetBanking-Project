<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verify user</title>
</head>
<body>
<jsp:include page="HeaderView.jsp"/>
<br>

<center>
<h2 style="color:blue;">Verify user</h2>
<br>
<h4 style="color:red;"> ${msg}</h4>
<br>
<form action="UserLoginSecurityChangeCtl1" method="post">

	 Account Number : <input type="text" name="ac"> <br>
			<br> mPin Number : <input type="password" name="mpin"><br>
			<br>
			<input type="submit" name="Verify">
</center>
</form>
<br>
<jsp:include page="FooterView.jsp"/>
</body>
</html>