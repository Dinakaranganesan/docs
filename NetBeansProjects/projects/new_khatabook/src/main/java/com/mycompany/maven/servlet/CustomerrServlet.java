package com.mycompany.maven.servlet;

import dao.mysql.KhataBookDaoImpl;
import idao.KhataBookDao;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.Customerr;
import model.Inventoryy;
import model.LineItemss;
import model.OrderedDetails;
import model.Orderrs;
import model.Payment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bas200181
 */
public class CustomerrServlet extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    KhataBookDao kbd = new KhataBookDaoImpl();
    PrintWriter pw = response.getWriter();
    if (this.getServletContext().getInitParameter("Database").equals("mysql")) {
//  pw.print(request.getParameter("s"));
      int i = Integer.parseInt(request.getParameter("s"));
      switch (i) {
        case 1 -> {
          Customerr cus = new Customerr();
          int cus_id = Integer.parseInt(request.getParameter("customerid"));
          cus.setCusId(cus_id);
          cus.setCusName(request.getParameter("customername"));
          cus.setPhoneNo(request.getParameter("customernum"));
          cus.setCusAadhaar(request.getParameter("customeraadhar"));
          cus.setCusAddress(request.getParameter("customeradd"));
          pw.println(cus);
          int k = kbd.getCustomerDaoObj().addCustomer(cus);
          if (k != 0) {
            pw.print("<h1>Data Inserted</h1>");
          } else {
            pw.print("<h1>Data Not Inserted</h1>");
          }
        }
        case 2 -> {
          List<Customerr> view = kbd.getCustomerDaoObj().viewAll();
          pw.print(" <h1>Customer Details <h1> ");
          pw.print(" <table border=1 rules=all>  ");
          pw.print(" <tr>");
          pw.println(" <th>CUSTOMER ID</th> ");
          pw.println(" <th>CUSTOMER NAME</th> ");
          pw.println("<th>MOBILE</th>");
          pw.println(" <th>ADDRESS</th>");
          pw.println(" <th>ADHAAR NO</th> ");
          pw.println(" <th>CUSTOMER BALANCE</th>");
          pw.println(" </tr>");
          for (Customerr cu : view) {
            pw.println(" <tr> ");
            pw.println(" <td>" + cu.getCusId() + "</td>");
            pw.println(" <td>" + cu.getCusName() + "</td>");
            pw.println(" <td>" + cu.getPhoneNo() + "</td>");
            pw.println(" <td>" + cu.getCusAddress() + "</td>");
            pw.println(" <td>" + cu.getCusAadhaar() + "</td>");
            pw.println(" <td>" + cu.getCusBal() + "</td>");
            pw.println(" </tr> ");
          }
          pw.print(" </table >  ");
          pw.print("""   
                                 <form action='cusmenu.html'><input type='submit' value='back'></form>                                  """);
        }
        case 3 -> {
          //  pw.print(request.getParameter("getmob"));
          List<Customerr> viewCustomer = kbd.getCustomerDaoObj().viewCustomer(request.getParameter("getmob"));
          pw.print(" <h1>Customer Details <h1> ");
          pw.print(" <table border=1 rules=all>  ");
          pw.print(" <tr>");
          pw.println(" <th>CUSTOMER ID</th> ");
          pw.println(" <th>CUSTOMER NAME</th> ");
          pw.println("<th>MOBILE</th>");
          pw.println(" <th>ADDRESS</th>");
          pw.println(" <th>ADHAAR NO</th> ");
          pw.println(" <th>CUSTOMER BALANCE</th>");
          pw.println(" </tr>");
          for (Customerr cu : viewCustomer) {
            pw.println(" <tr> ");
            pw.println(" <td>" + cu.getCusId() + "</td>");
            pw.println(" <td>" + cu.getCusName() + "</td>");
            pw.println(" <td>" + cu.getPhoneNo() + "</td>");
            pw.println(" <td>" + cu.getCusAddress() + "</td>");
            pw.println(" <td>" + cu.getCusAadhaar() + "</td>");
            pw.println(" <td>" + cu.getCusBal() + "</td>");
            pw.println(" </tr> ");
          }
          pw.print(" </table >  ");
          pw.print("""   
                                 <form action='cusmenu.html'><input type='submit' value='back'></form>                                  """);

        }
        case 4 -> {
//          pw.print(request.getParameter("mobile"));
//          pw.print(request.getParameter("addr"));
          Customerr c = new Customerr();
          c.setPhoneNo(request.getParameter("mobile"));
          c.setCusAddress(request.getParameter("addr"));
          int update = kbd.getCustomerDaoObj().updateCustomer(c);
          if (update != 0) {
            pw.print("Data updated Successfully");
          } else {
            pw.print("Not updated");
          }

        }

        case 5 -> {
          boolean d = false;
          int b = 0;
          String phone = request.getParameter("customer-ph");
          int orderid = Integer.parseInt(request.getParameter("order-id"));
          String[] proid = request.getParameterValues("productid");
          String[] quantity1 = request.getParameterValues("quantity");
          Orderrs or = new Orderrs();
//                                  pw.println(phone);
//                                  pw.println(orderid);
//                                  pw.println(Arrays.deepToString(proid));
//                                  pw.println(Arrays.deepToString(quantity1));
          LineItemss[] lim = new LineItemss[proid.length];
          //String phone_no = phone;
          Customerr cus = kbd.getCustomerDaoObj().getCusdetails(phone);
          if (Objects.nonNull(cus)) {
            int order_id = orderid;
            //pw.print(cus);
            //System.out.println("ulla varuthu");
            //System.out.println("Enter the date");
            Date l = Date.valueOf(LocalDate.now());
            or.setCusId(cus.getCusId());
            or.setOrderID(order_id);
            double sum = 0;
            boolean add = true;

            for (int j = 0; j < proid.length; j++) {

              int productId = Integer.parseInt(proid[j]);
              Inventoryy inv1 = kbd.getProductDaoObj().getProductDetails(productId);
              int quantity = Integer.parseInt(quantity1[j]);
              double buyPrice = quantity * inv1.getPrice();
              sum += buyPrice;
              lim[j] = new LineItemss(order_id, productId, inv1.getProName(), quantity, buyPrice);
              System.out.println("ulla varuthu");
              int a1 = inv1.getQuantity() - quantity;
              Inventoryy inv2 = new Inventoryy();
              inv2.setProductId(productId);
              inv2.setQuantity(a1);
              kbd.getProductDaoObj().stockUpdate(inv2);
              // pw.print(lim[j].toString());
            }

            or.setTotalprice(sum);

            double c_balance = sum + cus.getCusBal();
            Customerr cus1 = new Customerr();
            cus1.setCusId(cus.getCusId());
            cus1.setCusBal(c_balance);
//                        pw.print(cus1);
//                        pw.print(or);

            b = kbd.getCustomerDaoObj().updateCustomerBalance(cus1);
            d = kbd.getOrderDaoObj().addOrder(or, lim);

          } else {
            pw.print("""
                                <h1>Invalid Phone Number</h1>
                                 """);
          }
          if (d && b > 0) {
            pw.print("""
                            ORDER PLACED
                                 """);
          } else {
            pw.print("not done");

          }

        }
        case 6 -> {
          ArrayList<OrderedDetails> view = kbd.getCustomerDaoObj().viewDetails();

          pw.print(" <h1>Ordered Details <h1> ");
          pw.print(" <table border=1 rules=all>  ");
          pw.print(" <tr>");
          pw.println(" <th>CUSTOMER ID</th> ");
          pw.println(" <th>CUSTOMER NAME</th> ");
          pw.println("<th>ORDER ID</th>");
          pw.println(" <th>ORDERED DATE</th>");
          pw.println(" <th>TOTAL AMOUNT</th> ");
          pw.println(" </tr>");
          for (OrderedDetails cu : view) {
            pw.println(" <tr> ");
            pw.println(" <td>" + cu.getCusId() + "</td>");
            pw.println(" <td>" + cu.getCusName() + "</td>");
            pw.println(" <td>" + cu.getOrderId() + "</td>");
            pw.println(" <td>" + cu.getOrderDate() + "</td>");
            pw.println(" <td>" + cu.getTotalAmount() + "</td>");
            pw.println(" </tr> ");
          }
          pw.print(" </table >  ");
          pw.print("""   
          <form action='cusmenu.html'><input type='submit' value='back'></form>                                  """);
        }
        case 7 -> {
          ArrayList<OrderedDetails> view = kbd.getCustomerDaoObj().viewDetails();

          pw.print(" <h1>Ordered Details <h1> ");
          pw.print(" <table border=1 rules=all>  ");
          pw.print(" <tr>");
          pw.println(" <th>CUSTOMER ID</th> ");
          pw.println(" <th>CUSTOMER NAME</th> ");
          pw.println("<th>ORDER ID</th>");
          pw.println(" <th>ORDERED DATE</th>");
          pw.println(" <th>TOTAL AMOUNT</th> ");
          pw.println(" </tr>");
          for (OrderedDetails cu : view) {
            pw.println(" <tr> ");
            pw.println(" <td>" + cu.getCusId() + "</td>");
            pw.println(" <td>" + cu.getCusName() + "</td>");
            pw.println(" <td>" + cu.getOrderId() + "</td>");
            pw.println(" <td>" + cu.getOrderDate() + "</td>");
            pw.println(" <td>" + cu.getTotalAmount() + "</td>");
            pw.println(" </tr> ");
          }
          pw.print(" </table >  ");
          pw.print("""   
          <form action='cusmenu.html'><input type='submit' value='back'></form>                                  """);
        }
        case 8 -> {
          Customerr cus = kbd.getCustomerDaoObj().viewCustomerr(request.getParameter("customer-ph"));
          pw.print(cus);
          int paymentId = Integer.parseInt(request.getParameter("pay-id"));
          double getEnteredAmount = Double.parseDouble(request.getParameter("amount"));
          Payment p = new Payment();
          p.setPaymentId(paymentId);
          p.setCusId(cus.getCusId());
          p.setAmount(getEnteredAmount);
          int s = kbd.getPaymentDaoObj().pay(p);
          int updateBalance = kbd.getCustomerDaoObj().updateCustomerBalance(cus.getCusId(), getEnteredAmount);
          if (s != 0 && updateBalance != 0) {
            pw.print("Payment Done Successfulyy");

          } else {
            pw.print("Failed");

          }

        }

      }
    }
  }
}
