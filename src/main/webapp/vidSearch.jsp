<%-- 
    Document   : vidSearch
    Created on : Jul 1, 2016, 7:18:33 PM
    Author     : John Krieger
--%>

<%@page import="com.mycompany.rpgtubejava.NavBar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search for Youtube videos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/style.css">
    <link href='https://fonts.googleapis.com/css?family=Quicksand' rel='stylesheet' type='text/css'>    
    </head>
    <body>
         <% NavBar navbar = new NavBar(); 
        String displayme = navbar.display(); 
        out.println(displayme); %>
        <br />
<br />
<br />
        <h1>Search for a video</h1>
        <form action="vidSearch" method="POST">
            <input type="text" name="search"></input>
            <input type="submit"></input>
    </body>
    
 
</html>