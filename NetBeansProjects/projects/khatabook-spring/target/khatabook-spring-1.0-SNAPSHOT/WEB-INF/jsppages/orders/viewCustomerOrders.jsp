<%-- 
    Document   : viewCustomerOrders
    Created on : 13-Jun-2023, 12:15:31 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.khatabook.model.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Customer Order</title>
    <style>
        @keyframes fadeIn {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        table {
            width: 750px;
            margin-left: auto;
            margin-right: auto;
            animation: fadeIn 1s ease-in-out;
        }

        .header {
            text-align: center;
        }

        .back {
            justify-content: center;
            text-align: center;
            padding: 10px;
        }

        .right {
            text-align: right;
            padding-right: 20px;
        }

        .center {
            text-align: center;
            border-style: dashed;
        }
    </style>
</head>
<body>
<%
    ShowOrders order = (ShowOrders) request.getAttribute("order");
    if (Objects.nonNull(order)) {
        for (Orders orders : order.getOrder()) {
%>
    <table border="1" rules="all">
        <tr>
            <th colspan="" class="underline">Order Detail</th>
            <th colspan="2" class="right">Date: <%=orders.getDate()%><br> </th>
        </tr>

        <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Product Price</th>
        </tr>

        <%
            for (LineItems lineItems : order.getLine()) {
                if (orders.getOrderID() == lineItems.getOrderId()) {
        %>
        <tr>
            <td><%= lineItems.getProName()%></td>
            <td><%= lineItems.getQuantity()%></td>
            <td><%= lineItems.getPrice()%></td>
        </tr>
        <%
                }
            }
        %>
        <tr>
            <th class="right" colspan="2">Total Price:</th>
            <td><%=orders.getTotalprice()%></td>
        </tr>
        <tr>
            <th colspan="3" class="center">#Thank You#</th>
        </tr>
    </table>
    <br><br>
<%
        }
    } else {
%>
    <h1><%= (String)request.getAttribute("message") %></h1>
<%
    }
%>
</body>
</html>
