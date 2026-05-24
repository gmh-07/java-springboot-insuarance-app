package org.gaurav.insurance.service.impl;

import lombok.RequiredArgsConstructor;
import org.gaurav.insurance.entity.Policy;
import org.gaurav.insurance.repository.PolicyRepository;
import org.gaurav.insurance.service.PolicyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PolicyServiceImpl
        implements PolicyService {

    private final PolicyRepository policyRepository;

    @Override
    public Policy createPolicy(Policy policy) {

        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> getAllPolicies() {

        return policyRepository.findAll();
    }

    @Override
    public Policy getPolicyById(Long id) {

        return policyRepository.findById(id)
                .orElseThrow();
    }
}
