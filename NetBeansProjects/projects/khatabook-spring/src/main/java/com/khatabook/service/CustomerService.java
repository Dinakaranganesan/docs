/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.service;

import com.khatabook.idao.KhataBookDao;
import com.khatabook.model.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bas200181
 */
@Service
public class CustomerService {
    @Autowired
    KhataBookDao kb;
    public List<Customer> getAll() {
        return kb.getCustomerDaoObj().viewAll();
    }
    public int addCustomer(Customer c){
        return kb.getCustomerDaoObj().addCustomer(c);
    }
     public Customer viewSingle(String mob) {
        return kb.getCustomerDaoObj().viewCustomer(mob);
    }
     
      public Customer getSingle(int id) {
        return kb.getCustomerDaoObj().viewCustomer(id);
    }
     public int updCustomer(String name, String address,String phoneNo,int cusId){
         return kb.getCustomerDaoObj().updateCustomer(name, address, phoneNo, cusId);
     }
}

