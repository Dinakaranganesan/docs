/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring.boot.app;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bas200181
 */
@Controller
@ResponseBody
public class UserControllers {

    @Autowired
    UserService us;

    @GetMapping("/getcus")
    public List<Customer> showAll() {
        return us.getall();
    }

    @GetMapping("/getSingleCustomer/{id}")
    public Customer getSingleCustomer(@PathVariable(name = "") int cusId) {
        return us.getSingleCustomer(cusId);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerResponse<Customer>> newCustomer(@Valid @RequestBody Customer cus, BindingResult bres) {
        if (bres.hasErrors()) {
            Map<String, String> allErrors = new HashMap<>();
            bres.getAllErrors().forEach(e -> {
                allErrors.put(((FieldError) e).getField(), e.getDefaultMessage());
                System.out.println(HttpStatusCode.valueOf(HttpStatus.NOT_ACCEPTABLE.value()));
            });
            return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.NOT_ACCEPTABLE.value())).body(new CustomerResponse("425", allErrors, "New user creation failed", cus));
        }
        us.addCustomer(cus);
        return ResponseEntity.ok(new CustomerResponse<>("200", null, "New User Added Successfully", cus));
    }
}
