package in.bassure.subscription.app.model;

import in.bassure.subscription.app.model.enum_type.Unit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trail {

    private int trailPeriod;
    private Unit trailUnit;

}
