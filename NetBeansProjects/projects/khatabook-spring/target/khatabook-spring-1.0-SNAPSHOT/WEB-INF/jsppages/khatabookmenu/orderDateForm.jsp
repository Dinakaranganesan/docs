<%-- 
    Document   : orderDateForm
    Created on : 16-Jun-2023, 5:03:29 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="getorderedetails" method="post">
            <div>     
                <label for="order-date">Order Date:</label>     
                <input type="date" id="order-date" name="order-date" required>    
            </div>  
            <input type="submit">
        </form>
    </body>
</html>
