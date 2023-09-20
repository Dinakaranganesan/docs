package in.bassure.subscription.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.bassure.subscription.app.config.AppConfig;
import in.bassure.subscription.app.model.Plan;
import in.bassure.subscription.app.model.KeyValuePair;
import in.bassure.subscription.app.model.PlansDTO;
import in.bassure.subscription.app.model.exception.DataNotFoundException;
import org.springframework.stereotype.Service;
import in.bassure.subscription.app.repository.PlanRepository;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public Plan<List<String>> addCustomPlanList(Plan<List<String>> customPlan) {

        return planRepository.insert(customPlan);

    }

    public List<Plan> getPlansByProductId(String productId) {

        List<Plan> plans = planRepository.findByProductId(productId);

        if (plans.isEmpty()) {
            throw new DataNotFoundException("Plans not found");
        }
        return plans;
    }
    
    
    
    
    
       public Plan getPlan(String planId) {
      
           return planRepository.findById(planId)
                   .orElseThrow(()->new DataNotFoundException(AppConfig.getNO_DATA_MESSAGE()));
       }
       
       
       

       
       
       
       
       
    public Plan<List<String>> getCustomPlanList(PlansDTO planDTO) {
        Plan plan = new Plan();

        plan.setPlanName(plan.getPlanName());
        plan.setPrice(plan.getPrice());
        plan.setCurrency(plan.getCurrency());
        plan.setPlanDuration(plan.getPlanDuration());
        plan.setTrail(plan.getTrail());
        plan.setProductId(plan.getProductId());
        plan.setDescription(plan.getDescription());
        plan.setPlanDetailType(plan.getPlanDetailType());

        plan.setStatus(plan.getStatus());
        plan.setCreatedBy(plan.getCreatedBy());
        plan.setUpdatedBy(plan.getUpdatedBy());
        plan.setDeletedBy(plan.getDeletedBy());
        plan.setCreatedAt(plan.getCreatedAt());
        plan.setUpdatedAt(plan.getUpdatedAt());
        plan.setDeletedAt(plan.getDeletedAt());
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            if (plan.getPlanDetailType().name().equals("LIST")) {

                List<String> list = Arrays.asList(objectMapper.readValue(planDTO.getPlanDetail(), String[].class));
                plan.setPlanDetail(list);

            } else if (plan.getPlanDetailType().name().equals("KEY_VALUE_PAIR")) {

                KeyValuePair[] map = objectMapper.readValue(planDTO.getPlanDetail(), KeyValuePair[].class);
//                System.out.println(Arrays.toString(map));
                plan.setPlanDetail(map);
            }

        } catch (JsonProcessingException e) {
            System.out.println(e);
        }
//        String[] list = plan.getPlanDetail().split(",");
//        newPlan.setPlanDetail(list);
        return plan;
    }

}
