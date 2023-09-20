package in.bassure.subscription.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.bassure.subscription.app.config.AppConfig;
import in.bassure.subscription.app.model.Plan;
import in.bassure.subscription.app.model.KeyValuePair;
import in.bassure.subscription.app.model.PlanDTO;
import in.bassure.subscription.app.model.enum_type.Status;
import in.bassure.subscription.app.model.exception.DataNotFoundException;
import org.springframework.stereotype.Service;
import in.bassure.subscription.app.repository.PlanRepository;
import in.bassure.subscription.app.repository.PlanRepositoryImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private PlanRepositoryImpl planRepositoryImpl;

    public List<Plan> getPlansByProductId(String productId) {
        List<Plan> plans = planRepository.findByProductId(productId);
        if (plans.isEmpty()) {
            throw new DataNotFoundException(AppConfig.getNO_DATA_MESSAGE());
        }
        return plans;
    }

    public Plan<List<String>> addPlan(PlanDTO planDTO) {
        planDTO.setStatus(Status.ACTIVE);
        Plan plan = planDtoToplan(planDTO);
        try {
            plan = addPlanDetails(planDTO, plan);
            planRepository.save(plan);
        } catch (JsonProcessingException e) {
            throw new HttpMessageNotReadableException(AppConfig.getFIELD_VALIDATE_MESSAGE());
        }

        return plan;
    }

    private Plan addPlanDetails(PlanDTO planDTO, Plan plan) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        switch (planDTO.getPlanDetailType().name()) {

            case "LIST":

                if (Objects.nonNull(planDTO.getPlanDetail())
                        && planDTO.getPlanDetail().length() > AppConfig.getPLAN_DETAIL_LIST_MIN_LEN()
                        && planDTO.getPlanDetail().length() > AppConfig.getPLAN_DETAIL_LIST_MAX_LEN()) {

                    List<String> list = Arrays.asList(objectMapper.readValue(planDTO.getPlanDetail(), String[].class));
                    plan.setPlanDetail(list);

                } else {
                    throw new HttpMessageNotReadableException(AppConfig.getFIELD_VALIDATE_MESSAGE());
                }
                break;

            case "KEY_VALUE_PAIR":

                List<KeyValuePair> keyValuePairs = Arrays.stream(objectMapper.readValue(planDTO.getPlanDetail(), KeyValuePair[].class))
                        .collect(Collectors.toList());
                if (keyValueValidator(AppConfig.getPLAN_DETAIL_VALUE_MIN_LEN(), AppConfig.getPLAN_DETAIL_VALUE_MAX_LEN(), keyValuePairs)) {
                    plan.setPlanDetail(keyValuePairs);
                } else {
                    throw new HttpMessageNotReadableException(AppConfig.getFIELD_VALIDATE_MESSAGE());
                }
                break;

            case "DESCRIPTIVE":
                if (planDTO.getPlanDetail().length() > AppConfig.getPLAN_DETAIL_DESCRIPTIVE_MIN_LEN()
                        && planDTO.getPlanDetail().length() < AppConfig.getPLAN_DETAIL_DESCRIPTIVE_MAX_LEN()
                        && Objects.nonNull(planDTO.getPlanDetail())) {

                    plan.setPlanDetail(planDTO.getPlanDetail());

                } else {
                    throw new HttpMessageNotReadableException(AppConfig.getFIELD_VALIDATE_MESSAGE());
                }

                break;
        }
        return plan;

    }

    private Plan planDtoToplan(PlanDTO planDTO) {

        Plan plan = new Plan();
        plan.setId(planDTO.getId());
        plan.setPlanName(planDTO.getPlanName());
        plan.setPrice(planDTO.getPrice());
        plan.setCurrency(planDTO.getCurrency());
        plan.setPlanDuration(planDTO.getPlanDuration());
        plan.setTrail(planDTO.getTrail());
        plan.setProductId(planDTO.getProductId());
        plan.setDescription(planDTO.getDescription());
        plan.setPlanDetailType(planDTO.getPlanDetailType());
        plan.setStatus(planDTO.getStatus());
        plan.setCreatedBy(planDTO.getCreatedBy());
        plan.setUpdatedBy(planDTO.getUpdatedBy());
        plan.setDeletedBy(planDTO.getDeletedBy());
        plan.setCreatedAt(planDTO.getCreatedAt());
        plan.setUpdatedAt(planDTO.getUpdatedAt());
        plan.setDeletedAt(planDTO.getDeletedAt());

        return plan;
    }

    private boolean keyValueValidator(int min, int max, List<KeyValuePair> keyValuePairs) {
        boolean isValid = keyValuePairs
                .stream()
                .allMatch(data -> ((Objects.nonNull(data.getKey())) && (Objects.nonNull(data.getValue()))
                        && (data.getValue().length() > min) && (max > data.getValue().length())));

        return isValid;
    }

    public boolean deletePlan(String planId) {
        return planRepositoryImpl.deletePlan(planId);

    }

    public Plan getPlan(String planId) {

        return planRepository.findById(planId)
                .orElseThrow(() -> new DataNotFoundException(AppConfig.getNO_DATA_MESSAGE()));
    }

}
