/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.khatabook.idao;

import java.util.ArrayList;
import java.util.List;
import com.khatabook.model.AddCart;
import com.khatabook.model.Customer;
import com.khatabook.model.OrderedDetails;

/**
 *
 * @author bas200181
 */
public interface CustomerDao {
     public ArrayList<OrderedDetails> viewDetails(int cusId);
  public Customer viewCustomer(int id);
  
    public List<AddCart> viewAllPending();

    public Customer viewCustomerWeb(int cusId);

    public int getCustomerId(String name);

    public int addCustomer(Customer c);

    public int updateCustomer(String name,String address,String phoneNo,int cusId);

    public Customer viewCustomer(String MobileNumber);

    public List<Customer> viewAll();

    public int updateCustomerBalance(Customer c);

    public Customer getCusdetails(String phone_no);

    public ArrayList<OrderedDetails> viewDetails();

    public int updateCustomerBalance(int cusId, double amount);

    public int updateCustomerMobile(String phone, int cusId);

    public int updateCustomerAddress(String address, int cusId);

    public Customer getCusdetails(int cusId);
    
    public List<Customer> viewMaxBal();
        
}
