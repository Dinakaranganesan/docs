<%-- 
    Document   : orderdetails
    Created on : 03-Apr-2023, 10:48:18 am
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.OrderedDetails,java.util.*"%>
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
    </head>
    <body>
        <div class="tab">
        <table border="1" cellpadding="6"> 
            <tr class="tc">
                <th>CUSTOMER ID</th>
                <th>CUSTOMER NAME</th>
                <th>ORDER ID</th>
                <th>ORDERED DATE</th>
                <th>ORDERED AMOUNT</th>
            </tr>
            <%
                List<OrderedDetails> ls=(List<OrderedDetails>)request.getAttribute("orderslist");
                for(OrderedDetails ord:ls){
            %>
            <tr class="data">
                <td><b><%=ord.getCusId()%></b></td>
                <td><b><%=ord.getCusName()%></b></td>
                <td><b><%=ord. getOrderId()%></b></td>
                <td><b><%=ord.getOrderDate()%></b></td>
                <td><b><%=ord.getTotalAmount()%></b></td>
            </tr>
            <%
                }
                %>
        </table>
        
        </div>
        <div class="back"><form action='cusmenu.html'><input type='submit' value='back' class="back1"></form> </div> 

    </body>
</html>

