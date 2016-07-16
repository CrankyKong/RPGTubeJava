package com.mycompany.rpgtube;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SignIn", urlPatterns = {"/SignIn"})
public class SignIn extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String getAccessTokenUri = "https://accounts.google.com/o/oauth2/auth?"
            + "client_id=725111314423-hfjs0q1u560ed56kni6hmirve53qk7fp.apps.googleusercontent.com"
            + "&redirect_uri=http://localhost:8080/RPGTubeJava/AuthCodeHandler"
            + "&response_type=code"
            + "&scope=https://www.googleapis.com/auth/youtube&state";

        response.sendRedirect(getAccessTokenUri);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}