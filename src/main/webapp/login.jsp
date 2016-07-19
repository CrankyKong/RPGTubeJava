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
	    Username: <input type="text" name="username" value="test"><br/>
	    Password: <input type="password" name="password" value="test"><br/>
	    <button type="submit">Log In</button>
	</form>
    </body>
</html>
