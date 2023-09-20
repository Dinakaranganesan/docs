/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.bassure.subscription.app.repository;

import in.bassure.subscription.app.model.Currency;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bas200181
 */
@Repository
public interface CurrencyRepository extends MongoRepository<Currency, String>{
    
    @Query(value = "{}",fields = "{ 'name' : 1, 'country' : 1,'_id':0 }")
    public List<Currency>  findByIncludeNameAndCountry();
}
