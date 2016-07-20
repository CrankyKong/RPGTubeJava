<%-- 
    Document   : profile
    Created on : Jul 19, 2016, 4:32:33 PM
    Author     : Logan
--%>

<%@page import="com.mycompany.rpgtubejava.Avatar"%>
<%@page import="com.mycompany.rpgtubejava.DatabaseHandler"%>
<%@page import="com.mycompany.rpgtubejava.NavBar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
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
        <div class="container">
  <h2>Profile</h2>
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#character">Character</a></li>
    <li><a data-toggle="tab" href="#inventory">Inventory</a></li>
    <li><a data-toggle="tab" href="#friends">Friends</a></li>
    <li><a data-toggle="tab" href="#accountInfo">Account Info</a></li>
  </ul>

  <div class="tab-content">
    <div id="character" class="tab-pane fade in active">
      <h3>Character</h3>
      <% DatabaseHandler db = new DatabaseHandler();
      Avatar avatar = new Avatar();
      avatar = db.getAvatar(18);
      out.println("name: " + avatar.getName());
      out.println("Level: " + avatar.getLevel());
      out.println("Exp: " + avatar.getExperience());
      
      
      
      %>

    </div>
    <div id="inventory" class="tab-pane fade">
	  <h3>Inventory</h3>

    </div>
    <div id="friends" class="tab-pane fade">
      <h3>Friends</h3>

    </div>
    <div id="accountInfo" class="tab-pane fade">
      <h3>Account Info</h3>
      <p>hi there! This tab will have more account info in the future!</p>
    </div>
  </div>
</div>
    </body>
</html>