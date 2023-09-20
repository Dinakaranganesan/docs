/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.controller;

import com.khatabook.model.Payment;
import com.khatabook.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bas200181
 */
@Controller
public class PaymentController {
 @Autowired
 PaymentService payservice;
     @GetMapping("/customernumform")
    public String mobileForm() {

        return "/payment/mobileForm";
    }
    
     @PostMapping("/payment")
    public String paymentForm(@RequestParam(name="getmobile") String mobile,ModelMap model) {
       model.addAttribute("customer",payservice.getDetails(mobile));
        return "/payment/paymentForm";
    }
    
      @PostMapping("/updatepayment")
      @ResponseBody
    public int updatePayment(@RequestParam(name = "cusId")int cusId,
    @RequestParam(name="payamount")double paidamount,
            @RequestParam(name="payid")int payid ,
            @RequestParam(name="prevbalance")double prevbalance){
        double updateBalance=prevbalance-paidamount;
        
       return payservice.payment(cusId, new Payment(payid,cusId,paidamount,null), paidamount);
    }
    
}
