/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.bassure.subscription.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author bas200181
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("currency")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Currency {

    @Id
    private String id;
    private String currencyCode;
    private String  name;
    private String symbol;
    private String  country;
    
}
 