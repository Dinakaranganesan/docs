package in.bassure.subscription.app.service;

import in.bassure.subscription.app.config.AppConfig;
import in.bassure.subscription.app.model.Body;
import in.bassure.subscription.app.model.Header;
import in.bassure.subscription.app.model.Product;
import in.bassure.subscription.app.model.ResponseEntity;
import in.bassure.subscription.app.model.enum_type.Status;
import in.bassure.subscription.app.repository.ProductRepository;
import in.bassure.subscription.app.repository.ProductRepositoryImpl;
import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductRepositoryImpl productRepositoryImpl;

    public ResponseEntity addAndUpdateProduct(Product product) {

        product.setStatus(Status.ACTIVE);
        product.setCreatedAt(Objects.isNull(product.getCreatedAt()) ? LocalDateTime.now() : product.getCreatedAt());
        product.setUpdatedAt(Objects.isNull(product.getCreatedAt()) ? null : LocalDateTime.now());

        Product p = productRepository.save(product);

        Header header = Header.builder().code(AppConfig.getSUCCESS()).build();
        Body body = Body.builder().value(p).build();
        return ResponseEntity
                .builder().body(Body.builder().value(p).build())
                .header(header)
                .body(body)
                .build();
    }

    public Product getProductByTenantIdAndProductId(String productId, String tenantId) {
        return productRepository.findByTenantIdAndProductId(productId, tenantId)
                .orElseThrow(() -> new DataNotFoundException(AppConfig.getNO_DATA_MESSAGE()));
    }

    public List<ProductName> getAllProductsNames(String tenantId) {
        List<ProductName> products = productRepository.findAllByTenantId(tenantId);
        if (products.isEmpty()) {
            throw new DataNotFoundException(AppConfig.getNO_DATA_MESSAGE());
        }
        return products;
    }

    public List<Product> getAllProductByTenantId(String Id) {
        List<Product> products = productRepository.findByTenantId(Id);
        if (products.isEmpty()) {
            throw new DataNotFoundException(AppConfig.getNO_DATA_MESSAGE());
        }
        return products;
    }

    public boolean deleteProduct(String productId) {
        return productRepositoryImpl.deletePlan(productId);
    }

}
