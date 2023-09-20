<%-- 
    Document   : khatabookoption
    Created on : 15-Jun-2023, 5:27:34 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
<head>
    <title>KB homepage</title>
    <style>
        .cus {
            height: 20px;
            width: 30px;
            justify-content: center;
            font-size: 25px;
        }

        .box {
            width: 100%;
            height: 700px;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        body {
            background-color: #FFF0F5;
            margin: 0;
            padding: 0;
        }

        .c {
            border: 3px solid black;
            height: 450px;
            width: 500px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            background-color: brown;
            align-items: center;
            border-radius: 10px;
            box-shadow: 2px 5px 10px rgba(0, 0, 0, 0.5);
        }

        a {
            text-decoration: none;
        }

        .c > div {
            background-color: white;
            width: 480px;
            height: 70px;
            margin: 10px;
            text-align: center;
            line-height: 70px;
            font-size: 30px;
            border-radius: 5px;
            box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>
<div class="box">
    <div class="c">
        <div><a href="addcustomerpage">Customer</a></div>
        <div><a href="productmenupage">Inventory</a></div>
        <div><a href="statsmenupage">Statistics</a></div>
        <div><a href="logout">Logout</a></div>
    </div>
</div>
</body>
</html>