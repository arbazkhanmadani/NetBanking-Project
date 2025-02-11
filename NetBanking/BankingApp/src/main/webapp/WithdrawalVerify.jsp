
<%@page import="com.arbaz.dto.AdminLoginDto"%>
<%@page import="com.arbaz.model.ConnectionProvider"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.mysql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page language="java"%>
<%@ page session="true"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Holder verification</title>
</head>
<body>
	<jsp:include page="AdminHeaderView.jsp" />
	<br>
	<center>

		<%
		String accountNumber = (String) request.getAttribute("fromaccountnumber");
		request.setAttribute("fromaccountnumber", accountNumber);
		
		Blob sign = null;
		Blob image = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String iurl1 = null;
		byte[] imagedata = null;
		byte[] signdata = null;
		PreparedStatement ps = null;
		String name = null;
		try {

			con = ConnectionProvider.getConnectivity();
			ps = con.prepareStatement("select photo,name,signature from accountholderdetails where accountnumber=?");
			ps.setString(1, accountNumber);
			/* stmt = con.createStatement();
			String query = "select photo from accountholderdetails where accountnumber=" + 'request.getParameter("fromaccountnumber") + "";
			System.out.println(query);
			 */rs = ps.executeQuery();
			while (rs.next()) {
				image = rs.getBlob("photo");
				imagedata = image.getBytes(1, (int) image.length());
				String encodeImage = Base64.getEncoder().encodeToString(imagedata);
				String pic = "data:image/jpg;base64," + encodeImage;
				name = rs.getString("name");

				sign = rs.getBlob("signature");
				signdata = sign.getBytes(1, (int) sign.length());
				String encodeSign = Base64.getEncoder().encodeToString(signdata);
				String signature = "data:image/jpg;base64," + encodeSign;
		%>
		<br>

		<table border="2">

			<tr>
			<tr>
				<td style="padding: 20px;"><img src="<%=pic%>" width="200"
					height="220" /></td>

				<td style="padding: 20px;"><img src="<%=signature%>"
					width="200" height="220" /></td>
			</tr>
			<tr>
				<td><h4 style="color: green;"><%=name%></h4></td>

				<td><h4 style="color: green;">Signature</h4></td>
			</tr>
			</tr>
		</table>

		<%
		}
		} catch (Exception e) {
		out.println("DB problem");
		e.printStackTrace();
		return;
		}
		%><br>
		<form action="WithdrawalCtl">
			<h4 style="color: green;">
				Amount <input type="number" name="amount">
			</h4>

			<a style="padding-left: 8%;"><input type="submit" value="Matches"
				style="padding: 10px; background: green; color: white; font-size: 20px; font-weight: 400;"></a>
		</form>
		<br>
		<form action="WithdrawalView.jsp">
			<br> <a class="fa fa-external-link" style="padding-left: 8%;"><input
				type="submit" value="Not Matches"
				style="padding: 10px; background: orange; color: white; font-size: 20px; font-weight: 400;"></a>
		</form>
		<br> <br>

	</center>

	<br>
	<jsp:include page="FooterView.jsp" />
</body>
</html>
