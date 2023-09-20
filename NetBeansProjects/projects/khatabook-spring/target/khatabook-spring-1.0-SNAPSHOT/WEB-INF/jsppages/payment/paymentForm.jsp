<%-- 
    Document   : paymentForm
    Created on : 14-Jun-2023, 11:08:01 am
    Author     : bas200181
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="updatepayment?cusId=${customer.cusId}"method="post">
  <label for="Name">Customer Name</label><br><br>
  <input type="text" name="name"  value="${customer.cusName}" required><br><br>
    <label for="Prev Balance">Previous Balance</label><br><br>
    <input type="text" name="prevbalance"value="${customer.cusBal}" readonly="true" required><br><br>
    <label for="Payabale Amount">Enter the amount to pay</label><br><br>
  <input type="text" name="payamount"  required><br><br>
  <label for="PaymentId">Payment Id</label><br><br>
  <input type="text" name="payid"  required><br><br>
  <input type="submit">
</form>
        
    </body>
</html>
