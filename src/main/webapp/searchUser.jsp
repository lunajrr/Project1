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
        
        h1,h2{
        text-align:center;}
            #page-container{
                line-height: 4em;
				height:600px;
                text-align: center;
            }
            article{
			overflow-y:auto;
            width:100%;
            height:550px;}
            table{
         
             background-color: rgb(136, 189, 160);}
            
            }
            
            tr:nth-child(even){
            background-color:rgb(136, 189, 160);
            }
            tr:nth-child(odd){
            background-color:rgb(212, 210, 210);
            }
            th{
            position: relative;
            width:2000px;
            border:5px solid black;}
            
            #accountList{
            position:absolute;
            top:60px;
        
            left:0px;
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
    <h1>Welcome ! </h1>
    <h2>Enter Username to Search</h2>
            <div id="page-container">
            
            <div id="content-wrap">
            
            <form method="POST" action="searchAccountViaUser">
            <input type="text" value="Enter Username"name="username" required/>
            <input type="submit" value="Search"/>
            </form>
			<article id="accountList">
                                <h1><c:out value="Accounts owned by: ${searchedUser}"></c:out></h1>
                <table class="table">

                	<thead>
                	<tr>
                		<th>Account Number</th><th>Balance</th> <th>Account Type</th> <th>State</th>
                	</tr>
                	</thead>
                	<tbody>
                	<c:forEach var="account" items="${searchedAccs}">
                	<tr>
                	<td><c:out value = "${account.number}"/></td>
                	<td><c:out value = "${account.balance}"/></td>
                	<td><c:out value = "${account.acc_type}"/></td>
                	<td><c:out value = "${account.state}"/></td>
                	</tr>
                	</c:forEach>
                	</tbody>       
                
                </table>
                </article>
            
            
            

                
             
            </div>
            
            </div>  
            <Footer id="footer"></Footer> 
        </div>
       
    </body>

</html>