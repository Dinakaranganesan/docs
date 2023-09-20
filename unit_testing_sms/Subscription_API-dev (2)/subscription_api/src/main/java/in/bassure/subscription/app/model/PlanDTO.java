package in.bassure.subscription.app.model;

import in.bassure.subscription.app.model.enum_type.Status;
import in.bassure.subscription.app.model.enum_type.PlanDetailType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Document("plans")
public class PlanDTO {

    @Id
    private String id;

    @NotEmpty(message = "plan name should not be empty")
    @Length(min = 3, max = 100, message = "plan name length between 3 and 100")
    private String planName;

    @Min(value = 1, message = "Price should be greater than 0")
    private double price;

    @NotEmpty(message = "currency should not be empty")
    private String currency;

    @NotNull(message = "plan duration should not be empty")
    private PlanDuration planDuration;

    private Trail trail;

    @NotEmpty(message = "product id should not be empty")
    private String productId;

    @Size(min = 0, max = 500, message = "description should not be more than 500 characters")
    private String description;

    private PlanDetailType planDetailType;

    private String planDetail;

    
    private Status status;

    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
