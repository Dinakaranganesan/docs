<%-- 
    Document   : practicejstl
    Created on : 04-Apr-2023, 12:44:35 pm
    Author     : bas200181
--%>


<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib  prefix="fn" uri="jakarta.tags.functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-color:#FAF884;
            }
        </style>
    </head>

    <body>
        <h1> CORE TAGS</h1>
        <c:out value="The sum of 2 + 5 is ${2+5}"/><br>
        <c:set var="amount" value="${1000}"/>
        <c:out value=" The Amount is :${amount}"/><br>        
        <c:set var="Int"  value="${199}" scope="session"/><br>
        Before Removal <c:out value=" ${Int}"/><br>
        <c:remove var="Int" scope="session"/>
        After Removal <c:out value="${Int}"/><br>
        <c:if test="true">
            TRUE 
        </c:if><br>
        <c:if test="true">
            FALSE
        </c:if><br>
        <c:set var="salary" scope="session" value="${2000}"/>
        <c:choose>
            <c:when test="${salary<=0}">
                Salary is Low
            </c:when>
            <c:when test="${salary>0}">
                Salary is High
            </c:when>
            <c:otherwise >
                Default
            </c:otherwise>
        </c:choose><br>
        <c:forEach var="i" begin="1" end="10">
            Iteration<c:out value="${i}"/><br>
        </c:forEach>
        <c:forTokens var="fruit"  items="Apple,Bannana,Custard Apple" delims=",">
            <ul>
                <li> ${fruit}</li>
            </ul>
        </c:forTokens>

        <h1> FUNCTION TAGS </h1>
        <c:set var="stringdata" value="<> JAVA IS A OBJECT ORIENTED PROGRAMMING LANGUAGES <>"/>  
        <c:out value="${stringdata}"/><br>
        <c:if test="${fn:contains(stringdata, IS)}">
            It is there
        </c:if><br>
        <c:if test="${fn:containsIgnoreCase(stringdata,is)}">
            It is there
        </c:if><br>
        The length of the String is:     <c:out value="${fn:length(stringdata)}"/><br>
        <c:out value="${fn:escapeXml(stringdata)}"/><br>
        <h3>Characters</h3>
        &gt <br>
        &lt <br>
        <c:out value="${fn:replace(stringdata, 'J', 'B')}"/><br>
        <c:out value="${fn:toLowerCase(stringdata)}"/><br>
        <c:out value="${fn:trim(stringdata)}"/><br>
        <c:out value="${fn:indexOf(stringdata, 'J')}"/><br>
        <c:out value="${fn:startsWith(stringdata, '<')}"/><br>

    </body>
</html>
