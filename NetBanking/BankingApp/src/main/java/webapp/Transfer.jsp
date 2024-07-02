<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Page</title>
</head>
<body>
	<jsp:include page="UserLoginHeader.jsp" />
	<center>
		<br>

		<%
		String msg = request.getAttribute("msg") + "";
		%>
		<%
		if (msg.equalsIgnoreCase("Transferred successfully") && msg != null) {
		%>
		<h4 style="color: green;"><%=msg%></h4>
		<%
		}
		%>
		<%
		if (msg.equalsIgnoreCase("Transaction failed") && msg != null) {
		%>
		<h4 style="color: green;"><%=msg%></h4>
		<%
		}
		%>


		<h4 style="color: #4992DC;">Enter details of reciepent</h4>
		<br>
		<form action="UserTransferCtl" method="post">
			Account Number : <input style="" name="ac"
				pattern="[IBP]{3}[7]{1}[0-9]{9}" placeholder=" e.g. IPB7000220000">
			<br>
			<br> Amount : <input style="" name="amount"><br>
			<br> <input type="submit" value="Transfer" style="padding: 8px; font-size: 16px;">
	</center>
	</form>
	<jsp:include page="FooterView.jsp" />
</body>
</html>