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

    @RequestMapping(value = "/products", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity addAndUpdateProduct(@Valid @RequestBody Product product) {
        ResponseEntity addedProduct = productService.addAndUpdateProduct(product);
     
        return addedProduct;
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

    @DeleteMapping("/products/{productId}")
    public ResponseEntity deletePlan(@PathVariable String productId) {
        boolean isDeleted = productService.deleteProduct(productId);

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
