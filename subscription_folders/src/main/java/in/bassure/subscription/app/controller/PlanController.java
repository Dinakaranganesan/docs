package in.bassure.subscription.app.controller;

import in.bassure.subscription.app.config.AppConfig;
import in.bassure.subscription.app.model.Body;
import in.bassure.subscription.app.model.Plan;
import in.bassure.subscription.app.model.Header;
import in.bassure.subscription.app.model.PlansDTO;
import in.bassure.subscription.app.model.ResponseEntity;
import in.bassure.subscription.app.service.PlanService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanController {

    @Autowired
    private PlanService planService;

    @PostMapping("/plans")
    public ResponseEntity addProduct(@Valid @RequestBody PlansDTO plan) {
        //call add plan for new plan

        //Plan addedPlan = planService.addPlan(plan);
        Plan addedPlan = planService.getCustomPlanList(plan);

        planService.addCustomPlanList(addedPlan);

        //declaring header and creating header for success response
        Header header = Header.builder().code(AppConfig.getSUCCESS()).build();
        //declaring body and //creating body for success response
        Body body = Body.builder().value(addedPlan).build();

        return ResponseEntity
                .builder()
                .header(header)
                .body(body)
                .build();
    }

    @GetMapping("/plans/list/{productId}")
    public ResponseEntity getPlans(@PathVariable String productId) {

        List<Plan> plans = planService.getPlansByProductId(productId);

        Header header = Header.builder().code(AppConfig.getSUCCESS()).build();

        Body body = Body.builder().value(plans).build();

        return ResponseEntity
                .builder()
                .header(header)
                .body(body)
                .build();

    }
    @GetMapping("/plans/{planId}")
    public ResponseEntity getPlan(@PathVariable String planId)
    {
      Plan plan=planService.getPlan(planId);
     
                Header header = Header.builder().code(AppConfig.getSUCCESS()).build();

        Body body = Body.builder().value(plan).build();

        return ResponseEntity
                .builder()
                .header(header)
                .body(body)
                .build();   
    }
   


}
