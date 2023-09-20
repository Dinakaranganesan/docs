package in.bassure.subscription.app.repository;

import in.bassure.subscription.app.model.Plan;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends MongoRepository<Plan, String> {

    @Query("{'productId':?0,'status':'ACTIVE'}")
    public List<Plan> findByProductId(String productId);
}
