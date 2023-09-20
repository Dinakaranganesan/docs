<%-- 
    Document   : newUser
    Created on : 06-Jun-2023, 5:34:44 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .nameValue{
                font-size: 35px;
            }
            </style>
            
    </head>
    <body>
        <div class="nameValue">Id:${user.cusId}</div>
          <div class="nameValue">Name:${user.cusName}</div>
            <div class="nameValue">phoneno:${user.phoneNo}</div>
             <div class="nameValue">Address:${user.cusAddress}</div>
          <div class="nameValue">Aadhar:${user.cusAadhaar}</div>
            <div class="nameValue">Balance:${user.cusBal}</div>
    </body>
</html>

