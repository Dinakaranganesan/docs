<%-- 
    Document   : statsMenu
    Created on : 16-Jun-2023, 3:44:00 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>customermenupage</title>
        <style>
            .cus{
                height:20px;
                width:30px;
                justify-content: center;
                font-size: 25px;
               
                
            }
            
            .box{
                 /*border: 3px solid black;*/
                width: 100%;
                height:1000px;
                justify-content: center;
                display:flex;
                align-items: center;
                
                    
            }
            
            body{
                background-color:#FAF884;
            }
            .c{
                border: 3px solid black;
                height: 650px;
                width: 500px;
                justify-content: center;
                 background-color: brown;
                 align-items: center;
                
            }
            a{
                 text-decoration: none;
            }
            .c > div{
                
                background-color: white;
                width: 480px;
                 
                margin: 10px;
                text-align: center;
                line-height: 75px;
                font-size: 20px;
                
                box-shadow: 2px 5px 10px rgba(0,0,0,0.5);
            }
            
            </style>
    </head>
    <body>
        <div class="box">
        <div class="c">
            <div> <a href="paid">PAID CUSTOMER</a></div><br>
            <div ><a href ="unpaid">UNPAID CUSTOMER</a></div><br>
              <div ><a href ="maxbal">MAX BALANCE </a></div><br>
            <div ><a href ="ordersbydate">ORDERS BETWEEN PARTICULAR DATE</a></div><br>
             <div ><a href ="ordersbetweendate">ORDER BETWEEN DATES</a></div><br>
             <form action=""><input type='submit' value='back'></form>     
        </div>
        </div>
    </body>
</html>
