package in.bassure.subscription.app.repository;

import in.bassure.subscription.app.model.Product;
import in.bassure.subscription.app.model.ProductName;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{'_id':?0,'tenantId':?1,'status':'ACTIVE'}")
    public Optional<Product> findByTenantIdAndProductId(String _id, String tenantId);

    @Query("{'tenantId':?0,'status':'ACTIVE'}")
    public List<ProductName> findAllByTenantId(String tenantId);

    @Query("{'tenantId':?0,'status':'ACTIVE'}")
    public List<Product> findByTenantId(String tenantId);
    
    
    

}
