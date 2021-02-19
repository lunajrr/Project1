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
                
                <form id="logInForm" method="POST" action="logIn">
                <h1>Log In</h1>
                <h2 class="errorFont"><c:out value="${logInn}"/></h2>
                <label for="uname"><b>Enter Username:</b></label>
                <input type="text" placeholder="Enter Username" name="uname" required>
                <br>
                <label for="password"><b>Password:   </b></label>
                <input type="password" placeholder="Enter Password" name="password" required minlength="2">
                <br>
                <button type="submit" class="LogInButton">Log in</button>
                <br>
                </form>

                <div class="vl"></div>

                <form id="CreateAnAccount" method="POST" action="createNewUser">
                    <h1>Create an account</h1>
                    <h2 class="errorFont"><c:out value="${success}"/></h2>
                    <label for="firstName"><b>Enter First Name:</b></label>
                    <input type="text" placeholder="Enter First Name" name="firstName" required>
                    <br>
                    <br>
                    <label for="lastName"><b>Enter Last Name:</b></label>
                    <input type="text" placeholder="Enter Last Name" name="lastName" required>
                    <br>
                    <br>
                    <label for="uname"><b>Enter Username:</b></label>
                    <input type="text" placeholder="Enter Username" name="uname" required>
                    <br>
                    <br>
                    <label for="password"><b>Password:   </b></label>
                   	
                    <input type="password" placeholder="Enter Password" name="password" required minlength="4">
                <br><br>
                <button type="submit" class="LogInButton">Sign Up</button>
                <br>
                </form>
                
            </div>
            <footer id="footer"></footer>
            </div>   
       
    </body>

</html>