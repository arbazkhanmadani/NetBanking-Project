<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdrawal Amount</title>
</head>
<body>
	<jsp:include page="AdminHeaderView.jsp" />
	<br>
	<br>

	<!-- 	<form action="WithdrawalVerify.jsp" method="post">  -->
	<form action="WithdrawalVerifyCtl" method="post">

		<%
		if (request.getAttribute("msg") != null) {
		%>

		<h3 style="text-align: center; color: brown;">
			<%=request.getAttribute("msg")%></h3>

		<%
		}
		%>
		<%
		if (request.getAttribute("invalidwithdrawal") != null) {
		%>
		<h3 style="text-align: center; color: red;">
			<%=request.getAttribute("invalidwithdrawal")%></h3>
		<%
		}
		%>
		<br>
		<center>
			From Account Number : <input type="text" id="ac"
				name="fromaccountnumber" pattern="[IBP]{3}[7]{1}[0-9]{9}"
				placeholder=" e.g. IPB7000220000"> <br> <br> <br>
			AccountHolder name : <input type="text" id="depositor"
				name="withdrawal"><br> <br> <input
				style="color: blue; padding: 5px; font-size: 20px; border: 2px solid;"
				type="submit" value="Verify Account Holder">

		</center>
	</form>

	<br>
	<br>
	<jsp:include page="FooterView.jsp" />
</body>
</html>