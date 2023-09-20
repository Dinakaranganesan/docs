<%-- 
    Document   : HandledException
    Created on : 17-Feb-2023, 3:22:38 pm
    Author     : bas200181
--%>
<%@page import="import java.lang.ArithmeticException" %>
<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><%
              try{
              out.println("handled");
                    }
              catch(ArithmeticException ae)
       {%>
       <%= "Not divided by zero" %>
    <%}
    %>
    </body>
</html>
