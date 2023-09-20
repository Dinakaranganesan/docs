<%-- 
    Document   : actions
    Created on : 31-Mar-2023, 3:38:32 pm
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            .box{
                border-style: dashed ;
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="c1" class="model.Customerr" scope="request">
        </jsp:useBean>
        <jsp:setProperty name="c1" property="cusId" param="cusId" ></jsp:setProperty>
        <jsp:getProperty name="c1" property="cusId" ></jsp:getProperty>
        <jsp:setProperty name="c1" property="cusName" param="cusName" ></jsp:setProperty>
        <jsp:getProperty name="c1" property="cusName" ></jsp:getProperty>
        <jsp:setProperty name="c1" property="phoneNo" param="phoneNo" ></jsp:setProperty>
        <jsp:getProperty name="c1" property="phoneNo" ></jsp:getProperty>
        <jsp:setProperty name="c1" property="cusAddress" param="cusAddress" ></jsp:setProperty>
        <jsp:getProperty name="c1" property="cusAddress" ></jsp:getProperty>
        <jsp:setProperty name="c1" property="cusAadhaar" param="cusAadhaar" ></jsp:setProperty>
        <jsp:getProperty name="c1" property="cusAadhaar" ></jsp:getProperty>
            <%--  <jsp:getProperty name="c1" property="cusId">
                 
                      </jsp:useBean>
          <
  \                    <jsp:element name="span"> 
                          <jsp:attribute name="style" trim="true">
                              color:red;font-size:60px;
                          </jsp:attribute>
                          <jsp:attribute name="cls" trim="true">
                              box
                          </jsp:attribute>
                          <jsp:body>Helloo</jsp:body>
                      </jsp:element>--%>
        </body>       
    </html>
