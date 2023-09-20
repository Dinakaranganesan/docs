package in.bassure.subscription.app.service;

import in.bassure.subscription.app.config.AppConfig;
import in.bassure.subscription.app.model.Body;
import in.bassure.subscription.app.model.Header;
import in.bassure.subscription.app.model.Product;
import in.bassure.subscription.app.model.ProductName;
import in.bassure.subscription.app.model.ResponseEntity;
import in.bassure.subscription.app.model.enum_type.Status;
import in.bassure.subscription.app.model.exception.DataNotFoundException;
import in.bassure.subscription.app.repository.ProductRepository;
import in.bassure.subscription.app.repository.ProductRepositoryImpl;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public ResponseEntity getProductByTenantIdAndProductId(String productId, String tenantId) {

        Optional<Product> product = productRepository.findByTenantIdAndProductId(productId, tenantId);

        if (Objects.isNull(product)) {

            throw new DataNotFoundException(AppConfig.getNO_DATA_MESSAGE());
        } else {
            Header header = Header.builder().code(AppConfig.getSUCCESS()).build();
            Body body = Body.builder().value(product).build();

            return ResponseEntity
                    .builder()
                    .header(header)
                    .body(body)
                    .build();
        }

    }

    public ResponseEntity getAllProductsNames(String tenantId) {
        List<ProductName> products = productRepository.findAllByTenantId(tenantId);

        if (Objects.isNull(products)) {

            throw new DataNotFoundException(AppConfig.getNO_DATA_MESSAGE());
        } else {
            Header header = Header.builder().code(AppConfig.getSUCCESS()).build();
            Body body = Body.builder().value(products).build();

            return ResponseEntity
                    .builder()
                    .header(header)
                    .body(body)
                    .build();
        }
    }

    public ResponseEntity getAllProductByTenantId(String Id) {
        List<Product> products = productRepository.findByTenantId(Id);

        if (Objects.isNull(products)) {

            throw new DataNotFoundException(AppConfig.getNO_DATA_MESSAGE());
        } else {
            Header header = Header.builder().code(AppConfig.getSUCCESS()).build();
            Body body = Body.builder().value(products).build();

            return ResponseEntity
                    .builder()
                    .header(header)
                    .body(body)
                    .build();
        }
    }

    public ResponseEntity deleteProduct(String productId) {

        boolean isDeleted = productRepositoryImpl.deleteProduct(productId);

        int statusCode = isDeleted ? AppConfig.getSUCCESS() : AppConfig.getSERVER_ERROR();
        Header header = Header.builder().code(statusCode).build();
        Body body = Body.builder().build();

        return ResponseEntity
                .builder()
                .header(header)
                .body(body)
                .build();
    }

}
