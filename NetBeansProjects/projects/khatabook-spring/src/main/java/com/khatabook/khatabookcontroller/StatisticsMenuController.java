/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.khatabook.khatabookcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author bas200181

*/
  @Controller
public class StatisticsMenuController {
 @GetMapping("/statsmenupage")
    public String statsMenu(){
        return "khatabookmenu/statsMenu";
    }
    
}
