<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit</title>
</head>
<body>
<jsp:include page="AdminHeaderView.jsp"></jsp:include>
<br><br>

<form action="DepositCtl">
<% if(request.getAttribute("msg")!=null){
	%>
	
	<h3 style="text-align: center;color: Lightblack;"> <%=request.getAttribute("msg") %></h3>
	
<%} %><br>
<center>
Account Number : <input type="text" id="ac" name="accountnumber" pattern="[IBP]{3}[7]{1}[0-9]{9}" placeholder=" e.g. IPB7000220000"> <br><br>
Amount : <input type="number" id="amount" name="amount" min="1"> <br><br>
Depositor name : <input type="text" id="depositor" name="depositor">
<input type="submit" value="Deposit">

</center>
</form>

<br><br>
<jsp:include page="FooterView.jsp"></jsp:include>
</body>
</html>