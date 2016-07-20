package com.mycompany.rpgtubejava;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ValidateLogin", urlPatterns = {"/ValidateLogin"})
public class ValidateLogin extends HttpServlet {

    @EJB
    private SessionHandler sessionHandler;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username = (String)request.getParameter("username");
	String password = (String)request.getParameter("password");

	if (sessionHandler.logIn(username, password)) {
	    String getAccessTokenUri = "https://accounts.google.com/o/oauth2/auth?"
		+ "client_id=725111314423-hfjs0q1u560ed56kni6hmirve53qk7fp.apps.googleusercontent.com"
		+ "&redirect_uri=http://localhost:8080/RPGTubeJava/AuthCodeHandler"
		+ "&response_type=code"
		+ "&scope=https://www.googleapis.com/auth/youtube&state";

	    response.sendRedirect(getAccessTokenUri);
	} else {
	    response.sendRedirect("login.jsp");
	}
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
