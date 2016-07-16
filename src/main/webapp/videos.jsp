<%
    //Document   : videos
    //Created on : Jul 10, 2016, 5:53:28 PM
    //Author     : Logan
%>

<%@page import="com.mycompany.rpgtubejava.NavBar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
    <title>RPGTUBE HOME</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="/style.css">
</head>
    
    <body>
        <% NavBar navbar = new NavBar(); 
        String displayme = navbar.display(); 
        out.println(displayme); %>
        <br />
<br />
<br />
 <div>
  <h1>Videos</h1>
  <p>Click on the video links to gain experience!</p>
  
  </div>
  <div>
  <button class="btn" data-toggle="modal" data-target="#myModal" value="gainExp">Video#1</button>
  </div>
  <br />
<br />
  <div>
  <button class="btn" data-toggle="modal" data-target="#myModal2" value="gainExp">Video#2</button>
  </div>
  <br />
<br />
  <div>
  <button class="btn" data-toggle="modal" data-target="#myModal3" value="gainExp">Video#3</button>
  </div>
  <br /><br />
  <div>
  <button class="btn" data-toggle="modal" data-target="#myModal4" value="gainExp">Video#4</button>
  </div>
  
  
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4></span> +100 EXP</h4>
        </div>
        <div class="modal-body">
          <iframe width="560" height="315" src="https://www.youtube.com/embed/NsLKQTh-Bqo" frameborder="0" allowfullscreen></iframe>
        </div>
        <!--TODO: We can change the way we do this whole page -->
        <div class="modal-footer"><form action="">
          <button type="submit" class="btn btn-danger btn-default pull-left" > <!--data-dismiss="modal"--> 
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button></form>
        </div>
      </div>
    </div>
  </div>
</div>


  <!-- Modal -->
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4></span>YOU FOUND AN EGG!</h4>
        </div>
        <div class="modal-body">
          <iframe width="560" height="315" src="https://www.youtube.com/embed/GKNB7Eid-ek" frameborder="0" allowfullscreen></iframe>
        </div>
        <div class="modal-footer"><form action="">
          <button type="submit" class="btn btn-danger btn-default pull-left" > <!--data-dismiss="modal"--> 
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button></form>
        </div>
      </div>
    </div>
  </div>
</div>

  <!-- Modal -->
  <div class="modal fade" id="myModal3" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4></span> YOU FOUND A SHIELD!</h4>
        </div>
        <div class="modal-body">
          <iframe width="560" height="315" src="https://www.youtube.com/embed/69AyYUJUBTg" frameborder="0" allowfullscreen></iframe>
        </div>
        <div class="modal-footer"><form action="">
          <button type="submit" class="btn btn-danger btn-default pull-left" > <!--data-dismiss="modal"--> 
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button></form>
        </div>
      </div>
    </div>
  </div>
</div>

  <!-- Modal -->
  <div class="modal fade" id="myModal4" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4></span> +100 EXP</h4>
        </div>
        <div class="modal-body">
          <iframe width="560" height="315" src="https://www.youtube.com/embed/zqZMlSZzUu8" frameborder="0" allowfullscreen></iframe>
        </div>
        <div class="modal-footer"><form action="">
          <button type="submit" class="btn btn-danger btn-default pull-left" > <!--data-dismiss="modal"--> 
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button></form>
        </div>
      </div>
    </div>
  </div>
</div

    </body>
</html>
