<%-- 
    Document   : index.jsp
    Created on : Jul 19, 2016, 5:55:03 PM
    Author     : PADEN
--%>
<%@page import="com.mycompany.rpgtubejava.NavBar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<title>RPGTube HOME</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="rpgstyle.css">
    </head>

    <body>
        <% out.print(NavBar.display()); %>
	
        <div style="margin-top: 60px">
	    <ul>
		<li><a href="">Links</a>
	    </ul>
	</div>
    </body>
</html>
