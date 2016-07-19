package com.mycompany.rpgtubejava;


import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Logan
 */
public class DatabaseHandler {

    public DatabaseHandler() {
    
    }
      
    
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/rpgtube";

   //  Database credentials
   static final String USER = "logan";
   static final String PASS = "pass";
   
   
   public Item getItem(int id) throws SQLException, ClassNotFoundException{
       Class.forName("com.mysql.jdbc.Driver");
       Item item;
       Connection conn = null;
       Statement stmt = null;
       conn = DriverManager.getConnection(DB_URL,USER,PASS);

	//STEP 4: Execute a query
	System.out.println("Creating statement...");
	stmt = (Statement) conn.createStatement();
	String sql;
	sql = "SELECT name, attribute, picture FROM item where item_id = " + id;

	ResultSet rs = stmt.executeQuery(sql);
        String name = "Didn't";
	String attribute = "Work";
	String picture = "failure.jpg";
        
        while(rs.next()){
	   //Retrieve by column name
	   name = rs.getString("name");
	   attribute = rs.getString("attribute");
	   picture = rs.getString("picture");
	   
	}
        item = new Item(name, attribute, picture);
        rs.close();
	stmt.close();
	conn.close();
        return item;
       
   }
    
}
