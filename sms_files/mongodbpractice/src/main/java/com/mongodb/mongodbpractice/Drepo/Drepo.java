
package com.mongodb.mongodbpractice.Drepo;

import com.mongodb.mongodbpractice.model.Details;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Drepo extends MongoRepository<Details, String>{
    
}
