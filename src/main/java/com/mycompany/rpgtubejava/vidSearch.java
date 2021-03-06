/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rpgtubejava;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.err;
import static java.lang.System.out;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpURLConnection;
import com.mycompany.rpgtubejava.NavBar;

/**
 *
 * @author John Krieger
 */
@WebServlet(name = "vidSearch", urlPatterns = {"/vidSearch"})
public class vidSearch extends HttpServlet {

    private static YouTube youtube;

 private static final long NOFV = 25;

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
        out.println("<html>");
        out.println("<body>");
         out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
        out.println("<title>Found Youtube videos</title>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
	out.println("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">");
	out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>");
	out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>");
	out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"/style.css\">");
        out.println("<link href=\'https://fonts.googleapis.com/css?family=Quicksand\' rel=\'stylesheet\' type=\'text/css\'>");   
        out.println("</head>");
        
        NavBar navbar = new NavBar(); 
        String displayme = navbar.display(); 
        out.println(displayme);
      
        try {    
        youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(), new HttpRequestInitializer() {
       
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("RPGtube").build();
               Properties properties = new Properties();
            String query = request.getParameter("search");
            YouTube.Search.List search = youtube.search().list("id,snippet");
            
            String apiKey = properties.getProperty("youtube.apikey");
            
            search.setKey("AIzaSyD8ge2xgrP5RMztFDXKAU7zqMIOxUENdZk");
            search.setQ(query);
            
            search.setType("video");
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
            search.setMaxResults(NOFV);
            
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
            Iterator<SearchResult> iteratorSearchResults;
            if (searchResultList != null ){
                
                
             prettyPrint(searchResultList.iterator(), query, response,request);
            }
        } catch (GoogleJsonResponseException e) {
            out.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
           out.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
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
        
    
     private static void prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query,HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException {
         
         PrintWriter out = response.getWriter();
        
        out.println("\n=============================================================");
        out.println(
                "First " + NOFV + " videos for search on \"" + query + "\".");
        out.println("=============================================================\n");

        if (!iteratorSearchResults.hasNext()) {
            out.println(" There aren't any results for your query.");
        }

        while (iteratorSearchResults.hasNext()) {

            SearchResult singleVideo = iteratorSearchResults.next();
            ResourceId rId = singleVideo.getId();
            
          
            // Confirm that the result represents a video. Otherwise, the
            // item will not contain a video ID.
            if (rId.getKind().equals("youtube#video")) {
                
            //request.setAttribute("videoName", rId.getVideoId());
            
                Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();
               
                
                
               out.println("<p>");
                String videoName = rId.getVideoId();
                
                HttpSession session = request.getSession();
                session.setAttribute("videoName", videoName);
               out.println("<br>");
               out.println("<br>");
               out.println(singleVideo.getSnippet().getTitle());
               out.println("<form action =\"xpAdd\" method=\"POST\">");
               out.println("<a href=\"https://www.youtube.com/watch?v=" + videoName + "\">");
               out.println("<input type =\"image\" name=\"img\" value=\"xp\" src=\"" + thumbnail.getUrl() + "\"></input>");
               //out.println("<img class=\"img-responsive\" src=\"" + thumbnail.getUrl() + "\">");
               out.println("</a>");
               out.println("</form>");
               out.println("</p>");
           
               out.println("<p>");
               out.println("<form action =\"vidSearch\" method=\"POST\">");
               out.println("<input type =\"submit\" name=\"Honor\" value=\"Honor System\"></input>");
               out.println("</form>");
               out.println("</p>");
               out.println("<br>");
               
               if(request.getParameter("Honor") != null){
                   out.println("PUT EXP GETTING FUNCTION HERE");
               }
               
               
            
            }
        
        }
        out.println("</body>");
        out.println("</html>");
     }
}
