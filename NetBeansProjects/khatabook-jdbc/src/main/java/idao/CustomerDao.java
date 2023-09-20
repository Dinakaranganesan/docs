/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import java.sql.Connection;
import model.Customerr;

/**
 *
 * @author bas200181
 */
public interface CustomerDao {
  public void addCustomer(Customerr c);
  public void  updateCustomer(Customerr c);
  public void viewCustomer(Customerr c);
   public  void viewAll() ;
  public void stats(Connection con);
  public void updateCustomerBalance(Customerr c);
   public Customerr getCusdetails(String phone_no);
}
