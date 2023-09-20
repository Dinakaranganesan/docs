package in.bassure.subscription.app.repository;

import in.bassure.subscription.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class ProductRepositoryImpl {

    @Autowired
    public MongoTemplate mongoTemplate;

    public boolean deleteProduct(String productId) throws DataAccessException {
        Query query = new Query((Criteria.where("_id").is(productId)));
        Update update = Update.update("status", "INACTIVE");

        return mongoTemplate.updateFirst(query, update, Product.class).getModifiedCount() > 0;
    }

}
