<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security Question page</title>
</head>
<body>
<jsp:include page="HeaderView.jsp"></jsp:include>
<br><br><br>
<form action="AdminQuestionUpdate" method="post">
<center>
	Admin ID : <input type="text" placeholder="AdminId" name="adminId"><br><br>
	<label><b>Security Question : </b> </label>
	<select name="securityquestion">
		<option values="What is your nickname?">What is your
			nickname?</option>
		<option values="Where was you born?">Where was you born?</option>
		<option values="Your favourite teacher name?">Your favourite
			teacher name?</option>
		<option values="What was your favourite subject?">What was
			your favourite subject?</option>
	</select>
	<br>
	<br>
	<label><b>Security Answer : </b> </label>
	<input type="text" name="securityanswer" id="Uname"
		placeholder="type security answer">
	<br>
	<br>
	<input type="submit" name="log" id="log" value="Submit">
	<br>
	<br>
	<br>
</center>
</form>
<jsp:include page="FooterView.jsp"></jsp:include>
</body>
</html>