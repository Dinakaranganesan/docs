<%-- 
    Document   : elDemo
    Created on : 10-Apr-2023, 3:18:51 pm
    Author     : bas200181
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <jsp:useBean id="c1" class="model.Customerr" scope="request">
        </jsp:useBean>
          <jsp:setProperty name="c1" property="cusName" value="Robert" ></jsp:setProperty>
          <jsp:getProperty name="c1" property="cusName" ></jsp:getProperty><br>
        ${2+2 }=4<br>
        ${2 gt 2}<br>
        ${2 lt 2}<br>
        ${2 ne 2}<br>
        
        Name:    ${requestScope.c1.cusName}<br>
    Language 1: ${paramValues.lang[0]}<br>
    Language 2: ${paramValues.lang[1]}<br>
   Language 3:${paramValues.lang[2]}<br>
   Host:${header.host}<br>
   <c:import url="http://www.google.com" var="link"  >      
 
       <c:param name="q" value="${param.query}"></c:param>
   </c:import>
       ${link}
        


    </body>
</html>
