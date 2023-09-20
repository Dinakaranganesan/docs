package in.bassure.subscription.app;

import in.bassure.subscription.app.model.Product;
import in.bassure.subscription.app.model.ProductName;
import in.bassure.subscription.app.model.enum_type.ProductType;
import in.bassure.subscription.app.model.enum_type.Status;
import in.bassure.subscription.app.repository.ProductRepository;
import in.bassure.subscription.app.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.assertj.core.internal.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppApplicationTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testforGetProducts() {
        String productId = "64e5e82e353c995847da243";
        String tenantId = "345";
        Product p = new Product("64e5e82e353c995847da2438", "oms", ProductType.SERVICE, "oms order management system", "345", null, Status.ACTIVE, null, null, null, null, null, null);
        Optional<Product> actual = Optional.ofNullable(p);
        when(productRepository.findByTenantIdAndProductId(productId, tenantId)).thenReturn(actual);
        assertEquals(actual, productService.getProductByTenantIdAndProductId("64e5e82e353c995847da24", tenantId), "pass");
    }

    @Test
    public void testforPostRequest() {
        Product p = new Product("64e5e82e353c995847da2438", "oms", ProductType.SERVICE, "oms order management system", "345", null, Status.ACTIVE, null, null, null, null, null, null);
        when(productRepository.save(p)).thenReturn(p);
        Product result = productService.addProduct(p);
        assertNotNull(result);
        assertEquals("oms", result.getProductName());
        assertEquals("oms order management system", result.getDescription());
        assertEquals("345", result.getTenantId());
        verify(productRepository, times(1)).save(p);
    }

    @Test
    public void testForToGetProdcutNames() {

        String tenantId = "T001";
        List<ProductName> namesList = new ArrayList<>();
        namesList.add(new ProductName("P001", "OMS"));
        namesList.add(new ProductName("P002", "TSMS"));
        namesList.add(new ProductName("P003", "ATS"));
        when(productRepository.findAllByTenantId("T001")).thenReturn(namesList);
        List<ProductName> resultList = productService.getAllProductsNames(tenantId);
        assertNotNull(resultList);
        assertEquals("OMS", resultList.get(0).getProductName());
        assertEquals("TSMS", resultList.get(1).getProductName());
        assertEquals("ATS", resultList.get(2).getProductName());

    }
  

}
