/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Khatajdbc;



import static Khatajdbc.Customer.cus_Details;
import static Khatajdbc.Inventory.avail_products;
import static Khatajdbc.KhataBook.input;
import static Khatajdbc.LineItems.l;
import java.time.LocalDate;
import java.util.Arrays;
//import java.util.Scanner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
// * @author bas200181

public class Orders {
  Inventory i=new Inventory();

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    private int orderId;
    private int cusId;
    private LocalDate date;
    private double totalPrice;
    private String deliveredAddress;
    //  static Scanner s = new Scanner(System.in);
    Orders[] o = new Orders[0];

    public Orders(int orderId, int cusId, LocalDate date, double totalPrice, double balance, String deliveredAddress) {
        this.orderId = orderId;
        this.cusId = cusId;
        this.date = date;
        this.totalPrice = totalPrice;
        this.balance = balance;
        this.deliveredAddress = deliveredAddress;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Orders() {
        super();
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public void setDeliveredAddress(String deliveredAddress) {
        this.deliveredAddress = deliveredAddress;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCusId() {
        return cusId;
    }

    public String getDeliveredAddress() {
        return deliveredAddress;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "orderId :  " + orderId + "\n" + "cutomer ID  :  " + cusId + "\n" + "Date  :   " + date + "\n" + "deliveredAdress : " + deliveredAddress + "\n" + "Total Amount:" + totalPrice;
    }

    public void addOrders() {
      try{
     System.out.println("enter the phone number to add orders");
        String phone_No =input.readLine();
        //for (int j = 0; j < l.length; j++) {
        for (int i = 0; i < avail_products.length; i++) {
            if (cus_Details[i].Phone_no.equals(phone_No)) {
                addItems();
                o = Arrays.copyOf(o, o.length + 1);
                int cusId = cus_Details[i].cus_Id;
                int orderId = l[l.length - 1].getOrderId();
                LocalDate date = LocalDate.now();
                double total = 0;
                for (int j = 0; j < avail_products.length; j++) {
                    for (int k = 0; k < l.length; k++) {
                        if (l[k].getOrderId() == orderId) {
                            if (avail_products[j].product_Id == l[k].getProductId()) {
                                total = total + avail_products[j].price * l[k].getQuantity();
                            }
                        }
                    }
                }
                balance = total;
                System.out.println("enter the deliveryAddress");
                String deliveryAddress = input.readLine();
                System.out.println("yours cusid : " + cusId);
                System.out.println(" yours  orderid:" + orderId);
                o[o.length - 1] = new Orders(orderId, cusId, date, total, balance, deliveryAddress);
                System.err.println("*".repeat(5) + "Order PlacedSuccessfully" + "*".repeat(5));
                System.out.println("\n");
                System.out.println("+".repeat(5) + "Track Your Order" + "+".repeat(5));
            }
        }
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
    }

    //}
    public void addItems() {
        try {
            boolean add = true;
           
            for (int j = 0; j < avail_products.length; j++) {
                System.out.println(avail_products[j]);
                System.out.println(" ");
            }

            int orderId = l.length + 1;
            while (add) {
                l = Arrays.copyOf(l, l.length + 1);
                System.out.println("enter product id");
                int productId = Integer.parseInt(input.readLine());
                System.out.println("enter the quantity");
                int quantity = Integer.parseInt(input.readLine());
                double price = 0;
                for (int j = 0; j < avail_products.length; j++) {
                    if (avail_products[j].product_Id == productId) {
                        price = price + avail_products[j].price * quantity;
                        int t = avail_products[j].quantity - quantity;
                        avail_products[j].quantity = t;

                    }
                }
                l[l.length - 1] = new LineItems(orderId, productId, quantity, price);
                System.out.println("1.To Add more");
                System.out.println("2.Exit");
                System.out.println("enter the option");
                int op = Integer.parseInt(input.readLine());
                switch (op) {
                    case 1:
                        add = true;
                        break;
                    case 2:

                        add = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void show() {
        for (int j = 0; j < o.length; j++) {
            System.out.println(o[j]);
            System.out.println("");
            for (int k = 0; k < l.length; k++) {
              if(o[j].orderId==l[k].getOrderId()){
                System.out.println(l[k]);
                System.out.println("");
              }
            }
        }

    }

    public void pay() {
        try {
            System.out.println("Enter customer");
            int cusid = Integer.parseInt(input.readLine());
            for (int i = 0; i < cus_Details.length; i++) {
                if (cus_Details[i].cus_Id == cusid) {
                    System.out.println("The total amount you need to pay " + o[i].getBalance());
                    System.out.println("Enter the Amount ");
                    double pay = Double.parseDouble(input.readLine());
                     balance = cus_Details[i].cus_balance - pay;
                    System.out.println("Remaining Balance :" + balance);
                    cus_Details[i].cus_balance=balance; 
                    //System.out.println("customer Id"+o[i].getCusId());
                }

            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void sell() throws IOException {
        boolean sts = true;
        try{
        do {
            System.out.println("1.Highest Payment Received In a Day");
            System.out.println("2.Minimum Payment Received In a Day");
            System.out.println("3.Customer Order Based On Date");
            System.out.println("4.Maximum sold product");
            System.out.println("5. Highest Profit product");
            System.out.println("6.Exit");
            System.out.println("Enter the option");
            int st = Integer.parseInt(input.readLine());
            switch (st) {
                case 1: {
                    System.out.println("From Date (yyyy-mm-dd)");
                    String sr = input.readLine();
                    System.out.println("To Date(yyyy-mm-dd)");
                    String ed = input.readLine();
                    LocalDate start = LocalDate.parse(sr);
                    LocalDate end = LocalDate.parse(ed);
                    double maxsell = 0;
                    int ordid = 0;
                    while (!start.isAfter(end)) {
                        for (int j = 0; j < o.length; j++) {
                            if (o[j].getDate().equals(start)) {
                                if (maxsell < o[j].getTotalPrice()) {
                                    maxsell = o[j].getTotalPrice();
                                    ordid = o[j].getOrderId();
                                }
                            }
                        }
                        start = start.plusDays(1);
                    }
                    System.out.println("Highest Payment Recieved ");
                    for (int i = 0; i < o.length; i++) {
                        if (o[i].getOrderId() == ordid) {
                            System.out.println(o[i]);
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("From Date(yyyy-mm-dd)");
                    String sr = input.readLine();
                    System.out.println("To Date(yyyy-mm-dd)");
                    String ed = input.readLine();
                    LocalDate start = LocalDate.parse(sr);
                    LocalDate end = LocalDate.parse(ed);
                    double minsell = o[0].getTotalPrice();
                    int ordid = o[0].getOrderId();
                    while (!start.isAfter(end)) {
                        for (int j = 0; j < o.length; j++) {
                            if (o[j].getDate().equals(start)) {
                                if (minsell >= o[j].getTotalPrice()) {
                                    minsell = o[j].getTotalPrice();
                                    ordid = o[j].getOrderId();
                                }
                            }
                        }
                        start = start.plusDays(1);
                    }
                    System.out.println("=".repeat(5));
                    System.out.println("Minimum Payment Received");
                    for (int i = 0; i < o.length; i++) {
                        if (o[i].getOrderId() == ordid) {
                            System.out.println(o[i]);
                            System.out.println("=".repeat(5));
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("From  Date(yyyy-mm-dd)");
                    String sr = input.readLine();
                    System.out.println("To Date(yyyy-mm-dd)");
                    String ed = input.readLine();
                    LocalDate start = LocalDate.parse(sr);
                    LocalDate end = LocalDate.parse(ed);
                    while (!start.isAfter(end)) {
                        for (int j = 0; j < o.length; j++) {
                            if (o[j].getDate().equals(start)) {
                                System.out.println(o[j]);
                            }
                        }
                        start = start.plusDays(1);
                    }
                    break;
                }
                case 4: {
                    int proid = l[0].getProductId();
                    for (int i = 1; i < l.length; i++) {
                        if (l[i - 1].getQuantity() <= l[i].getQuantity()) {
                            proid = l[i].getProductId();
                        }
                    }
                    for (int i = 0; i < avail_products.length; i++) {
                        if (avail_products[i].product_Id == proid) {
                            System.out.println(avail_products[i]);
                        }
                        System.out.println(" ");
                    }
                    break;
                }
                case 5: {
                    int proid = l[0].getProductId();
                    double profit = 1;
                    for (int i = 1; i < l.length; i++) {
                        if (l[i - 1].getQuantity() <= l[i].getQuantity()) {
                            proid = l[i].getProductId();
                            profit = l[i].getQuantity() * l[i].getPrice();
                        }
                    }
                    for (int i = 0; i < avail_products.length; i++) {
                        if (avail_products[i].product_Id == proid) {
                            System.out.println("Product id :" + avail_products[i].product_Id);
                            System.out.println("Product name :" + avail_products[i].name);
                            System.out.println("Profit amount =" + profit);
                        }
                    }
                    break;
                }
                case 6: {
                    sts = false;
                    break;
                }
                default: {
                    System.err.println("Enter Correct Option");
                    break;
                }
            }

        } while (sts);
    }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }
}
