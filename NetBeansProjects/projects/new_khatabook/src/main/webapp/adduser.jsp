<%-- 
    Document   : adduser
    Created on : 11-Apr-2023, 5:05:05 pm
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
        <sql:transaction dataSource="${myDS}">
            
            <sql:update sql="insert into Customer(customer_id,customer_name,customer_phoneno,customer_aadhar,cus_address) values(0,?,?,?,?)">
                <sql:param value="${param.name}"/>
                <sql:param value="${param.number}"/>
                <sql:param value="${param.adhar}"/>
                <sql:param value="${param.aadr}"/>
            </sql:update>
        </sql:transaction>
        <c:redirect url="sqltags.jsp"/>

    </body>
</html>
