<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submission</title>
<link rel='stylesheet' type='text/css' media='screen' href='style.css'>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>

<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet" />
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

</head>
<body>
	<jsp:include page="AdminHeaderView.jsp"/>
	<br>
	<br>
	<div class="container3">
		<form action="AccountOpeningCtl3" method="get" enctype="multipart/form-data">
			<div>
				<h3>
					<label><h4>Facilities</h4></label><br>
				</h3>
				<div>
				<label>Debit card</label><br>
				<select name="debitcard">
				<option value="No">No</option>
				<option value="Yes">Yes</option>
				</select>
				</div>

				<br>
				<div>
				<label>Internet banking</label><br>
				<select name="netbanking">
				<option value="No">No</option>
				<option value="Yes">Yes</option>
				</select>
				</div>
				<br>
				<div>
				<label>Credit card</label><br>
				<select name="creditcard">
				<option value="No">No</option>
				<option value="Yes">Yes</option>
				</select>
				</div>
				<br>
				<div>
				<label>Cheque</label><br>
				<select name="cheque">
				<option value="No">No</option>
				<option value="Yes">Yes</option>
				</select>
				</div>
			</div><br>
			<div>
				<hr>
				<h4 style="color: green;">Terms and Conditions</h4>
				<hr>
				<br>

				<h3>
					By completing this account registration form, you agree to the
					terms and conditions that govern your account and your relationship
					with the bank. <br> Please check the box below to confirm
					agreement before sending the bank account registration information.
				</h3>
				<br>
				<h3 style="color: rgb(17, 17, 238);">
					<input type="checkbox" name="agree"> I agree to the terms
					of service.
				</h3>
			</div>
			<center>
				<H2>
					<input type="submit" value="REGISTER"
						style="padding: 10px; background: rgb(159, 159, 223); border-radius: 3px; font-weight: 400;">
			</center>
			</H2>
		</form>
	</div>
	<br>
	<jsp:include page="FooterView.jsp"></jsp:include>

	<%
	session.setAttribute("debitcard", ("debitcard"));
	session.setAttribute("netbanking", ("netbanking"));
	session.setAttribute("creditcard", ("creditcard"));
	session.setAttribute("cheque", ("cheque"));
	session.setAttribute("agree", ("agree"));
	%>
	
</body>
</html>