package com.mycompany.rpgtubejava;

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

    public static String display(){
	return "<nav class='navbar navbar-default navbar-fixed-top'>"
	    + "<div class='container-fluid'>"
	    + "<div class='navbar-header'>"
	    + "<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='#myNavbar'>"
	    + "<span class='icon-bar'></span>"
	    + "<span class='icon-bar'></span><span class='icon-bar'></span></button>"
	    + "<a class='navbar-brand' href='homepage.jsp'>RPGTUBE</a></div>"
	    + "<div class='collapse navbar-collapse' id='myNavbar'>"
	    + "<ul class='nav navbar-nav navbar-right'>"
	    + "<li><a href='homepage.jsp'>HOME</a></li>"
	    + "<li><a href='comingsoon.jsp'>ABOUT RPGTUBE</a></li>"
	    + "<li><a href='vidSearch.jsp'>VIDEOS</a></li>'"
	    + "<li><a href='#'><span class='glyphicon glyphicon-search'></span></a></li>"
	    + "</ul></div>  </div></nav>";
    }
}
