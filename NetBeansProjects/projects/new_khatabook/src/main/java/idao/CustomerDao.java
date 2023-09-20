/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package idao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Customerr;
import model.OrderedDetails;

/**
 *
 * @author bas200181
 */
public interface CustomerDao {

  public int addCustomer(Customerr c);

  public int updateCustomer(Customerr customerr);

  public List<Customerr> viewCustomer(String MobileNumber);

  public List<Customerr> viewAll();

 // public void stats(Connection con);

  public int updateCustomerBalance(Customerr c);

  public Customerr getCusdetails(String phone_no);

  public ArrayList<OrderedDetails> viewDetails();

  public Customerr viewCustomerr(String mobileNumber);
  
  public int updateCustomerBalance(int cusId,double amount) ;
}

