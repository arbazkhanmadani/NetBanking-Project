<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security Change</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>

<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

</head>
<body>
	<jsp:include page="AdminHeaderView.jsp"></jsp:include>
	
	<br><br><br>
<center>
<form action="SecurityQuestionChangeCtl" method="post">
Admin ID : <input id="admin" type="text" placeholder="AdminId" name="adminId"><br><br>
Password : <input type="password" placeholder="Password" name="adminpassword">

<br><br>
<input type="submit" value="Click to Verify">
<br><br>
</form>
<jsp:include page="FooterView.jsp"></jsp:include>
</center>>
</body>
</html>