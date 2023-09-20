<%-- 
    Document   : viewproduct
    Created on : 30-Mar-2023, 11:02:30 am
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*,model.Inventoryy"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body
            {
                background-color: #e0c780;
            }

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
            table
            {
                width: 100%;
            }
        </style>    
    </head>
    <body>
        <table border="1" cellpadding="6" rules="all"  >
            <tr class="tc">
                <th>PRODUCT ID</th>
                <th>PRODUCT NAME</th>
                <th>QUANTITY</th>
                <th>PRICE</th>

            </tr>
            <%
                List<Inventoryy> ls=(List<Inventoryy>)request.getAttribute("productlist");
                for(Inventoryy inv:ls){
            %>
            <tr class="data">
                <td><b><%=inv.getProductId()%></b></td>
                <td><b><%=inv.getProName()%></b></td>
                <td><b><%=inv.getQuantity()%></b></td>
                <td><b><%=inv.getPrice() %></b></td>

            </tr>
            <%
                }
            %>
        </table>

    </div><br>
    <div class="back"><form action='inventorymenu.html'><input type='submit' value='back' class="back1"></form> </div> 
</body>
</html>
