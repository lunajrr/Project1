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
            table{
         
             background-color: rgba(136, 189, 160);}
            
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
            
                <article id="accountInfo">
    <h1>Account information for Account Number: ${account.number} </h1>
    
    <h3>Balance: ${account.balance}</h3>
    <h3>Account Type: ${account.acc_type}</h3>
    <h3>State:   ${account.state}</h3>
                <form method="POST">
                <label for="amount">Withdraw Amount</label>
                <input type="hidden" name="accNumber" value="${account.number}"/>
            <input type="number" name="amount" step=".01" min="1" max="${account.balance}"  required/>
            <input type = "submit" value="Withdraw" formaction="withdraw">
            </form>
            
             <form method="POST">
             <label for="amount">Deposit Amount</label>
             <input type="hidden" name="accNumber" value="${account.number}"/>
            <input type="number" name="amount" step=".01" min="1" required/>
            <input type ="submit" value="Deposit" formaction="deposit">
            </form>
            
            <form method="POST" action="postTransfer">
            
            <label for ="recAcc">Start Transfer <br> </label>
            <label for ="recAccNumber">Send to: </label>
            <input type="hidden" name="sendAccNumber" value="${account.number}"/>
            <input type="text" name ="recAccNumber" required/><br>
            <label for="amount">Amount</label>
            <input type="number" name="amount" min="0.01" step=".01" max="${account.balance}" required/>
            <input type="submit" value="Post Transfer"/>
            </form>
    </article>
            
            <div id="content-wrap">
            
            <article id="Tables">
            <div class="table">
                <input type="checkbox"/><span>Show Transfer Table</span><span>Hide Transfer Table</span>
                <table class="collapsible">
                	<thead>
                	<tr>
                		<td>TransferID</td><td>Amount</td><td>Sending Account</td><td>Receiving Account</td><td>State</td>
                	</tr>
                	</thead>
                	<tbody>
                	<c:forEach var="transfer" items="${transfers}">
                	<tr>
                	<td><c:out value = "${transfer.tid}"/></td>
                	<td><c:out value = "${transfer.amount}"/></td>
                	<td><c:out value = "${transfer.send_acc}"/></td>
                	<td><c:out value = "${transfer.rec_acc}"/></td>
                	<td><c:out value = "${transfer.state}"/></td>
                	</tr>
                	</c:forEach>
                	</tbody>       
                
                </table>
                </div>
                <div class="table">
                <input type="checkbox"/><span>Show Transaction Table</span><span>Hide Transaction Table</span>
                <table class="collapsible">
                	<thead>
                	<tr>
                		<td>TransactionID</td> <td>Amount</td> <td>type</td><td>Description</td><td>time</td>
                	</tr>
                	</thead>
                	<tbody>
                	<c:forEach var="transaction" items="${transactions}">
                	<tr>
                	<td><c:out value = "${transaction.tid}"/></td>
                	<td><c:out value = "${transaction.amount}"/></td>
                	<td><c:out value = "${transaction.type}"/></td>
                	<td><c:out value = "${transaction.description}"/></td>
                	<td><c:out value = "${transaction.time}"/></td>
                	</tr>
                	</c:forEach>
                	</tbody>       
                </table>
                </div>
                </article>
                
             
            </div>
            
            </div>  
            <Footer id="footer"></Footer> 
        </div>
       
    </body>

</html>
    
    
   