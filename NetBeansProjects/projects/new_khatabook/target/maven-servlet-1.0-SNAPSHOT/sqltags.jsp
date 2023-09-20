<%-- 
    Document   : sqltags
    Created on : 11-Apr-2023, 4:34:35 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib  prefix="sql" uri="jakarta.tags.sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <sql:setDataSource var="myDS" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://bassure.in/dina_b8_db" user="dina_07" password="dinaBA81"/>
        <sql:query dataSource="${myDS}" var="allUsers" sql="select * from Customer"/>
         <c:if test="${ not empty allUsers }">
            <table border="1" cellpadding="6" cellpadding="6"> 
                <tr>
                    <c:forEach items="${allUsers.columnNames}" var="columnnames">
                    <th> ${columnnames}</th>
                    </c:forEach>
                </tr>
                <c:forEach items="${allUsers.rowsByIndex}" var="customer" >
                    <tr><td>${customer[0]}</td>
                        <td>${customer[1]}</td>
                        <td>${customer[2]}</td>
                        <td>${customer[3]}</td>
                        <td> ${customer[4]}</td>
                        <td>${customer[5]}</td>
                    </tr>
              
            </c:forEach>
                      </table>
        </c:if>
    </body>
</html>
