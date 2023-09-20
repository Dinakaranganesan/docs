/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import static dao.mysql.Input.input;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import model.Customerr;
import model.Inventoryy;
import model.LineItemss;
import model.Orderrs;

/**
 *
 * @author bas200181
 */
public class Ordd {
  MySqlConnection my=new MySqlConnection();
       Ordd od=new Ordd(); 
   public void addOrder(Connection connection) throws IOException, SQLException {
     LineItemss [] lim = new LineItemss[0];
    ProductDaoImpl pd = new ProductDaoImpl();
    try {
      System.out.println("Enter the Phone Number");
      String phone_no = input.readLine();
   Customerr cus=od.getCusdetails(phone_no);
   
     if(cus!=null){
        System.out.println("Enter the OrderID");
        int order_id = Integer.parseInt(input.readLine());

        System.out.println("Enter the date");
        Date l = Date.valueOf(LocalDate.now());
        Orderrs or = new Orderrs();
      or.setCusId(cus.getCusId());
      or.setTotalprice(cus.getCusBal());
        pd.viewAll();
        double sum = 0;
        boolean add = true;

        while (add) {
          lim=Arrays.copyOf(lim, lim.length+1);
          System.out.println("Enter the Product ID");
          int productId = Integer.parseInt(input.readLine());
          Inventoryy inv1=od.getProductDetails(productId);
              System.out.println("Enter the quantity");
              int quantity = Integer.parseInt(input.readLine());
              double buyPrice = quantity * inv1.getPrice();
              sum += buyPrice;
              lim[lim.length-1]=new LineItemss(order_id, productId, inv1.getProName(), quantity, buyPrice);
              // System.out.println(+row_a + "");
              int a1 = inv1.getQuantity()-quantity;
            Inventoryy inv2=new Inventoryy();
            inv2.setProductId(productId);
            inv2.setQuantity(a1);
            od.stockUpdate(inv2);
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
    
        double c_balance = sum + cus.getCusBal();
      Customerr cus1=new Customerr();
      cus1.setCusId(order_id);
      cus1.setCusBal(c_balance);
        od.updateCustomerBalance(cus1);
        System.out.println(  "row updated");}
      
     }catch(Exception e){
             e.printStackTrace();
             }
   }
   //
public void updateCustomerBalance(Customerr cu) throws SQLException
{
    PreparedStatement ps = my.createConnection().prepareStatement("update Customer set cus_bal=? where customer_id=?");
    ps.setDouble(1, cu.getCusBal());
    ps.setInt(2, cu.getCusId());
    ps.executeUpdate();

}


//
   public Customerr getCusdetails(String phone_no) throws SQLException{
     Customerr cus=null;
     try{
     Connection connection=my.createConnection();
      
      PreparedStatement ps_f = connection.prepareStatement("select * from Customer where customer_phoneno=?");
      ps_f.setString(1, phone_no);
      ResultSet rs = ps_f.executeQuery();
      
      rs.next();
       cus=new Customerr(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6));
     }catch(Exception e){
       e.printStackTrace();
     }
    return cus;
}
   //
   public  Inventoryy getProductDetails(int product_id) {
     Inventoryy inv=null;
    try {
      String viewQuery = "select * from product where product_id=?";
      
      PreparedStatement ps_e = my.createConnection().prepareStatement(viewQuery);
      System.out.println("Enter the Product_id");
      int temp_id = Integer.parseInt(input.readLine());
      ps_e.setInt(1, temp_id);
      ResultSet rs3 = ps_e.executeQuery();
      rs3.next();
      inv=new Inventoryy();
      inv.setProductId(rs3.getInt(1));
      inv.setProName(rs3.getString(2));
      inv.setQuantity(rs3.getInt(3));
      inv.setPrice(rs3.getDouble(4));
    }catch(Exception e){
      e.printStackTrace();
    }
    return inv;
}
   //
   public void stockUpdate(Inventoryy inv) throws SQLException{
      PreparedStatement ps_h = my.createConnection().prepareStatement("update product set quantity=? where product_id=?");
     ps_h.setInt(1, inv.getQuantity());
     ps_h.setInt(2, inv.getProductId());
     ps_h.executeUpdate();
   }
   }
   
