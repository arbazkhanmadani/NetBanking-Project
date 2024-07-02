<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Basic details</title>
<link
      rel="stylesheet"
      type="text/css"
      media="screen"
      href="style.css"
    />
    <script
      src="https://code.jquery.com/jquery-3.6.1.min.js"
      integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
      crossorigin="anonymous"
    ></script>

    <link
      href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
      rel="stylesheet"
    />
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
</head>
<body>
<jsp:include page="AdminHeaderView.jsp"/>
    <br>
    	
    	
    <div >
    <center>
      <h2>Document Details</h2></center>
      <form action="AccountOpeningCtl2" method="get" enctype="multipart/form-data" class="container2">
        <div>
          <label>Account Type</label>
          <select name="accounttype" id="account" required>
            <option value="saving">Saving</option>
            <option value="current">Current</option>
            <option value="termdeposit">Term Deposite</option>
            <option value="other">Other</option>
          </select>
        </div><br>
        <div>
          <label>Monthly Income</label>
          <select name="income" id="income">
            <option value="Below Rs. 5000">Below Rs. 5000</option>
            <option value="Rs. 5000-15000"> Rs. 5000-15000</option>
            <option value="Rs. 15000-50000">Rs. 15000-50000</option>
            <option value="Rs. 50000- 1 lac">Rs. 50000- 1 lac</option>
            <option value="Above Rs. 1 lac">Above Rs. 1 lac</option>            
          </select>
        </div><br>
        <div>
          <label >Occupation</label>
          <select name="occupation" id="occupation">
          <option value="Business">Bussines</option>
          <option value="Government">Government employee</option>
          <option value="Farmer">Farmer</option>
          <option value="Contractor">Student</option>
          <option value="Home maker">Student</option>
          <option value="student">Student</option>
          <option value="Other">Other</option>
        </select>
        </div><br>
        <div>
          <label>Marital Status</label>
          <select name="marriage" id="marriage">
            <option value="married">Married</option>
            <option value="unmarried">Unmarried</option>
            <option value="divorced">Divorced</option>
          </select>
        </div><br>
        <p>
          Date of birth:
          <input name="dob" type="date" id="datepicker-1" required />
        </p><br>
        <!-- Aadhar card number -->
        <div>
        <label> Aadhar Number </label>
        
          <input type="text" id="form_aadhar" name="ac" required />
          <span class="error_form" id="aadhar_error_message"></span>
        </div>
        <br/>
         <!-- PanCard number -->
        <div>
          <label> Pan Card Number </label>
          <input type="text" id="form_pancard" name="pc" required />
          <span class="error_form" id="pancard_error_message"></span>
        </div>
        <br />
        <div>
          <label>Upload Photo</label>
          <input  name="photo" type="file" id="form_image">
        </div><br>
        <div>
          <label>Upload Identity Card</label>
          <input  name="identity" type="file" id="form_image">
        </div><br>
        <div>
          <label>Upload Signature</label>
          <input  name="sign" type="file" id="form_image">
          
        </div><br>
        <div>
        
        <br> <input type="submit" value="Next"
					style="padding: 10px; font-size: 20px; background: skyblue; border-radius: 4px;"></form>
    </div>
    <br>
    <jsp:include page="FooterView.jsp"></jsp:include>
 
    <script>
            $(function () {
        $("#pancard_error_message").hide();
        $("#aadhar_error_message").hide();
        
        var form_aadhar = false;
        var form_pancard = false;
        
      
        $("#form_aadhar").focusout(function () {
          check_aadhar();
        });
        
        $("#form_pancard").focusout(function () {
          check_pancard();
        });
       
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
          var pattern = /[A-Z]{5}[0-9]{4}[A-Z]{1}$/;

          var pancard = $("#form_pancard").val();
          if (pattern.test(pancard) && pancard !== "") {
            $("#pancard_error_message").hide();
            $("#form_pancard").css("color", "green");
          } else {
            $("#pancard_error_message").html("Incorrect format");
            $("#pancard_error_message").show();
            $("#pancard_error_message").css("color", "red");
          }
        }
      });

    </script>
      </body>
</html>