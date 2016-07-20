<%-- 
    Document   : login
    Created on : Jul 19, 2016, 4:03:11 PM
    Author     : PADEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RPGTube Log In</title>
    </head>
    <body>
	<h3>RPGTube Log In</h3>
        <form action="ValidateLogin" method="POST">
	    Username: <input type="text" name="username" value="pdawg"><br/>
	    Password: <input type="password" name="password" value="abc"><br/>
	    <button type="submit">Log In</button>
	</form>
        <a href="signup.jsp">Not registered? Sign Up Here</a><br/>
    </body>
</html>