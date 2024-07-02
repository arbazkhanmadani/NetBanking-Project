<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logined in Successfully</title>
 <link
      rel="stylesheet"
      type="text/css"
      media="screen"
      href="style.css"
    />
</head>
<body>
<jsp:include page="AdminHeaderView.jsp"></jsp:include>
 <br><br>
 <% if(request.getAttribute("msg")!=null){
	 String msg= (String)request.getAttribute("msg");
	 %>
<center>
	 <h3 style="color:green;"> <%= msg%></h3>
	 </center>
	 <%
	 session.removeAttribute("msg");
 } %>
 <br>
 <center>
 <div class="adminview">
<a href="DepositView.jsp">  <button style="padding:15px; font-size: 20px;">Deposit</button> </a>
<a href="WithdrawalView.jsp"> <button style="padding:15px; font-size: 20px;">Withdrawal</button></a>
<a href="AccountOpeningForm1.jsp"><button style="padding:15px; font-size: 20px;">Open New Account</button></a>

<a href="LoanAccountView.jsp"><button style="padding:15px; font-size: 20px;">Loan</button></a>
</div>
</center>
<br>
<jsp:include page="FooterView.jsp"></jsp:include>
</body>
</html>