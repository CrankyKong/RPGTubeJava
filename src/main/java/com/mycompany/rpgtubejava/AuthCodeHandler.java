package com.mycompany.rpgtubejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AuthCodeHandler", urlPatterns = {"/AuthCodeHandler"})
public class AuthCodeHandler extends HttpServlet {

    @EJB
    private SessionHandler sessionHandler;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String authCode = (String)request.getParameter("code");

        if (authCode != null) {
            // TODO: parse this JSON and use it for something useful...
            out.println(requestToken(authCode));
        } else {
            response.sendRedirect("SignIn");
        }

	sessionHandler.dump(out);
    }

    private static String requestToken(String authCode) {
        try {
            URL obj = new URL("https://accounts.google.com/o/oauth2/token");
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        
            con.setRequestMethod("POST");
            //con.setRequestProperty("User-Agent", "Just a test");

            String postParams = "code=" + authCode +
                "&client_id=725111314423-hfjs0q1u560ed56kni6hmirve53qk7fp.apps.googleusercontent.com" +
                "&client_secret=IMBrzjy3LX68gw0gUZJZyBkn" +
                // IMPORTANT! the redirect URL needs to be the same as the one
                // we used to get the auth code 
                "&redirect_uri=http://localhost:8080/RPGTubeJava/AuthCodeHandler" +
                "&grant_type=authorization_code";

            // For POST only - START
            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(postParams.getBytes());
            os.flush();
            os.close();
            // For POST only - END

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            } else {
                System.out.println("POST request not worked");
            }
        } catch (IOException e) {
            System.out.println("Exception caught!");
        }
        
        return null;
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