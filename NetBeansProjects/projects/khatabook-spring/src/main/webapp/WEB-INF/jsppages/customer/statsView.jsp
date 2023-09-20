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
                    <th>CUSTOMER ID</th>
                    <th>CUSTOMER NAME</th>
                    <th>CUSTOMER PHONE NO</th>
                    <th>CUSTOMER ADHAAR</th>
                    <th>CUSTOMER ADDRESS</th>
                    <th>CUSTOMER BALANCE</th>
                </tr>
                <tr class="data">
                <c:forEach items="${customer1}" var="customer">
                    <tr>
                        <td><b>${customer.getCusId()}</</b></td>
                        <td><b>${customer.getCusName()}</b></td>
                        <td><b>${customer.getPhoneNo()}</b></td>
                        <td><b>${customer.getCusAddress()}</b></td>
                        <td><b>${customer.getCusAadhaar()}</b></td>
                        <td><b> ${customer.getCusBal()}</b></td>
                        
                    </tr>
                </c:forEach>
            </table>

    </body>
</html>
