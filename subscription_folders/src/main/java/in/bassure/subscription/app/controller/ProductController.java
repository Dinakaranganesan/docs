package in.bassure.subscription.app.controller;

import in.bassure.subscription.app.config.AppConfig;
import in.bassure.subscription.app.model.*;
import in.bassure.subscription.app.service.ProductService;
import jakarta.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity addProduct(@Valid @RequestBody Product product) {
        //call add product for new product
        Product addedProduct = productService.addProduct(product);
        //declaring header and creating header for success response
        Header header = Header.builder().code(AppConfig.getSUCCESS()).build();
        //declaring body and //creating body for success response
        Body body = Body.builder().value(addedProduct).build();

        return ResponseEntity
                .builder()
                .header(header)
                .body(body)
                .build();
    }

    @PutMapping("/products")
    public ResponseEntity updateProduct(@Valid @RequestBody Product product) {
        Product updateProduct = productService.updateProduct(product);
        Header header = Header.builder().code(AppConfig.getSUCCESS()).build();

        return ResponseEntity
                .builder()
                .header(header)
                .body(Body.builder().value(updateProduct).build())
                .build();
    }

    @GetMapping("/products/{tenantId}/{productId}")
    public ResponseEntity getTenantProduct(@PathVariable String productId, @PathVariable String tenantId) {

        Product product = productService.getProductByTenantIdAndProductId(productId, tenantId);
        Header header = Header.builder().code(AppConfig.getSUCCESS()).build();
        Body body = Body.builder().value(product).build();

        return ResponseEntity
                .builder()
                .header(header)
                .body(body)
                .build();
    }

    @GetMapping("/products/names/{tenantId}")
    public ResponseEntity getAllProductNames(@PathVariable String tenantId) {
        return ResponseEntity.builder()
                .header(Header.builder().code(AppConfig.getSUCCESS()).build())
                .body(Body.builder().value(productService.getAllProductsNames(tenantId)).build())
                .build();
    }

    @GetMapping("/products/{tenantId}")
    public ResponseEntity getAllProducts(@PathVariable String tenantId) {
        return ResponseEntity.builder()
                .header(Header.builder().code(AppConfig.getSUCCESS()).build())
                .body(Body.builder().value(productService.getAllProductByTenantId(tenantId)).build())
                .build();
    }

}
