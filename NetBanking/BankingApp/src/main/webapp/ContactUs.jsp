<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us</title>
<link rel="stylesheet" type="text/css" media="screen" href="contact.css" />
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
	<jsp:include page="HeaderView.jsp"></jsp:include>
	<br>
	<br>
	<center>
		<div class="messagebox">
			<%
			if (session.getAttribute("success") != null) {
				String msg = (String) session.getAttribute("success");
				session.removeAttribute("success");
			%>
			<h4 style="color: green;"><%=msg%></h4>
			<%
			}
			%>
		</div>
	</center>
	<br>
	<section class="footer_get_touch_outer">
		<div class="container">
			<div class="footer_get_touch_inner grid-70-30">
				<div class="colmun-70 get_form">
					<div class="get_form_inner">
						<div class="get_form_inner_text">
							<h3>Get In Touch</h3>
						</div>
						<form action="ContactCtl">
							<div class="grid-50-50">
								<input type="text" placeholder="First Name" name="fname"
									id="form_fname" required="required"> <span
									class="error_form" id="fname_error_message"></span> <input
									type="text" placeholder="Last Name" name="lname"
									id="form_lname" required="required"> <span
									class="error_form" id="lname_error_message"></span> <input
									type="email" placeholder="Email" name="email" id="form_email"
									required="required"> <span class="error_form"
									id="email_error_message"></span> <input type="number"
									placeholder="Phone" name="mobile" id="form_mobile" required>
								<span class="error_form" id="mobile_error_message"></span>
							</div>
							<div class="grid-full">
								<textarea placeholder="Your suggestion and query" cols="30"
									rows="10" name="message" id="form_message" required="required"></textarea>
								<span class="error_form" id="message_error_message"></span> <input
									type="submit" value="Submit">
							</div>
						</form>
					</div>
				</div>
				<div class="colmun-30 get_say_form">
					<h5>Contact Us</h5>
					<ul class="get_say_info_sec">
						<li><i class="fa fa-envelope"></i> <a href="mailto:">info@payall.com</a>
						</li>
						<li><i class="fa fa-whatsapp"></i> <a href="tel:">+91
								7047 920 360</a></li>
						<li><i class="fa fa-whatsapp"></i> <a href="tel:">+91
								7067 012 123</a></li>
						<li><i class="fa fa-skype"></i> <a href="#">Twitter</a></li>
						<li><i class="fa fa-skype"></i> <a href="#">WhatApp</a></li>
					</ul>
					<ul class="get_say_social-icn">
						<li><a href="#"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#"><i class="fa fa-instagram"></i></a></li>
						<li><a href="#"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>

	<jsp:include page="FooterView.jsp"></jsp:include>

	<script>
		$(function() {
			$("#fname_error_message").hide();
			$("#lname_error_message").hide();
			$("#email_error_message").hide();
			$("#mobile_error_message").hide();
			$("#message_error_message").hide();

			var form_fname = false;
			var form_lname = false;
			var form_email = false;
			var form_mobile = false;
			var form_message = false;

			$("#form_fname").focusout(function() {
				check_fname();
			});

			$("#form_lname").focusout(function() {
				check_lname();
			});

			$("#form_email").focusout(function() {
				check_email();
			});

			$("#form_mobile").focusout(function() {
				check_mobile();
			});

			$("#form_message").focusout(function() {
				check_message();
			});

			function check_fname() {
				var pattern = /^[a-zA-Z]*$/;
				var fname = $("#form_fname").val();
				if (pattern.test(fname) && fname !== "") {
					$("#fname_error_message").hide();
					$("#form_fname").css("color", "green");
				} else {
					$("#fname_error_message").html("Contain only alphabets");
					$("#fname_error_message").show();
					$("#fname_error_message").css("color", "red");
				}
			}

			function check_lname() {
				var pattern = /^[a-zA-Z]*$/;
				var lname = $("#form_lname").val();

				if (pattern.test(lname) && lname !== "" && lname != null) {
					$("#lname_error_message").hide();
					$("#form_lname").css("color", "green");
				} else {
					$("#lname_error_message").html("Contain only alphabets");
					$("#lname_error_message").show();
					$("#lname_error_message").css("color", "red");
				}
			}

			function check_email() {
				var pattern = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;

				var emailid = $("#form_email").val();
				if (pattern.test(emailid) && emailid !== "") {
					$("#email_error_message").hide();
					$("#form_email").css("color", "green");
				} else {
					$("#email_error_message").html("Incorrect format");
					$("#email_error_message").show();
					$("#email_error_message").css("color", "red");
				}
			}

			function check_mobile() {
				var pattern = /^[6-9]{1}[0-9]{9}$/;
				var mobile = $("#form_mobile").val();
				if (pattern.test(mobile) && mobile !== "") {
					$("#mobile_error_message").hide();
					$("#form_mobile").css("color", "green");
				} else {
					$("#mobile_error_message").html("Incorrect format");
					$("#mobile_error_message").show();
					$("#mobile_error_message").css("color", "red");
				}
			}

			function check_message() {
				var pattern = /^[a-zA-Z-0-9 ]$/;

				var message = $("#form_message").val();
				var mlength = message.length;

				if (pattern.test(message) && message !== "" && mlength < 30) {
					$("#message_error_message").hide();
					$("#form_message").css("color", "green");
				} else {
					$("#message_error_message").html(
							"Message should contain more then 30 alphabets");
					$("#message_error_message").show();
					$("#message_error_message").css("color", "red");
				}
			}
		});
	</script>
</body>
</html>