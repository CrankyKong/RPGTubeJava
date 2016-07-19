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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Logan
 */
@WebServlet(name = "addUser", urlPatterns = {"/addUser"})
public class addUser extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {

	Connection conn = null;
	Statement stmt = null;
	String name = request.getParameter("user");
        String password = request.getParameter("password");
        String avatar = request.getParameter("avatar");
    try {
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Connecting to database...");
	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	System.out.println("Creating statement...");
	stmt = (Statement) conn.createStatement();
	String sql;
	
        //Create User
        sql = "INSERT INTO user(username, password) VALUES ('" + name +"','" + password + "');";
	stmt.executeUpdate(sql);
        
        //Get the id of what was just inserted
        sql = "SELECT id FROM user WHERE username = '" + name + "';";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        String userIdS;
        userIdS = rs.getString("id");
        System.out.println("USERIDS: " + userIdS);
        int userId = Integer.parseInt(userIdS);
        
        System.out.println("USERID: " + userId);
        
        //Create Avatar attached to this user.
        sql = "INSERT INTO avatar(name, level, experience, user_id) VALUES ('" + avatar + "', 1 , 0," + userId + ");";
        stmt.executeUpdate(sql);
        
        sql = "SELECT character_id from avatar where user_id = " + userId + ";";
        rs = stmt.executeQuery(sql);
        rs.next();
        String avatarIdS = rs.getString("character_id");
        int avatarId = Integer.parseInt(avatarIdS);
        
        //Create inventory for character
        sql = "INSERT INTO inventory(gold, avatar_id) VALUES (500, " + avatarId + ");";
        stmt.executeUpdate(sql);
        
        
        sql = "SELECT inv_id from inventory where avatar_id = " + avatarId + ";";
        rs = stmt.executeQuery(sql);
        rs.next();
        String invIdS = rs.getString("inv_id");
        int invId = Integer.parseInt(avatarIdS);
        
        //session for avatar_id
        
        //session for user_id 
        
        //session for inv_id
        
        //with these sessions should be able to do everything else we need. 
        
        
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
        
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
        
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
          try {
              processRequest(request, response);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
          }
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
          try {
              processRequest(request, response);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
          }
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