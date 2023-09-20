/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.controller;

import com.khatabook.service.StatisticsService;
import java.sql.Date;
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
public class StatisticsController {

    @Autowired
    StatisticsService ss;

    @GetMapping("/maxbal")
    public String max(ModelMap data) {
        data.addAttribute("customer1", ss.getMax());
        return "/customer/statsView";
    }

    @GetMapping("/paid")
    public String paid(ModelMap data) {
        data.addAttribute("customer1", ss.paid());
        return "/customer/statsView";
    }

    @GetMapping("/unpaid")
    public String Unpaid(ModelMap data) {
        data.addAttribute("customer1", ss.Unpaid());
        return "/customer/statsView";
    }

    @GetMapping("/ordersbydate")
    public String getOrderDateForm(ModelMap data) {
        return "/khatabookmenu/orderDateForm";
    }

    @PostMapping("/getorderedetails")
    public String getOrderDateForm(ModelMap data, @RequestParam(name = "order-date") Date dte) {
        data.addAttribute("order", ss.ordersbyDate(dte));
        return "khatabookmenu/orderDetailsView";
    }
}
