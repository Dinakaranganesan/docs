<%-- 
    Document   : viewUsers2
    Created on : 10-Apr-2023, 6:21:52 pm
    Author     : bas200181
--%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Customerr,java.util.*" errorPage="handler.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <c:if test="${ not empty requestScope.customerlist }">
            <table border="1" cellpadding="6" cellpadding="6"> 
                <tr>
                    <th>CUSTOMER ID</th>
                    <th>CUSTOMER NAME</th>
                    <th>MOBILE NUMBER</th>
                    <th>AADHAAR NO</th>
                    <th>ADDRESS</th>
                    <th>BALANCE</th>
                </tr>
                <c:forEach items="${requestScope.customerlist}" var="customer" >
                    <tr><td>${customer.cusId}</td>
                        <td>${customer.cusName}</td>
                        <td>${customer.phoneNo}</td>
                        <td>${customer.cusAadhaar}</td>
                        <td> ${customer.cusAddress}</td>
                        <td>${customer.cusBal}</td>
                    </tr>
              
            </c:forEach>
                      </table>
        </c:if>


    </body>
</html>
