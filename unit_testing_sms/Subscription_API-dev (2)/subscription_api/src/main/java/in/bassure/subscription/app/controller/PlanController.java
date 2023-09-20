package in.bassure.subscription.app.controller;

import in.bassure.subscription.app.config.AppConfig;
import in.bassure.subscription.app.model.Body;
import in.bassure.subscription.app.model.Plan;
import in.bassure.subscription.app.model.Header;
import in.bassure.subscription.app.model.PlanDTO;
import in.bassure.subscription.app.model.ResponseEntity;
import in.bassure.subscription.app.service.PlanService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanController {

    @Autowired
    private PlanService planService;

    @RequestMapping(path = "/plans", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity addPlan(@Valid @RequestBody PlanDTO plan) {

        Plan addedPlan = planService.addPlan(plan);
        Header header = Header.builder().code(AppConfig.getSUCCESS()).build();
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

    @DeleteMapping("/plans/{planId}")
    public ResponseEntity deletePlan(@PathVariable String planId) {
        boolean isDeleted = planService.deletePlan(planId);
        int statusCode = isDeleted ? AppConfig.getSUCCESS() : AppConfig.getSERVER_ERROR();
        Header header = Header.builder().code(statusCode).build();
        Body body = Body.builder().build();

        return ResponseEntity
                .builder()
                .header(header)
                .body(body)
                .build();
    }

    @GetMapping("/plans/{planId}")
    public ResponseEntity getPlan(@PathVariable String planId) {
        Plan plan = planService.getPlan(planId);
        Header header = Header.builder().code(AppConfig.getSUCCESS()).build();
        Body body = Body.builder().value(plan).build();

        return ResponseEntity
                .builder()
                .header(header)
                .body(body)
                .build();
    }

}
