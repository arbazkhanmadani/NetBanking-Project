<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Favorite Box</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="UserLoginHeader.jsp" />

	<form method="post" action="">
		<div class="form-group">
			<label for="exampleInputEmail1">Account Number</label> <input
				type="email" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Enter account number">
			<small id="emailHelp" class="form-text text-muted">We'll
				never share your account number with anyone else.</small>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Account Holder Name</label> <input
				type="password" class="form-control" id="exampleInputPassword1"
				placeholder="Enter account holder name">
		</div>
		<!-- <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div> -->
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

	<jsp:include page="FooterView.jsp" />
</body>
</html>