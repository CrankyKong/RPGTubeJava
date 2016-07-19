package com.mycompany.rpgtubejava;


import static java.lang.System.out;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Logan
 */
public class NavBar {
    
    String navbar;
    public NavBar(){
        navbar = "";
    }


    public String display(){

    navbar += "<nav class='navbar navbar-default navbar-fixed-top'>";
    navbar += "<div class='container-fluid'>";
    navbar += "<div class='navbar-header'>";
    navbar += "<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#myNavbar'>";
    navbar += " <span class='icon-bar'></span>";
    navbar += " <span class='icon-bar'></span><span class='icon-bar'></span></button>"
            + "<a class='navbar-brand' href='homepage.jsp'>RPGTUBE</a></div>"
            + "<div class='collapse navbar-collapse' id='myNavbar'>"
            + "<ul class='nav navbar-nav navbar-right'>"
            + "<li><a href='homepage.jsp'>HOME</a></li>"
            + "<li><a href='comingsoon.jsp'>ABOUT RPGTUBE</a></li>"
            + " <li><a href='vidSearch.jsp'>VIDEOS</a></li>'";
       		
//		//Profile for session
//		if($_SESSION['user_id'] != 0){
//		echo '<li class="dropdown">
//          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Profile
//          <span class="caret"></span></a>
//          <ul class="dropdown-menu">
//            <li><a href="profile.php">Character</a></li>
//            <li><a href="profile.php#inventory">Inventory</a></li>
//			<li><a href="profile.php#friends">Friends</a></li>
//            <li><a href="profile.php#accountInfo">Account Info</a></li> 
//			<li><a href="signout.php">Sign out!</a></li> 
//          </ul>
//        </li>';
//		}
//		else
//		{
//		//Sing in or up
//		echo '
//		<li><a href="signup.php">Sign Up</a></li>
//          <li class="divider-vertical"></li>
//          <li class="dropdown">
//            <a class="dropdown-toggle" href="#" data-toggle="dropdown">Sign In <strong class="caret"></strong></a>
//            <div class="dropdown-menu" style="padding: 15px; padding-bottom: 0px;">
//				<form action="signin.php" method="post" accept-charset="UTF-8">
//				<input id="user_username" style="margin-bottom: 15px;" type="text" name="user" size="30" />
//				<input id="user_password" style="margin-bottom: 15px;" type="password" name="password" size="30" />
//				<input id="user_remember_me" style="float: left; margin-right: 10px;" type="checkbox" name="user[remember_me]" value="1" />
//				<label class="string optional" for="user_remember_me"> Remember me</label> 
//				<input class="btn btn-primary" style="clear: left; width: 100%; height: 32px; font-size: 13px;" type="submit" name="commit" value="Sign In" />
//				<br />
//				<br />
//				</form>
//            </div>
//          </li>';
//		}
		  
    navbar += "<li><a href='#'><span class='glyphicon glyphicon-search'></span></a></li>"
            + "</ul></div>  </div></nav>";
    return navbar;
    }
}
