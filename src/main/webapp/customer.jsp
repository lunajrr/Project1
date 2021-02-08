
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
		
        <style>
        

        
        h3{text-align:center;}
        
        h1{
        text-align:center;}
            #page-container{
                line-height: 4em;
				height:600px;
                text-align: center;
            }

            <%if(request.getSession(false)==null)
            	response.sendRedirect("logIn.jsp");%>

        </style>
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
    <div id="header"></div>
    <h1 style="font-size:40px"><c:out value = "Welcome ${User.firstName}!"/> </h1>
            <div id="page-container">
            
            <div id="content-wrap">
            <h1 style= "font-size:30px">What would you like to do?</h1>
            <button class="customerHomePageButton" onClick="window.location='createNewAccount.jsp';">Apply for a new account</button>
			
            <form method="GET" action="viewMyAccounts"><br>
            <button class="customerHomePageButton">View My Accounts</button>
            </form ><br>
            <form  method="GET" action="viewMyPendingTransfers">
            <button class="customerHomePageButton">See my pending transfers</button>
            </form>
            </div><br>
            <form method="POST" action="logOut">
            <button class="customerHomePageButton">LOG OUT</button>
            </form>
            
            </div>  
            <Footer id="footer"></Footer> 
        </div>
       
    </body>

</html>