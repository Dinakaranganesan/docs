package in.bassure.subscription.app.service;

import in.bassure.subscription.app.config.AppConfig;
import in.bassure.subscription.app.model.Product;
import in.bassure.subscription.app.model.ProductName;
import in.bassure.subscription.app.model.exception.DataNotFoundException;
import in.bassure.subscription.app.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        try {
            product.setCreatedAt(LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productRepository.insert(product);
    }

    public Product updateProduct(Product product) {
        product.setUpdatedAt(LocalDateTime.now());
        return productRepository.save(product);
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

}
