<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<title>Passbook</title>
</head>
<body>
	<jsp:include page="AdminHeaderView.jsp" />
	<center>
		<form action="PassbookPrint.jsp" method="post">
			<br> Enter accountNumber : <input type="text"
				name="accountnumber" pattern="[IBP]{3}[7]{1}[0-9]{9}"
				placeholder=" e.g. IPB7000220000"><br> <br>
				 <input style="padding: 8px; font-size: 18px;"	type="submit" value="View">
		</form>
	</center>

	<br>
	<jsp:include page="FooterView.jsp" />
</body>
</html>