/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rpgtubejava;

import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Logan
 */
@WebServlet(name = "dbAccess", urlPatterns = {"/dbAccess"})
public class dbAccess extends HttpServlet {
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/rpgtube";

   //  Database credentials
   static final String USER = "logan";
   static final String PASS = "pass";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

	Connection conn = null;
	Statement stmt = null;
	
	try {
	//STEP 2: Register JDBC driver
	Class.forName("com.mysql.jdbc.Driver");

	//STEP 3: Open a connection
	System.out.println("Connecting to database...");
	conn = DriverManager.getConnection(DB_URL,USER,PASS);

	//STEP 4: Execute a query
	System.out.println("Creating statement...");
	stmt = (Statement) conn.createStatement();
	String sql;
	sql = "SELECT name, attribute, picture FROM item";

	ResultSet rs = stmt.executeQuery(sql);

	//STEP 5: Extract data from result set
	out.print("<html><body>");
	while(rs.next()){
	   //Retrieve by column name
	   String name = rs.getString("name");
	   String attribute = rs.getString("attribute");
	   String picture = rs.getString("picture");

	   //Display values
	   
	   out.print("<p>" + name + " " + attribute + "<img href='" + picture + "'></p><br/>");
	   
	}
        sql = "INSERT INTO user(username, password) VALUES ('Maventest','test');";

	//stmt.executeUpdate(sql);
        
	out.print("</body></html>");
	//STEP 6: Clean-up environment
	rs.close();
	stmt.close();
	conn.close();
     } catch(SQLException se) {
	//Handle errors for JDBC
	se.printStackTrace();
     } catch(Exception e) {
	//Handle errors for Class.forName
	e.printStackTrace();
     } finally {
	//finally block used to close resources
	try {
	   if (stmt != null)
	      stmt.close();
	} catch(SQLException se2) {
	}// nothing we can do
	try {
	   if(conn != null)
	      conn.close();
	}catch(SQLException se){
	   se.printStackTrace();
	}//end finally try
     }//end try
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
