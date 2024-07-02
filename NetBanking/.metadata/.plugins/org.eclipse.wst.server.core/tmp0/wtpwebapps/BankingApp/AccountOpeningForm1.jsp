<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Opening Form</title>
<link rel="stylesheet" type="text/css" media="screen" href="style.css" />
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
	<jsp:include page="AdminHeaderView.jsp"/>
	<div>
		<div class="container1">
			<h1>Registration Form</h1>

			<form id="Registration_form" action="AccountOpeningCtl1"
				autocomplete="off" enctype="multipart/form-data" method="get">
				<div>
					<label> First Name </label> <input type="text" id="form_fname"
						name="fname" required /> <span class="error_form"
						id="fname_error_message"></span>
				</div>
				<br />
				<div>
					<label> Middle Name </label> <input type="text" id="form_mname"
						name="mname" /> <span class="error_form" id="mname_error_message"></span>
				</div>
				<br />
				<div>
					<label> Last Name </label> <input type="text" id="form_lname"
						name="lname" required /> <span class="error_form"
						id="lname_error_message"></span>
				</div>
				<br />

				<div>
					<label> Guardian Name </label> <input type="text" id="form_gname"
						name="gname" required /> <span class="error_form"
						id="gname_error_message"></span>
				</div>
				<br>
				<!-- Gender -->
				<div>
					<label>Gender</label> <select name="gender" required>
						<option>Male</option>>
						<option>Female</option>>
						<option>Other</option>>

					</select>

				</div>
				<br />

				<!-- Age range -->
				<div>
					<label>How Old Are you?</label> <select name="age" required>
						<option>17-60 years</option>
						<option>17 years or younger</option>
						<option>60 years or older</option>
					</select>

				</div>
				<br />

				<!-- mobile number -->
				<div>
					<label>Mobile Number</label> <input type="number" id="form_mobile"
						name="mobile" required /> <span class="error_form"
						id="mobile_error_message"></span>
				</div>
				<br />
				<!-- Email code -->
				<div>
					<label> Email Id </label> <input type="email" id="form_email"
						name="email" required /> <span class="error_form"
						id="email_error_message"></span>
				</div>
				<br />

				<div>
					<label>Country</label> <select name="country">
						<option>India</option>
					</select> <br /> <br /> State <select name="state" id="state_form"
						required>
						<option value="Andhra Pradesh">Andhra Pradesh</option>
						<option value="Andaman and Nicobar Islands">Andaman and
							Nicobar Islands</option>
						<option value="Arunachal Pradesh">Arunachal Pradesh</option>
						<option value="Assam">Assam</option>
						<option value="Bihar">Bihar</option>
						<option value="Chandigarh">Chandigarh</option>
						<option value="Chhattisgarh">Chhattisgarh</option>
						<option value="Dadar and Nagar Haveli">Dadar and Nagar
							Haveli</option>
						<option value="Daman and Diu">Daman and Diu</option>
						<option value="Delhi">Delhi</option>
						<option value="Lakshadweep">Lakshadweep</option>
						<option value="Puducherry">Puducherry</option>
						<option value="Goa">Goa</option>
						<option value="Gujarat">Gujarat</option>
						<option value="Haryana">Haryana</option>
						<option value="Himachal Pradesh">Himachal Pradesh</option>
						<option value="Jammu and Kashmir">Jammu and Kashmir</option>
						<option value="Jharkhand">Jharkhand</option>
						<option value="Karnataka">Karnataka</option>
						<option value="Kerala">Kerala</option>
						<option value="Madhya Pradesh">Madhya Pradesh</option>
						<option value="Maharashtra">Maharashtra</option>
						<option value="Manipur">Manipur</option>
						<option value="Meghalaya">Meghalaya</option>
						<option value="Mizoram">Mizoram</option>
						<option value="Nagaland">Nagaland</option>
						<option value="Odisha">Odisha</option>
						<option value="Punjab">Punjab</option>
						<option value="Rajasthan">Rajasthan</option>
						<option value="Sikkim">Sikkim</option>
						<option value="Tamil Nadu">Tamil Nadu</option>
						<option value="Telangana">Telangana</option>
						<option value="Tripura">Tripura</option>
						<option value="Uttar Pradesh">Uttar Pradesh</option>
						<option value="Uttarakhand">Uttarakhand</option>
						<option value="West Bengal">West Bengal</option>
					</select>
				</div>
				<br />
				<!-- city -->
				<div>
					<label>City</label> <input type="text" id="form_city" name="city"
						required /> <span class="error_form" id="city_error_message"></span>
				</div>
				<br>
				<!-- Street name -->
				<div>
					<label>Street Name</label> <input type="text" id="form_street"
						name="street" required /> <span class="error_form"
						id="street_error_message"></span>
				</div>
				<br>

				<!-- pincode number -->
				<div>
					<label>Pincode Number</label> <input type="number"
						id="form_pincode" name="pincode" required /> <span
						class="error_form" id="pincode_error_message"></span>
				</div>
				<br /> <input id="sub" type="submit" value="Submit" />

			</form>

		</div>

		
		<script>
			$(function() {
				$("#fname_error_message").hide();
				$("#mname_error_message").hide();
				$("#lname_error_message").hide();
				$("#fname_error_message").hide();
				$("#email_error_message").hide();
				$("#mobile_error_message").hide();
				$("#city_error_message").hide();
				$("#street_error_message").hide();
				$("#pincode_error_message").hide();

				var form_pincode = false;
				var form_fname = false;
				var form_mname = false;
				var form_lname = false;
				var form_gname = false;
				var form_email = false;
				var form_mobile = false;
				var form_city = false;
				var form_street = false;

				$("#form_fname").focusout(function() {
					check_fname();
				});

				$("#form_mname").focusout(function() {
					check_mname();
				});

				$("#form_lname").focusout(function() {
					check_lname();
				});

				$("#form_gname").focusout(function() {
					check_gname();
				});
				$("#form_mobile").focusout(function() {
					check_mobile();
				});

				$("#form_pincode").focusout(function() {
					check_pincode();
				});

				$("#form_email").focusout(function() {
					check_email();
				});

				$("#form_city").focusout(function() {
					check_city();
				});

				$("#form_street").focusout(function() {
					check_street();
				});

				$(function() {
					$("#datepicker-1").datepicker();
				});

				// Verification code to check valid first name
				function check_fname() {
					var pattern = /^[a-zA-Z]*$/;
					var fname = $("#form_fname").val();
					
					if (pattern.test(fname) && fname !== "" ) {
						$("#fname_error_message").hide();
						$("#form_fname").css("color", "green");
					} else {
						$("#fname_error_message")
								.html("Contain only alphabets");
						$("#fname_error_message").show();
						$("#fname_error_message").css("color", "red");
					}
				}
				// Verification code to check valid middle name
				function check_mname() {
					var pattern = /^[a-zA-Z]*$/;
					var mname = $("#form_mname").val();

					if (pattern.test(mname)) {
						$("#mname_error_message").hide();
						$("#form_mname").css("color", "green");
					} else {
						$("#mname_error_message")
								.html("Contain only alphabets");
						$("#mname_error_message").show();
						$("#mname_error_message").css("color", "red");
					}
				}
				// Verification code to check valid last name
				function check_lname() {
					var pattern = /^[a-zA-Z]*$/;
					var lname = $("#form_lname").val();
					if (pattern.test(lname) && lname !== "") {
						$("#lname_error_message").hide();
						$("#form_lname").css("color", "green");
					} else {
						$("#lname_error_message")
								.html("Contain only alphabets");
						$("#lname_error_message").show();
						$("#lname_error_message").css("color", "red");
					}
				}

				//Verification form guardian name
				function check_gname() {
					var pattern = /^[a-zA-Z ]*$/;
					var gname = $("#form_gname").val();
					if (pattern.test(gname) && gname !== "") {
						$("#gname_error_message").hide();
						$("#form_gname").css("color", "green");
					} else {
						$("#gname_error_message")
								.html("Contain only alphabets");
						$("#gname_error_message").show();
						$("#gname_error_message").css("color", "red");
					}
				}
				// Verification code to check valid email id
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

				// Verification code for mobile number
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

				// Verification code for city

				function check_city() {
					var pattern = /^[a-zA-Z]*$/;
					var city = $("#form_lname").val();
					if (pattern.test(city) && city !== "") {
						$("#city_error_message").hide();
						$("#form_city").css("color", "green");
					} else {
						$("#city_error_message").html(
								"Contain only single name");
						$("#city_error_message").show();
						$("#city_error_message").css("color", "red");
					}
				}

				// Verification code for city

				function check_street() {
					var pattern = /^[a-zA-Z ]*$/;
					var street = $("#form_street").val();
					if (pattern.test(street) && street !== "") {
						$("#street_error_message").hide();
						$("#form_street").css("color", "green");
					} else {
						$("#street_error_message").html(
								"Contain only single name");
						$("#street_error_message").show();
						$("#street_error_message").css("color", "red");
					}
				}

				function check_pincode() {
					var pattern = /^[1-9]{1}[0-9]{5}$/;

					var pincode = $("#form_pincode").val();
					if (pattern.test(pincode) && pincode !== "") {
						$("#pincode_error_message").hide();
						$("#form_pincode").css("color", "green");
					} else {
						$("#pincode_error_message")
								.html(
										"Incorrect format must contain six digits and does not starts with");
						$("#pincode_error_message").show();
						$("#pincode_error_message").css("color", "red");
					}
				}

			});

			var fname = $("#form_fname").val();
			document.write(fname);
		</script>
	</div>
	<jsp:include page="FooterView.jsp"></jsp:include>

</body>
</html>