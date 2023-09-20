<%-- 
    Document   : addCustomer
    Created on : 08-Jun-2023, 12:41:47 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <body style="background-color:#FFF0F5">
            <form action="/khatabook-spring/add" method="post">
            <table border="1">

                <tbody>
                    <tr>
                        <td> Enter the CustomerId</td>
                        <td><input type="text" name="customerid" value="" /></td>

                    </tr>
                    <tr>
                        <td> Enter the CustomerName</td>
                        <td><input type="text" name="customername" value="" /></td>

                    </tr>
                    <tr>
                        <td>Enter MobileNumber</td>
                        <td><input type="text" name="customernum" value="" /></td>

                    </tr>
                    <tr>
                        <td>Enter your  Aadhar</td>
                        <td><input type="text" name="customeraadhar" value="" /></td>

                    </tr>
                    <tr>
                        <td>Enter your  Address</td>
                        <td><input type="text" name="customeradd" value="" /></td>

                    </tr>

                </tbody>
            </table>
            <input type="submit">

        </form>
    </body>
</html>