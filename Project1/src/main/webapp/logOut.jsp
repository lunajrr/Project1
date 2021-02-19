<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ page import ="java.util.*, java.io.*, java.net.*, com.fasterxml.jackson.databind.*" %>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	 <%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

        <link rel= "stylesheet" href="default.css"/>

        <script
            src="https://code.jquery.com/jquery-3.3.1.js">
        </script>
        <script> 
            $(function(){
            $("#header").load("DefaultHeader.html"); 
            $("#footer").load("Footer.html");
            });
        </script> 
        
    </head>
    
    
    <body>
    
    <div id="middleColor"> 
    <header id="header"></header>
                
            <div id="content-wrap">
                
                <h1 style="text-align: center;">Thank you for trying my bank service!</h1>
                <form action="logIn.jsp">
    			<button style="position: relative;left:43%; font-size:40px; margin-top:40px;margin-bottom:100px;">Log In</button>
				</form>

                
            </div>
            <footer id="footer"></footer>
            </div>   
       
    </body>

</html>