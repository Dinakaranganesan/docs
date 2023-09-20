<%--
    Document   : customerMenu
    Created on : 15-Jun-2023, 5:38:29 pm
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
    <title>Customer Menu Page</title>
    <style>
        body {
            background-color: #FFF0F5;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .back {
            display: flex;
            justify-content: flex-end;
            margin: 20px;
        }

        .box {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .c {
            border: 3px solid black;
            width: 500px;
            background-color: brown;
        }

        .c > div {
            background-color: white;
            height: 70px;
            margin: 10px;
            text-align: center;
            line-height: 70px;
            font-size: 20px;
            box-shadow: 2px 5px 10px rgba(0, 0, 0, 0.5);
        }

        a {
            color: black;
            text-decoration: none;
        }

        a:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
    <div class="back">
        <a href="homepage.html"><button>Back</button></a>
    </div>
    <div class="box">
        <div class="c">
            <div><a href="addcustomer">ADD CUSTOMER</a></div>
            <div><a href="user">VIEW ALL CUSTOMERS</a></div>
            <div><a href="single"">VIEW PARTICULAR CUSTOMER</a></div>
            <div><a href="order">PLACE ORDER</a></div>
            <div><a href="">VIEW PENDING ORDERS</a></div>
            <div><a href="customernumform">PAY</a></div>
        </div>
    </div>
</body>
</html>
