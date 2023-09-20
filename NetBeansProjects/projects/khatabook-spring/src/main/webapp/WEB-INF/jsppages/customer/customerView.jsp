<%-- 
    Document   : customerView.jsp
    Created on : 08-Jun-2023, 10:37:24 am
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                background-color: #e0c780;
                font-family: Arial, sans-serif;
            }
            
            table {
                border-collapse: collapse;
                width: 100%;
                margin-top: 20px;
            }
            
            th, td {
                padding: 10px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            
            th {
                background-color: #3498DB;
                color: white;
            }
            
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            
            tr:hover {
                background-color: #ddd;
            }
            
            a {
                color: #781D3B;
                text-decoration: none;
                margin-right: 10px;
            }
            
            a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="tab">
            <table> 
                <tr>
                    <th>CUSTOMER ID</th>
                    <th>CUSTOMER NAME</th>
                    <th>CUSTOMER PHONE NO</th>
                    <th>CUSTOMER ADDRESS</th>
                    <th>CUSTOMER AADHAAR</th>
                    <th>CUSTOMER BALANCE</th>
                    <th>ACTIONS</th>
                </tr>
                <c:forEach items="${customer1}" var="customer">
                    <tr>
                        <td>${customer.getCusId()}</td>
                        <td>${customer.getCusName()}</td>
                        <td>${customer.getPhoneNo()}</td>
                        <td>${customer.getCusAddress()}</td>
                        <td>${customer.getCusAadhaar()}</td>
                        <td>${customer.getCusBal()}</td>
                        <td>
                            <a href="updateform?id=${customer.getCusId()}">Update</a>
                            <a href="vieworders?id=${customer.getCusId()}">View Orders</a>
                            <a href="delete?${customer.getCusId()}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>