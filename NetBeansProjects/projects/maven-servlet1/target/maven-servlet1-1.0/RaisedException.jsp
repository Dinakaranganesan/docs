<%-- 
    Document   : RaisedException
    Created on : 17-Feb-2023, 3:19:55 pm
    Author     : bas200181
--%>
<%@page errorPage="HandledException.jsp" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%=100/0 %>
    </body>
</html>
