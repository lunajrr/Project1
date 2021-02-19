<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import ="java.util.*, java.io.*, java.net.*, com.fasterxml.jackson.databind.*" %>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

        <link rel= "stylesheet" href="default.css"/>
		
        <style>
        
        html{
        overflow-y: scroll;
        }
        
        body{
        position: absolute;
        height:1000px;
        overflow-y:auto;
        
        }
        
        h3{text-align:center;}
        
        h1{
        text-align:center;}
            #page-container{
                line-height: 4em;
				height:600px;
                text-align: center;
            }


            
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
    <h1><c:out value = "Welcome ${User.firstName}!"/> </h1>
            <div id="page-container">
            
            <div id="content-wrap">
            <h1>What would you like to do?</h1>
            <form method="GET" action="viewAllTransactions">
            <button>View All Transactions</button>
            </form>
            <form method="GET" action="viewAllAccounts">
            <button>View all Accounts</button>
            </form >
            <form  method="GET" action="searchAccountViaUser">
            <button>Search for a user</button>
            </form>
            <form method="GET" action="viewPendingAccounts">
            <button>Approve/Deny Accounts</button>
            </form>
                        <form method="GET" action="logOut">
            <button class="customerHomePageButton">LOG OUT</button>
            </form>
            </div>
            
            </div>  
            <Footer id="footer"></Footer> 
        </div>
       
    </body>

</html>