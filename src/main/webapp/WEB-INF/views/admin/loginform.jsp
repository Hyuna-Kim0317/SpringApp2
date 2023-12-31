<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}
</style>
<%@ include file="./inc/head_link.jsp" %>
<script type="text/javascript">
function loginCheck(){
	$("form").attr({
		action:"/admin/login",
		method:"post"
	});
	$("form").submit();
}
$(function(){
	$("#bt_login").click(function(){
		loginCheck();
	});	
	$("#bt_cancel").click(function(){
		location.href="/gallery/list";
	});	
});
</script>
<body>

<form  style="border:1px solid #ccc">
  <div class="container">
    <h1>Login</h1>
    <p>Enter your information</p>
    <hr>


    <input type="text" placeholder="Enter ID" name="id" required>
    <input type="password" placeholder="Enter Password" name="pass" required>

    <div class="clearfix">
      <button type="button" class="cancelbtn" id="bt_cancel">Cancel</button>
      <button type="button" class="signupbtn" value="Login" id="bt_login">Login</button>
    </div>
  </div>
</form>

</body>
</html>
