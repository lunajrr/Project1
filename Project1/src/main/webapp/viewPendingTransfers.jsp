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
        
        h3{text-align:center;}
        h1{
        text-align:center;}
            #page-container{
                line-height: 4em;
				height:800px;
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
    

            <div id="page-container">
            
            
            <div id="content-wrap">
            <div class="table" style="height:
            750px;overflow-y: scroll;">
                <table>
                	<thead>
                	<tr>
                		<td>TransferID</td><td>Amount</td><td>Sending Account</td><td>Receiving Account</td><td>State</td><td>Action</td>
                	</tr>
                	</thead>
                	<tbody>
                	<c:forEach var="transfer" items="${pendingTransfer}">
                	<tr>
                	<td><c:out value = "${transfer.tid}"/></td>
                	<td><c:out value = "${transfer.amount}"/></td>
                	<td><c:out value = "${transfer.send_acc}"/></td>
                	<td><c:out value = "${transfer.rec_acc}"/></td>
                	<td><c:out value = "${transfer.state}"/></td>
                	<td><form action="decideTransfer" method="post">
                	<input type="hidden" name="transferID" value="${transfer.tid}">
                		<input type="hidden" name="decision" value="A">
                		<button>Approve</button></form>
                		<form action="decideTransfer" method="post">
                		<input type="hidden" name="transferID" value="${transfer.tid}">
                		<input type="hidden" name="decision" value="D">
                		<button>Deny</button></form>
                	</tr>
                	</c:forEach>
                	</tbody>       
                
                </table>
                </div>
                
             
            </div>
            
            </div>  
            <Footer id="footer"></Footer> 
        </div>
       
    </body>

</html>
            