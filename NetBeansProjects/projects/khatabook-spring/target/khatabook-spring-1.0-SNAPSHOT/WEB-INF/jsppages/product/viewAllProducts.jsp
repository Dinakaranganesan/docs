<%-- 
    Document   : viewAllProdcuts
    Created on : 12-Jun-2023, 5:38:30 pm
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
    </head>
    <body>
            <style>
            /*           th{
                            border:none;
                            clip:rect(0 0 0 0);
                            height: 1px;
                            margin: -1px;
                            overflow: hidden;
                            padding: 0;
                            position: absolute;
                            width: 1px;
                        }*/
            body
            {
                background-color: #e0c780;
            }


            /*            .tc
                        {
                           background-color: #3498DB ;
                          
                        }*/
            .back1{

                background-color: #781D3B;
                color: white;

            }
            .data{
                background-color: #e0c780;
            }
            .tab{
                display: flex;
                justify-content: center;
                align-items: center
            }
            .back{
                display: flex;
                justify-content: center;
                align-items: center
            }
        </style>
    <body>
        <div class="tab">
            <table border="1" cellpadding="6"> 
                <tr class="tc">
                    <th>PRODUCT ID</th>
                    <th>PRODUCT NAME</th>
                    <th>QUANTITY</th>
                    <th>PRICE</th>
                    
                </tr>
                <tr class="data">
                <c:forEach items="${product}" var="product">
                    <tr>
                        <td><b>${product.getProductId()}</</b></td>
                        <td><b>${product.getProName()}</b></td>
                        <td><b>${product.getQuantity()}</b></td>
                        <td><b>${product.getPrice()}</b></td>
                      
                        <td><a href="productform?id=${product.getProductId()}">Update</a></td>
                        <td><a href="delete?${customer.getCusId()}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>

    </body>
</html>
