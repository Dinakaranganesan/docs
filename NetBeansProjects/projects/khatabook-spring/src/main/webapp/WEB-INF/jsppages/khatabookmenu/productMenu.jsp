<%-- 
    Document   : productMenu
    Created on : 16-Jun-2023, 10:37:09 am
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Inventorymenupage</title>
        <style>
            .cus{
                height:20px;
                width:30px;
                justify-content: center;
                font-size: 25px;
            }
            .box{
                width: 100%;
                height:700px;
                justify-content: center;
                display:flex;
                align-items: center;
            }
            body{
                background-color:#FAF884;
            }
            .c{
                border: 3px solid black;
                height: 450px;
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
                <div> <a href="addproduct">ADD PRODUCT</a></div><br>
                <div ><a href ="products">VIEW ALL PRODUCT</a></div><br>
                <div ><a href ="viewsinglepro">VIEW PARTICULAR  PRODUCT</a></div><br>
            </div>
        </div>
    </body>
</html>


