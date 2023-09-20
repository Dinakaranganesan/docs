<%-- 
    Document   : UpdateForm
    Created on : 12-Jun-2023, 11:14:35 am
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Form</h1>
      
    <form action="upd?id=${customer.getCusId()}"method="post">
  <label for="Name">Enter a new name to update:</label><br><br>
  <input type="text" name="name"  value="${customer.cusName}" required><br><br>
    <label for="Address">Enter a new  address to update:</label><br><br>
  <input type="text" name="address"value="${customer.cusAddress}"  required><br><br>
    <label for="Phoneno">Enter a new phoneno to update:</label><br><br>
  <input type="text" name="phoneno" value="${customer.phoneNo}"  required><br><br>
  <input type="submit">
</form>
    </body>
</html>
