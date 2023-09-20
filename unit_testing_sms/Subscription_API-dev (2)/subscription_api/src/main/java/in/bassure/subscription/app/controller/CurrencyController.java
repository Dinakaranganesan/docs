/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.bassure.subscription.app.controller;

import in.bassure.subscription.app.model.Currency;
import in.bassure.subscription.app.service.CurrencyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bas200181
 */@RestController
 public class CurrencyController {
    @Autowired
     CurrencyService currencyService;
    
    @GetMapping("/currency")
    public List<Currency> getAllCurrencies(){
        return currencyService.getAll();
        
    }
     
    
}
