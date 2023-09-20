<%-- 
    Document   : orderJsp
    Created on : 13-Jun-2023, 3:59:31 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
         <style>  
            table {
                border-collapse: collapse;
            }
            th, td {
                padding: 0.5rem;
                border: 1px solid #ccc;
            }
            th {
                text-align: left;
            }
            .line-total {
                text-align: right;
            }
            button {
                background-color: #008CBA;
                color: white;
                padding: 0.5rem;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            button:hover {
                background-color: #006F8E;
            }
            .btn{
                height:40px;
            }
        </style> 
    </head>
    <body> 
       <div class="tab">
           <table border="1" cellpadding="6"> 
                <tr class="tc">
                    <th>PRODUCT ID</th>
                    <th>PRODUCT NAME</th>
                    <th>QUANTITY</th>
                    <th>PRICE</th>
                    
                </tr>
                <tr class="data">
                <c:forEach items="${product}" var="product">
                    <tr>
                        <td><b>${product.getProductId()}</</b></td>
                        <td><b>${product.getProName()}</b></td>
                        <td><b>${product.getQuantity()}</b></td>
                        <td><b>${product.getPrice()}</b></td>
                    </tr>
                </c:forEach>
            </table>

       </div>
        <h1>Add Orders</h1>  
        <form  action="addorder" id="add-order-form" method="post">    
            <div>     
                <label for="customer-id">Customer PhoneNumber</label>     
                <input type="text" id="customer-id" name="customer-ph" required>   
            </div> 
            <br>
            <div>      
                <label for="order-id">Order ID:</label>     
                <input type="text" id="order-id" name="order-id" required>   
            </div>  
            <br>
           
            <h2>Line Items</h2>   
            <table> 

                <thead>       
                    <tr>         
                        <th>Product ID</th>         
                        <th>Quantity</th>        
                    </tr>      
                </thead>
                <td>    
                    <p>ProductID :  
                        <!--                        <button type="button" class="btn btn-success rounded-3" onclick="addProductid()">ProductID</button>-->
                    </p>
                    <div id="authors" name="productid">

                    </div>
                </td>
                <td>
                    <!--<p>Quantity</p> -->
                    <p>Quantity :  
                    </p>
                    <div id="quantity" name="quantity"></div>
                </td> 
            </table>  
            <button type="button" class="btn" onclick="addQuantity()">
                Add More</button>
            <input type="submit">
        </form>
    </body>  
    <script>
        let count = 1;
                       function addProductid() {
                            const holder = document.getElementById("authors");
                            const authorElement = document.createElement("input");
                            const brk = document.createElement("br");
                            authorElement.setAttribute("name", "productid");
                            authorElement.setAttribute("placeholder", "enter the " + count++ + " productID");
                            authorElement.setAttribute("Style", "margin:10px;");
                            holder.appendChild(authorElement);
                            holder.appendChild(brk);
                            authorElement.focus();
                    }
                    let count1 = 1;
                    function addQuantity() {
            addProductid();
                            const hold = document.getElementById("quantity");
                            const mobileElement = document.createElement("input");
                            const brk = document.createElement("br");
                            mobileElement.setAttribute("name", "quantity");
                            mobileElement.setAttribute("placeholder", "enter the " + count1++ + " quantity.");
                            mobileElement.setAttribute("Style", "margin:10px;");
                            hold.appendChild(mobileElement);
                            hold.appendChild(brk);
                            mobileElement.focus();
        }
        </script>
                
</html>
