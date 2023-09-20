<%-- 
    Document   : viewallcustomer
    Created on : 29-Mar-2023, 12:24:10 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Customerr,java.util.*"%>
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
                <th>CUSTOMER PHONE NO</th>
                <th>CUSTOMER ADHAAR</th>
                <th>CUSTOMER ADDRESS</th>
                <th>CUSTOMER BALANCE</th>
            </tr>
            <%
                List<Customerr> ls=(List<Customerr>)request.getAttribute("customerlist");
                for(Customerr cus:ls){
            %>
            <tr class="data">
                <td><b><%=cus.getCusId()%></b></td>
                <td><b><%=cus.getCusName()%></b></td>
                <td><b><%=cus.getPhoneNo()%></b></td>
                <td><b><%=cus.getCusAadhaar() %></b></td>
                <td><b><%=cus.getCusAddress()%></b></td>
                <td><b><%=cus.getCusBal()%></b></td>
            </tr>
            <%
                }
                %>
        </table>
        
        </div>
        <div class="back"><form action='cusmenu.html'><input type='submit' value='back' class="back1"></form> </div> 

    </body>
</html>

