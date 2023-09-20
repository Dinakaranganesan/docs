/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.service;

import com.khatabook.cusomerrepository.Statistics;
import com.khatabook.idao.KhataBookDao;
import com.khatabook.model.Customer;
import com.khatabook.model.ShowOrders;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bas200181
 */
@Service
public class StatisticsService {

    @Autowired
    KhataBookDao kb;
    @Autowired
    Statistics s;

    public List<Customer> getMax() {
        return kb.getCustomerDaoObj().viewMaxBal();
    }

    public List<Customer> paid() {
        return s.getPaidCustomer();
    }
    public List<Customer> Unpaid() {
        return s.getUnPaidCustomer();
    }
     public ShowOrders ordersbyDate(Date d){
        return kb.getOrderDaoObj().viewCustomerOrdersByDate(d);
    }
}
