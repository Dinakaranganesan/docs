/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.controller;

import com.khatabook.model.ShowOrders;
import com.khatabook.service.OrderService;
import com.khatabook.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author bas200181
 */
@Controller
public class OrderController {

    @Autowired
    OrderService os;
    @Autowired
    ProductService ps;

    @GetMapping("/vieworders")
    // @ResponseBody
    public String ordersJsp(@RequestParam(name = "id") int cusId, ModelMap m) {
        ShowOrders sh = os.orderDetail(cusId);
        m.addAttribute("order", sh);
        return "/orders/viewCustomerOrders";
    }

    @GetMapping("/order")
    public String orderJsp(ModelMap model) {
        model.addAttribute("product", ps.getAllProducts());             
                return "/orders/orderJsp";
    }
    
    @PostMapping("/addorder")
    public  String addorder(@RequestParam (name = "customer-ph") String phoneNo,
            @RequestParam(name = "order-id")int orderId,
            @RequestParam(name = "productid")String[]productId,
            @RequestParam(name ="quantity" )String[]quantity){
        if(os.addOrder(phoneNo, orderId, productId, quantity)>0)
        {
            return "success";
        }
        else{
            return"error";
        }
    }
    
    
}