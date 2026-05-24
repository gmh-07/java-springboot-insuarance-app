package org.gaurav.insurance.controller;


import lombok.RequiredArgsConstructor;
import org.gaurav.insurance.entity.Policy;
import org.gaurav.insurance.service.PolicyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyService policyService;

    // SHOW ALL POLICIES
    @GetMapping("/policies")
    public String getPolicies(Model model) {

        model.addAttribute(
                "policies",
                policyService.getAllPolicies()
        );

        return "policies";
    }

    // CREATE POLICY PAGE
    @GetMapping("/agent/create-policy")
    public String createPolicyPage() {

        return "create-policy";
    }

    // SAVE POLICY
    @PostMapping("/agent/create-policy")
    public String savePolicy(
            @RequestParam String policyName,
            @RequestParam String description,
            @RequestParam Double premiumAmount,
            @RequestParam Integer duration,
            @RequestParam String type
    ) {

        Policy policy = Policy.builder()
                .policyName(policyName)
                .description(description)
                .premiumAmount(premiumAmount)
                .duration(duration)
                .type(type)
                .build();

        policyService.createPolicy(policy);

        return "redirect:/policies";
    }
}
