<%--
    Document   : signup
    Created on : Jul 11, 2016, 10:30:39 PM
    Author     : Logan
--%>
<%@page import="com.mycompany.rpgtubejava.NavBar"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" lang="en" />
    <title>RPGTube Sign-up</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/style.css">
	<link href='https://fonts.googleapis.com/css?family=Quicksand' rel='stylesheet' type='text/css'>    
	<script type="text/javascript">
	    window.onload = function() {
		document.getElementById("password").onchange = validatePassword;
		document.getElementById("pass-confirm").onchange = validatePassword;
	    }
	    
	    function validatePassword() {
		var firstPass = document.getElementById('password');
		var secondPass = document.getElementById('pass-confirm');
		if (secondPass.value !== firstPass.value) {
		    secondPass.setCustomValidity("Passwords Don't Match");
		    return false;
		} else {
		    secondPass.setCustomValidity("");
		    return true;
		}
	    }
	</script>
    </head>
    
    <body>
	<% NavBar.display(); %>

	<div class="app-wrapper form-screen" id="sign-up">
	    <h1>Create your Username, Character Name, and Password!</h1>
	<div>
	    <form id="signup-form" onsubmit="return validatePassword()" action="addUser" method="post">
		<input type="text" id="name" name="user" placeholder="Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'" required>
		<br>
		<input type="text" id="email" name="avatar" placeholder="Character Name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Character Name'" required>
		<br>
		<input type="password" id="password" name="password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'" required>
		<br>
		<input type="password" id="pass-confirm" placeholder="Confirm Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Confirm Password'" required>
		<br>
		<button class="login-button" type="submit" name="button">Sign Up</button>
	    </form>
	</div>
    </body>
</html>