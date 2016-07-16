<%-- 
    Document   : homepage
    Created on : Jul 10, 2016, 5:14:23 PM
    Author     : Logan
--%>

<%@page import="com.mycompany.rpgtubejava.NavBar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
    <title>RPGTUBE HOME</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="rpgstyle.css">
</head>

    <body>
        <% NavBar navbar = new NavBar(); 
        String displayme = navbar.display(); 
        out.println(displayme); %>
        <br>
        <br>
        <br>
        <br>
        <h1>Hello World!</h1>
    </body>
</html>
