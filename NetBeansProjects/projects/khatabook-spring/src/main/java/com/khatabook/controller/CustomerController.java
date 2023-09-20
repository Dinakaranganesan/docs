/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.controller;

import com.khatabook.model.Customer;
import com.khatabook.service.CustomerService;
import java.util.List;
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
public class CustomerController {

    @Autowired
    CustomerService cs;
//
//    @GetMapping("/view")
//    @ResponseBody
//    public String showAll() {
//        return cs.getAll().toString();
//    }

    @GetMapping("/user")
    // @ResponseBody
    public String getCustomer(ModelMap data) {
        List<Customer> list = cs.getAll();
        data.addAttribute("customer1", list);
        return "/customer/customerView";
    }

    @GetMapping("/addcustomer")
    // @ResponseBody
    public String addCustomer() {
        return "/customer/addCustomer";
    }

    @PostMapping("/add")
    @ResponseBody
    public Boolean addCus(@RequestParam(name = "customerid") Integer cusId, @RequestParam(name = "customername") String name,
            @RequestParam(name = "customernum") String number,
            @RequestParam(name = "customeraadhar") String aadhaar,
            @RequestParam(name = "customeradd") String address) {
        return cs.addCustomer(new Customer(cusId, name, number, aadhaar, address, 0.00)) > 0;
    }

    @GetMapping("/single")
    // @ResponseBody
    public String moveToJsp() {
        return "/customer/viewSingleCustomer";
    }

    @PostMapping("/viewone")
    public String getSingleCustomer(ModelMap data, @RequestParam(name = "getmob") String mobile) {
        Customer cus = cs.viewSingle(mobile);
        data.addAttribute("customer", cus);
        return "/customer/viewSingleCustomerPage";
    }

    @GetMapping("/updateform")
    // @ResponseBody
    public String uf(ModelMap data, @RequestParam(name = "id") int cusId) {
        data.addAttribute("customer", cs.getSingle(cusId));
        return "/customer/updateForm";
    }

    @PostMapping("/upd")
    @ResponseBody
    public int updCus(@RequestParam(name = "id") int cusId, @RequestParam(name = "name") String name, @RequestParam(name = "address") String address, @RequestParam(name = "phoneno") String phone) {
        return cs.updCustomer(name, address, phone, cusId);
    }
}
