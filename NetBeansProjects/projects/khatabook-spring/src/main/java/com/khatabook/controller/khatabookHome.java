/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bas200181
 */
@Controller
public class khatabookHome {
    
    @RequestMapping("/")
    public String khataMenu(){
        return "khatabookmenu/khatabookoption";
    }
    
    
    
    
    
}
