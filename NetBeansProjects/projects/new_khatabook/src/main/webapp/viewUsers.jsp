<%-- 
    Document   : viewUsers
    Created on : 27-Mar-2023, 3:06:16 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Customerr,java.util.*" errorPage="handler.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% if(request.getAttribute("customerlist")!=null)
        {%>
        <table border="1" cellpadding="6" cellpadding="6"> 
            <tr>
                <th>CustomerId</th>
                <th>CustomerName</th>
                <th>CustomerPhoneno</th>
                <th>CustomerAdhaar</th>
                <th>CustomerAddress</th>
                <th>CustomerBalance</th>
            </tr>
            <%
                List<Customerr> ls=(List<Customerr>)request.getAttribute("customerlist");
                for(Customerr cus:ls)
            %>
            <tr><td><%=cus.getCusId()%></td>
                <td><%=cus.getCusName()%></td>
                <td><%=cus.getPhoneNo()%></td>
                <td><%=cus.getCusAddress()%></td>
                <td><%=cus.getCusBal()%></td>
            </tr>
        </table>
       <%}
else{
throw new RuntimeException();
}
}
       %>

    </body>
</html>
