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
    <h1>Create a new Account! </h1>
            <div id="page-container">
            <h1><c:out value="${created}"/></h1>
            <div id="content-wrap">
            <form method="post" action="createNewAccount">
            <label for="Balance">Enter Starting Balance  </label>
            <input id="Balance" name="balance" type="number" value="50" step = ".01"min="1" />
            <br>
            <input id ="CRADIO"name="type" type="radio" value="C" checked>
            <label for="CRADIO">Checking Account</label>
            <input id ="SRADIO"name="type" type="radio" value="S">
            <label for="CRADIO">Saving Account</label>
            <br>
            <button>Create Account</button>
            </form>
            </div>
            <br>
            <form >
    		<button onclick="history.back()">Go Back</button>
</form>

            </div>  
            <Footer id="footer"></Footer> 
        </div>
       
    </body>

</html>