/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring.boot.app;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author bas200181
 */
@Controller
public class DemoController {
    @GetMapping("hello")
            public String getGreeting(ModelMap model){
                model.addAttribute("greet","hello its me");
                return "demo";
                 }
}
