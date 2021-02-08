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
        height:900px;
        overflow-y:auto;
        
        }
        h3{text-align:center;}
        
        h1{
        text-align:center;}
            #page-container{
                line-height: 4em;
				height:1000px;
                text-align: center;
            }
            article{
            border:3px solid black;
			overflow-y:auto;
            width:100%;
            height:100%;
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
            
            #transactionList{
            position:absolute;
            top:0px;
            left:0%;
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
    <h1>All of the Transactions </h1>
            <div id="page-container">
            
            <div id="content-wrap">
            
                
                <article id="transactionList">
                                <h1>Transactions</h1>
                <table class="table">

                	<thead>
                	<tr>
                		<td>TransactionID</td><td>Account Number</td> <td>Amount</td> <td>type</td><td>Description</td><td>time</td>
                	</tr>
                	</thead>
                	<tbody>
                	<c:forEach var="transaction" items="${transactions}">
                	<tr>
                	<td><c:out value = "${transaction.tid}"/></td>
                	<td><c:out value = "${transaction.acc_number}"/></td>
                	<td><c:out value = "${transaction.amount}"/></td>
                	<td><c:out value = "${transaction.type}"/></td>
                	<td><c:out value = "${transaction.description}"/></td>
                	<td><c:out value = "${transaction.time}"/></td>
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