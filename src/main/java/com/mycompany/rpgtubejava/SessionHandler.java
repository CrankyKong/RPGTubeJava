package com.mycompany.rpgtubejava;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class SessionHandler {
    private final Map<String, String> stringVariables;
    private boolean loggedIn;

    public SessionHandler() {
        this.stringVariables = new HashMap<>();
        this.loggedIn = false;
    }
    
    public boolean loggedIn() {
	return this.loggedIn;
    }
    
    public String getUsername() {
	return getStringVar("username");
    }

    public String getUserId() {
        return getStringVar("userId");
    }

    public String getStringVar(String key) {
	return stringVariables.get(key);
    }
    
    public void putStringVar(String key, String value) {
	stringVariables.put(key, value);
    }
    
    public void setUsername(String username) {
	putStringVar("username", username);
    }

    public void setUserId(String userId) {
	putStringVar("userId", userId);
    }

    public boolean logIn(String username, String password) {
        
        DatabaseHandler handler = new DatabaseHandler();
        
        String actualPassword = handler.getPassword(username);
        
        
	if (password.equals(actualPassword)) {
	    stringVariables.put("username", username);

            // TODO: get UserId

	    this.loggedIn = true;
	    return true;
	}
        else
        {
            stringVariables.put("username", "");
            this.loggedIn = false;
            return false;
        }
    }

    public void dump(PrintWriter out) {
	out.println("UserId: " + getStringVar("userId") + "\n");
        out.println("Username: " + getStringVar("username") + "\n");
        out.println("Variables - \n");
        for (Map.Entry pair : stringVariables.entrySet()) {
            out.println(pair.getKey() + ": " + pair.getValue() + "\n");
        }
    }
}
