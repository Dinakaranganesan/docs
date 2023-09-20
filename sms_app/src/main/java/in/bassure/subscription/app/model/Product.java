package in.bassure.subscription.app.model;

import in.bassure.subscription.app.model.enum_type.Status;
import in.bassure.subscription.app.model.enum_type.ProductType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("products")
public class Product {

    @Id
    private String id;

    @NotEmpty(message = "product name should not be empty")
    @Length(min = 3, max = 100, message = "product name length between 3 and 100")
    private String productName;

    @NotNull(message = "prodcut type should not be empty")
    private ProductType productType;

    @Length(min = 0, max = 500, message = "description should not be more than 500 characters")
    private String description;

    @NotEmpty(message = "tenantId should not be empty")
    private String tenantId;

    //multipart
    private String imgUrl;
    private Status status;
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
