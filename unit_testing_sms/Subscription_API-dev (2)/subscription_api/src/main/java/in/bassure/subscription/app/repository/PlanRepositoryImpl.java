package in.bassure.subscription.app.repository;

import in.bassure.subscription.app.model.Plan;
import org.bson.BsonValue;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class PlanRepositoryImpl {

    @Autowired
    public MongoTemplate mongoTemplate;

    public boolean deletePlan(String planId) throws DataAccessException {
        Query query = new Query((Criteria.where("_id").is(planId)));
        Update update = Update.update("status", "INACTIVE");

        return mongoTemplate.updateFirst(query, update, Plan.class).getModifiedCount() > 0;
    }

}
