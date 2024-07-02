<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>New Account Holder Registration Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      type="text/css"
      media="screen"
      href="validformStyle.css"
    />
    <script
      src="https://code.jquery.com/jquery-3.6.1.min.js"
      integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
      crossorigin="anonymous"
    ></script>

    <link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">  
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>  
    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

  </head>
  <body>
  <jsp:include page="HeaderView.jsp"></jsp:include> <br><br>
    <div class="container">
      <h1>New Account Form</h1>
      <form id="Registration_form" action="RegistrationForm.jsp" autocomplete="off" enctype="multipart/form-data" method="post">
        <div>
          <label> First Name </label>
          <input type="text" id="form_fname" name="fname" required />
          <span class="error_form" id="fname_error_message"></span>
        </div>
        <br />
        <div>
          <label> Middle Name </label>
          <input type="text" id="form_mname" name="mname" />
          <span class="error_form" id="mname_error_message"></span>
        </div>
        <br />
        <div>
          <label> Last Name </label>
          <input type="text" id="form_lname" name="lname" required />
          <span class="error_form" id="lname_error_message"></span>
        </div>
        <br />
        <!-- Email code -->
        <div>
          <label> Email Id </label>
          <input type="email" id="form_email" name="em" required />
          <span class="error_form" id="email_error_message"></span>
        </div>
        <br />
            <!-- Aadhar Card -->
        <div>
          <label> Aadhar Number </label>
          <input type="text" id="form_aadhar" name="ac" required />
          <span class="error_form" id="aadhar_error_message"></span>
        </div>
        <br />
              <!-- License Number -->
        <div>
          <label> Voter Id Number </label>
          <input type="text" id="form_votercard" name="vc" required />
          <span class="error_form" id="votercard_error_message"></span>
        </div>
        <br />
            <!-- PanCard number -->
        <div>
          <label> Pan Card Number </label>
          <input type="text" id="form_pancard" name="pc" required />
          <span class="error_form" id="pancard_error_message"></span>
        </div>
        <br />

        <!-- password code -->
        <div>
          <label> Password </label>
          <input type="password" id="form_password" name="pwd" required />
          <span class="error_form" id="password_error_message"></span>
        </div>
        <br />
        <!-- Re-enter password -->
        <div>
          <label> Retype Password </label>
          <input type="password" id="form_retype_password" name="" required />
          <span class="error_form" id="retype_password_error_message"></span>
        </div>

        
        
        <p>Date of birth: <input name="dob" type="date" id="datepicker-1" required></p>
        <div>
          <label>Upload Photo</label>
          <input  name="img" type="file" id="form_image">
          <span class="error_form" id="error_form_massage"></span>
        </div>
        <div>
         <label>Upload Signature</label>
          <input  name="sign" type="file" id="form_image">
          <span class="error_form" id="error_form_massage"></span>
        </div>
        <input id="sub" type="submit" value="Submit" />
        
        <input type="submit" value="Cancel" action="index.jsp">
      </form>
    </div>

    <script>
      $(function () {
        $("#fname_error_message").hide();
        $("#mname_error_message").hide();
        $("#lname_error_message").hide();
        $("#email_error_message").hide();
        $("#aadhar_error_message").hide();
        $("#pancard_error_message").hide();
        $("#votercard_error_message").hide();
        $("#password_error_message").hide();
        $("#retype_password_error_message").hide();
        var form_aadhar=false;
        var form_votercard=false;
        var form_pancard=false;
        var form_fname = false;
        var form_mname = false;
        var form_lname = false;
        var form_email = false;
        var form_password = false;
        var form_retype_password = false;

        $("#form_fname").focusout(function () {
          check_fname();
        });

        $("#form_mname").focusout(function () {
          check_mname();
        });

        $("#form_lname").focusout(function () {
          check_lname();
        });

        $("#form_email").focusout(function () {
          check_email();
        });
        $("#form_aadhar").focusout(function () {
          check_aadhar();
        });
        $("#form_votercard").focusout(function () {
          check_votercard();
        });
        $("#form_pancard").focusout(function () {
          check_pancard();
        });
        $("#form_password").focusout(function () {
          check_password();
        });
        $("#form_retype_password").focusout(function () {
          check_retype_password();
        });

        $(function() {  
            $( "#datepicker-1" ).datepicker();  
         });
        
        //verification of first Name
        
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
	
      //verification of middle Name
        function check_mname() {
          var pattern = /^[a-zA-Z]*$/;
          var mname = $("#form_mname").val();
         
          if (pattern.test(mname)) {
            
            $("#mname_error_message").hide();
            $("#form_mname").css("color", "green");
          } else {
            $("#mname_error_message").html("Contain only alphabets");
            $("#mname_error_message").show();
            $("#mname_error_message").css("color", "red");
          }
        }

      //verification of last Name
        function check_lname() {
          var pattern = /^[a-zA-Z]*$/;
          var lname = $("#form_lname").val();
          if (pattern.test(lname) && lname !== "") {
            $("#lname_error_message").hide();
            $("#form_lname").css("color", "green");
          } else {
            $("#lname_error_message").html("Contain only alphabets");
            $("#lname_error_message").show();
            $("#lname_error_message").css("color", "red");
          }
        }
		
      //verification of email id
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

        // Verification code for aadhar number

        function check_aadhar() {
          var pattern = /^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$/;

          var aadhar = $("#form_aadhar").val();
          if (pattern.test(aadhar) && aadhar !== "") {
            $("#aadhar_error_message").hide();
            $("#form_aadhar").css("color", "green");
          } else {
            $("#aadhar_error_message").html("Incorrect format");
            $("#aadhar_error_message").show();
            $("#aadhar_error_message").css("color", "red");
          }
        }
          // Verification code for pancard number

        function check_pancard() {
          var pattern = /[A-Z-a-z]{5}[0-9]{4}[A-Z-a-z]{1}$/;

          var pancard= $("#form_pancard").val();
          if (pattern.test(pancard) && pancard !== "") {
            $("#pancard_error_message").hide();
            $("#form_pancard").css("color", "green");
          } else {
            $("#pancard_error_message").html("Incorrect format");
            $("#pancard_error_message").show();
            $("#pancard_error_message").css("color", "red");
          }
        }

        // Verification code for votercard

        function check_votercard() {
          var pattern = /^([A-Z-a-z]{3}[0-9]{7})$/;

          var votercard= $("#form_votercard").val();
          if (pattern.test(votercard) && votercard !== "") {
            $("#votercard_error_message").hide();
            $("#form_votercard").css("color", "green");
          } else {
            $("#votercard_error_message").html("Incorrect format");
            $("#votercard_error_message").show();
            $("#votercard_error_message").css("color", "red");
          }
        }


          // Password validation code
        function check_password() {
          var pwdlength = $("#form_password").val().length;
          if (pwdlength >= 8) {
            $("#password_error_message").hide();
            $("#password_error_message").css("color", "green");
            form_password = true;
          } else {
            $("#password_error_message").html(
              "Password should contain atleast 8 character"
            );
            $("#password_error_message").show();
            $("#form_password").css("color", "red");
            $("#password_error_message").focousout();
            $("#form_password").css("color", "");
          }
        }

        function check_retype_password() {
          var password = $("#form_password").val();
          var Retypepassword = $("#form_retype_password").val();
          if (password === Retypepassword) {
            $("#retype_password_error_message").html("Password match");
            $("#retype_password_error_message").show();
            $("#form_retype_password").css("color", "green");
            form_retype_password = true;
          } else {
            $("#retype_password_error_message").html("Password not match");
            $("#retype_password_error_message").show();
            $("#retype_password_error_message").css("color", "red");
          }
        }
      });

      var fname = $("#form_fname").val();
      document.write(fname);
    </script>
    <jsp:include page="FooterView.jsp"></jsp:include>
  </body>

</html>