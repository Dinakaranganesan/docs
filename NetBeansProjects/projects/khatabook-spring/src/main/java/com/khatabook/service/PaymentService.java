/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.service;

import com.khatabook.idao.KhataBookDao;
import com.khatabook.model.Customer;
import com.khatabook.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bas200181
 */
@Service
public class PaymentService {

    @Autowired
    KhataBookDao kb;

    public Customer getDetails(String phoneno) {
        return kb.getCustomerDaoObj().getCusdetails(phoneno);
    }
//
//    public boolean addPayment(double amount, String mobile, int payId) {
//        if (amount > 0) {
//            Customer cus = kb.getCustomerDaoObj().viewCustomer(mobile);
//            int paymentId = payId;
//            double getEnteredAmount = amount;
//            Payment p = new Payment();
//            p.setPaymentId(paymentId);
//            p.setCusId(cus.getCusId());
//            p.setAmount(getEnteredAmount);
//            // int s = kbd.getPaymentDaoObj().pay(p);
//            int s = kb.getPaymentDaoObj().pay(p);
//            int updateBalance = kb.getCustomerDaoObj().updateCustomerBalance(cus.getCusId(), getEnteredAmount);
//            if (s != 0 && updateBalance != 0) {
//                return true;
//
//            } else {
//                return false;
//
//            }
            

    public int payment(int cusId,Payment p,double amount){
        kb.getCustomerDaoObj().updateCustomerBalance(cusId, amount);
        return kb.getPaymentDaoObj().pay(p);
    }
}
