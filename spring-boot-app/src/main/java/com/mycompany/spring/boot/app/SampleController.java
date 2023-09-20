/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring.boot.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author bas200181
 */
@Controller
public class SampleController {
    @PostMapping("/all-authenticated")
    public String allAuntheticated(){
        return"all-secured/home";
    }
        @GetMapping("/all-admin")
    public String allAdmin(){
        return"admin/home";
    }
    
}
