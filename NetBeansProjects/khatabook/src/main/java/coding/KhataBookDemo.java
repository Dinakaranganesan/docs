/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coding;

import dao.mysql.CustomerDaoImpl;
import dao.mysql.LineItemDaoImpl;
import dao.mysql.OrderDaoImpl;
import dao.mysql.PaymentDaoImpl;
import dao.mysql.ProductDaoImpl;
import idao.CustomerDao;
import idao.LineItemDao;
import idao.OrderDao;
import idao.PaymentDao;
import idao.ProductDao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customerr;
import model.Inventoryy;
import model.LineItemss;
import model.Orderrs;

/**
 *
 * @author bas200181
 */
public class KhataBookDemo {

  static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  static final String RESET = "\033[0m";
  static final String PURPLE_BOLD = "\033[1;34m";

  public static void main(String[] args) throws IOException {

    try {
      CustomerDao cdi = new CustomerDaoImpl();
      ProductDao pd = new ProductDaoImpl();
      OrderDao od = new OrderDaoImpl();
      LineItemDao ld = new LineItemDaoImpl();
      PaymentDao pdi = new PaymentDaoImpl();

      String url = "jdbc:mysql://bassure.in:3306/dina_b8_db";
      String uname = "dina_07";
      String pass = "dinaBA81";
      Connection con = DriverManager.getConnection(url, uname, pass);
      boolean flag = true;
      boolean flag1 = true;
      boolean flag2 = true;
      boolean flag3 = true;

      while (flag) {
//            System.out.println("~".repeat(14));
        System.out.print("+" + "-".repeat(10) + "+");
        System.out.println("");

        System.out.println("1.Customer");
        System.out.println("2.Inventory");
        System.out.println("3.Statistics");
        System.out.println("4.Exit");
//            System.out.println("~".repeat(14));
//            System.out.println();
        System.out.println("*".repeat(14));
        System.out.println("Select Option");
        int se = 0;
        try {
          se = Integer.parseInt(input.readLine());
        } catch (Exception t) {
          System.err.println(PURPLE_BOLD + "Enter the number 1 to 4" + RESET);
        }
        if (se > 0 && se <= 4) {
          switch (se) {
            case 1: {
              flag2 = true;
              while (flag2) {
                System.out.println("");
                System.out.println("=".repeat(25));
                System.out.println("Select Options");
                System.out.println("1.Place Order");
                System.out.println("2.Accept Payment");
                System.out.println("3.Add customer");
                System.out.println("4.View customer");
                System.out.println("5.Update");
                System.out.println("6.View All Customers");
                System.out.println("7..View Ordered Details");
                System.out.println("8.MainMenu");
                System.out.println("=".repeat(25));
                int cu = Integer.parseInt(input.readLine());

                switch (cu) {
                  case 1: {
                    LineItemss[] lim = new LineItemss[0];
                    try {
                      System.out.println("Enter the Phone Number");
                      String phone_no = input.readLine();
                      Customerr cus = cdi.getCusdetails(phone_no);

                      if (cus != null) {
                        System.out.println("Enter the OrderID");
                        int order_id = Integer.parseInt(input.readLine());

                        //System.out.println("Enter the date");
                        Date l = Date.valueOf(LocalDate.now());
                        Orderrs or = new Orderrs();
                        or.setCusId(cus.getCusId());
                        or.setOrderID(order_id);
                        pd.viewAll();
                        double sum = 0;
                        boolean add = true;

                        while (add) {
                          lim = Arrays.copyOf(lim, lim.length + 1);
                          System.out.println("Enter the Product ID");
                          int productId = Integer.parseInt(input.readLine());
                          Inventoryy inv1 = pd.getProductDetails(productId);
                          System.out.println("Enter the quantity");
                          int quantity = Integer.parseInt(input.readLine());
                          double buyPrice = quantity * inv1.getPrice();
                          sum += buyPrice;
                          lim[lim.length - 1] = new LineItemss(order_id, productId, inv1.getProName(), quantity, buyPrice);
                          // System.out.println(+row_a + "");
                          int a1 = inv1.getQuantity() - quantity;
                          Inventoryy inv2 = new Inventoryy();
                          inv2.setProductId(productId);
                          inv2.setQuantity(a1);
                          pd.stockUpdate(inv2);
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
                        or.setTotalprice(sum);
                          od.addOrder(or, lim);
                        double c_balance = sum + cus.getCusBal();
                        Customerr cus1 = new Customerr();
                        cus1.setCusId(cus.getCusId());
                        cus1.setCusBal(c_balance);
                        cdi.updateCustomerBalance(cus1);
                        System.out.println("row updated");
                     
                               }

                    } catch (Exception e) {
                      e.printStackTrace();
                    }
                    break;

                  }
                  case 2: {
                    pdi.pay(con);
                    break;
                  }
                  case 3: {
                    try {

                      boolean check = true;
                      System.out.println("Enter the CustomerId");
                      int cusId = Integer.parseInt(input.readLine());
                      System.out.println("Enter the Customer Name");
                      String cusName = input.readLine();
                      System.out.println("Enter the Mobile Number");
                      String phoneNo = "";
                      while (check) {
                        phoneNo = input.readLine();
                        if ((phoneNo.length() == 10) && (phoneNo.chars().filter(Character::isDigit).count() == phoneNo.length())) {
                          check = false;
                        } else {
                          System.err.println("\u26A0 Enter a Phone Number");
                        }
                      }
                      System.out.println("Enter the Address ");
                      String cusAddress = input.readLine();
                      System.out.println("Enter the Aaadhar Number");
                      String aadhaar = input.readLine();
                      double cusBalance = 0;
                      Customerr c = new Customerr(cusId, cusName, phoneNo, aadhaar, cusAddress, cusBalance);
                      cdi.addCustomer(c);
                      break;
                    } catch (IOException ioe) {
                      ioe.printStackTrace();
                    }
                  }
                  case 4: {
                    try {
                      System.out.println("Enter the MobileNumber:");
                      String view_mob = input.readLine();
                      Customerr c = new Customerr();
                      c.setPhoneNo(view_mob);
                      cdi.viewCustomer(c);
                    } catch (IOException ioe) {
                      ioe.printStackTrace();
                    }
                    break;
                  }

                  case 5: {
                    try {

                      while (flag1) {
                        System.out.println("1. To update address");
                        System.out.println("2.Exit");
                        int up_Mobile = Integer.parseInt(input.readLine());

                        switch (up_Mobile) {
                          case 1:
                            System.out.println("Enter the Mobile Number");
                            String mob_no = input.readLine();
                            // cdi.viewCustomer();
                            System.out.println("");
                            System.out.println("Enter the New Address to change");
                            String new_addr = input.readLine();
                            Customerr cr = new Customerr();
                            cr.setPhoneNo(mob_no);
                            cr.setCusAddress(new_addr);
                            cdi.updateCustomer(cr);
                            break;
                          case 2:
                            flag1 = false;
                            break;
                        }
                      }
                    } catch (Exception e) {
                      System.out.println(e);
                      e.printStackTrace();
                    }
                    break;
                  }
                  case 6: {

                    cdi.viewAll();
                    break;
                  }
                  case 7: {

                    od.show();
                    break;
                  }

                  case 8: {
                    flag2 = false;
                    //mainMenu();
                    break;
                  }

                  default:
                    System.out.println("Please select valid Option");
                    break;
                }

              }
              break;
            }
            case 2: {
              do {
                System.out.println("");
                System.out.println("1.View  Product ");
                System.out.println("2.Add Products");
                System.out.println("3.Update Products");
                System.out.println("4.View all products");
                System.out.println("5.Exit");
                int in_select = Integer.parseInt(input.readLine());
                switch (in_select) {
                  case 1 -> {
                    try {
                      System.out.println("Enter the Product_id");
                      int temp_id = Integer.parseInt(input.readLine());
                      Inventoryy i = new Inventoryy();
                      pd.viewProduct(i);
                    } catch (IOException ioe) {
                      ioe.printStackTrace();
                    }
                  }
                  case 2 -> {
                    try {
                      System.out.println("Enter Product ID");
                      int prodId = Integer.parseInt(input.readLine());
                      System.out.println("Enter the product name");
                      String name = input.readLine();
                      System.out.println("Enter the price");
                      double price = Double.parseDouble(input.readLine());
                      System.out.println("Enter the Quantity");
                      int quantity = Integer.parseInt(input.readLine());
                      Inventoryy inv = new Inventoryy(prodId, name, quantity, price);
                      pd.addProduct(inv);
                    } catch (IOException ioe) {
                      ioe.printStackTrace();
                    }
                  }

                  case 3 -> {
                    System.out.println("Enter the Product id");
                    int product_id = Integer.parseInt(input.readLine());
                    System.out.println("Enter the Quantity to add");
                    int quan = Integer.parseInt(input.readLine());
                    Inventoryy i = new Inventoryy();
                    i.setQuantity(quan);
                    pd.updateProduct(i);
                  }
                  case 4 ->
                    pd.viewAll();

                  case 5 ->
                    flag3 = false;
                }
              } while (flag3);

              break;
            }
            case 3:
              cdi.stats(con);
              break;
            case 4: {
//              Customer.writeCus();
//              Inventory.writeInventory();
              flag = false;
              break;
            }

            default:
              System.out
                      .println("Please select valid Option");
              break;

          }

        } else {
          System.out.println("Invalid Number");
        }

      }
    } catch (SQLException ex) {
      Logger.getLogger(KhataBookDemo.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
