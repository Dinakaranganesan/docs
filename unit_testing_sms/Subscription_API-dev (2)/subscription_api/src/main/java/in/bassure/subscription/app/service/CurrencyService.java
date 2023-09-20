/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.bassure.subscription.app.service;

import in.bassure.subscription.app.model.Currency;
import in.bassure.subscription.app.repository.CurrencyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bas200181
 */
@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;
    
    
    public List<Currency> getAll(){
        System.out.println(currencyRepository.findAll());
        return currencyRepository.findByIncludeNameAndCountry();
    }
    
}
