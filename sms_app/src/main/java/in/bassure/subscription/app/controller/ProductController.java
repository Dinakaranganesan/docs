package in.bassure.subscription.app.controller;

import in.bassure.subscription.app.model.*;
import in.bassure.subscription.app.service.ProductService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity addAndUpdateProduct(@Valid @RequestBody Product product) {
        ResponseEntity addedProduct = productService.addAndUpdateProduct(product);
        return addedProduct;
    }

    @GetMapping("/products/{tenantId}/{productId}")
    public ResponseEntity getTenantProduct(@PathVariable String productId, @PathVariable String tenantId) {

        ResponseEntity product = productService.getProductByTenantIdAndProductId(productId, tenantId);
        return product;
    }

    @GetMapping("/products/names/{tenantId}")
    public ResponseEntity getAllProductNames(@PathVariable String tenantId) {
        return productService.getAllProductsNames(tenantId);
    }

    @GetMapping("/products/{tenantId}")
    public ResponseEntity getAllProducts(@PathVariable String tenantId) {
        return productService.getAllProductByTenantId(tenantId);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity deleteProduct(@PathVariable String productId) {
        ResponseEntity isDeleted = productService.deleteProduct(productId);
        return isDeleted;

    }

}
