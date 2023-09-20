/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package KhataBook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author bas200181
 */
public class KhataBook {

  static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  //static Scanner s = new Scanner(System.in);
  static KhataBook k = new KhataBook();
  static Customer c = new Customer();
  static Inventory i = new Inventory();
  static Orders o = new Orders();
//  static Order []o= new Order[10];

  static final String RESET = "\033[0m";

  static final String PURPLE_BOLD = "\033[1;34m";

  public static void mainMenu() {
    try {
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
                  case 1:
                    o.addOrders(con);
                    break;
                  case 2:
                    o.pay(con);
                    break;
                  case 3: {

                    c.add(con);
                    break;
                  }
                  case 4: {

                    c.view(con);
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
                            System.out.println("entered....");
                            c.update(con);
                            break;
                          case 2:
                            flag1 = false;
                            break;
                        }
                      }
                    } catch (Exception e) {
                      System.out.println(e);
                    }
                    break;
                  }
                  case 6: {

                    c.viewAll(con);
                    break;
                  }
                  case 7: {

                    o.show(con);
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
                  case 1:
                    Inventory.view_Product(con);
                    break;
                  case 2:
                    Inventory.add_Product(con);
                    break;
                  case 3:
                    Inventory.update_Product(con);
                    break;
                  case 4:
                    Inventory.viewAll(con);
                    break;

                  case 5:
                    flag3 = false;
                    break;
                }
              } while (flag3);

              break;
            }
            case 3:
              o.sell(con);
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
    } catch (Exception e) {
      System.err.println(e);
    }
  }

//  public static void main(String[] args) throws Exception {
////    Customer.readCus();
////    Inventory.readInventory();
//    mainMenu();
//
//  }
}
