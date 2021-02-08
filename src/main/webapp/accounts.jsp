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
            #page-container{
                line-height: 4em;
                height:650px;
                text-align: center;
            }
            article{
            border:3px solid black;
            position:absolute;
            top:0px;
            left:0px;
            width:100%;
            height:600px;
            overflow-y: scroll;
            background-color: rgb(136, 189, 160);}
            table{
             background-color: rgba(136, 189, 160);}
            
            }
            tr:nth-child(odd){
            background-color:rgb(136, 189, 160);
            }
            tr:nth-child(even){
            background-color:lightgreen;
            }
            th,td{
            position: relative;
            width:2000px;
            border:5px solid black;}


            
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
            <div id="page-container">
            <div id="content-wrap">
                
                <article id="artTable">
                
                <table class="table table-striped table-hover table-responsive">
                	<thead>
                	<tr>
                		<td>Username</td><td>Account Number</td> <td>Balance</td> <td>Type</td><td>State</td><td>View Details</td>
                	</tr>
                	</thead>
                	<tbody>
                	<c:forEach var="account" items="${accounts}">
                	<tr>
                	<td><c:out value = "${account.username}"/></td>
                	<td><c:out value = "${account.number}"/></td>
                	<td><c:out value = "${account.balance}"/></td>
                	<td><c:out value = "${account.acc_type}"/></td>
                	<td><c:out value = "${account.state}"/></td>
                	<td><form action="viewAllAccountDetails" method="post">
                		<input type="hidden" name="accNumber" value="${account.number}">
                		<button>View more</button></form>
                	</tr>
                	</c:forEach>
                	</tbody>       
                
                </table>
                </article>
                
             
            </div>
            <Footer id="footer"></Footer>
            </div>   
        </div>
       
    </body>

</html>