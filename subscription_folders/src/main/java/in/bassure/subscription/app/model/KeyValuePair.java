package in.bassure.subscription.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyValuePair {

    private String key;
    private String value;
    private String dataType;
    private String metric;
    private String unit;
}
