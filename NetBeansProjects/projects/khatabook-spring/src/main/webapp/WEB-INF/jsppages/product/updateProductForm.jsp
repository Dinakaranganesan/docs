<%-- 
    Document   : updateProductForm
    Created on : 13-Jun-2023, 10:08:30 am
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page  import="com.khatabook.model.Inventory" %> 
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="proupd?id=${product.productId}" method="post">
            <label for="Product Name">Product Name</label><br><br>
            <input type="text" name="proname"  value="${product.proName}" required><br><br>
            <label for="Quantity">Enter a quantity to add</label><br><br>
            <input type="text" name="quantity"value="${product.quantity}"  required><br><br>
            <label for="Price">Product Price</label><br><br>
            <input type="text" name="price" value="${product.price}"  required><br><br>
            <input type="submit">
        </form>
    </body>
</html>
