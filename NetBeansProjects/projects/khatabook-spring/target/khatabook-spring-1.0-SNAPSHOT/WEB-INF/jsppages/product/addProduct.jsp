<%-- 
    Document   : addProduct
    Created on : 12-Jun-2023, 6:05:45 pm
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
               <form action="addp" method="post">
            <table border="1">
                <tbody>
                    <tr>
                        <td><i>Enter Product id </i></td>
                        <td> <input type="text" name="productid" value="" /></td>
                    </tr>
                    <tr>
                        <td><i>Enter Product Name </i></td>
                        <td><input type="text" name="proname" value="" /></td>
                    </tr>
                    <tr>
                        <td><i>Enter Quantity </i></td>
                        <td><input type="text" name="quantity" value="" /></td>
                    </tr>
                    <tr>
                        <td><i>Enter price </i></td>
                        <td><input type="text" name="price" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit">
    </body>
</html>
