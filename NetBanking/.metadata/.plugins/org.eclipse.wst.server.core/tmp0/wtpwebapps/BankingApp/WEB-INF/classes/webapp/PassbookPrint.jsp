<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.arbaz.model.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction records</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="AdminHeaderView.jsp" />
	<br>
	<center>
		<table class="table table-hover" style="padding: 15px;">
			<thead>
				<th>Transaction date</th>
				<th>Widthdrawal</th>
				<th>Deposit</th>
				<th>Transaction id</th>
				<th>Recieved From</th>
				<th>Send To</th>
				
			</thead>
			<tbody>
				<%
				String accountnumber = request.getParameter("accountnumber");

				Connection con = ConnectionProvider.getConnectivity();
				PreparedStatement ps = null;
				try {
					ps = con.prepareStatement("select * from transactionhistory where accountnumber=?");
					ps.setString(1, accountnumber);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
				%>
				<tr>
					<td><%=rs.getString("transactiondate")%></td>
					<td><%=rs.getDouble("transferamount")%></td>
					<td><%=rs.getDouble("Recieveamount")%></td>
					<td><%=rs.getString("transactionid")%></td>
					<td><%=rs.getString("recievedfrom")%></td>
					<td><%=rs.getString("sendto")%></td>
				</tr>
			
			<%
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			%>

			<%
			String balance="Current Balance :"; 
			ps=null;
			try{
				ps=con.prepareStatement("select balance from accountbalance where accountnumber=?");
				ps.setString(1, accountnumber);
				ResultSet r= ps.executeQuery();
				while(r.next()){
				%>
				<tr>
				<h3>Balance</h3>
				<td><p style="color:green; font-size: 20px;"/> <%=balance %> <%= "Rs. "+ r.getDouble("balance") %></td>
				</tr>
				</tbody>
				<%}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			%>
		</table>
	</center>
	<br>
	<jsp:include page="FooterView.jsp" />
</body>
</html>