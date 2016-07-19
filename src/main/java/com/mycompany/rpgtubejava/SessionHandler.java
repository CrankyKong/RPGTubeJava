package com.mycompany.rpgtubejava;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Startup
@Singleton
public class SessionHandler {
    private HttpSession session;
    private String username;
    private String userId;
    private String password;
    private boolean loggedIn;

    public SessionHandler() {
	this.username = "";
	this.userId = "";
	this.session = null;
	this.loggedIn = false;
    }

    public String getUsername() {
	return username;
    }

    public boolean loggedIn() {
	return this.loggedIn;
    }

    public void setUsername(String username) {
	this.username = username;
    }
    
    public void setUserId(String userId) {
	this.userId = userId;
    }

    public void setLoggedIn(boolean loggedIn) {
	this.loggedIn = loggedIn;
    }

    public boolean logIn(String username, String password) {
	if (username.equals("test") && password.equals("test")) {
	    this.username = username;
	    this.userId = "1";
	    this.loggedIn = true;
	    return true;
	}

	return false;
    }
    
    public void dump(PrintWriter out) {
	if (out != null) {
	    out.println("It works but it does nothing yet");
	} else {
	    System.out.println("there");
	}
    }

    public void updateSession(HttpSession session) {
	this.session = session;
    }
}
