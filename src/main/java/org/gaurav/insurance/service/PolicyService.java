package org.gaurav.insurance.service;


import org.gaurav.insurance.entity.Policy;

import java.util.List;

public interface PolicyService {

    Policy createPolicy(Policy policy);

    List<Policy> getAllPolicies();

    Policy getPolicyById(Long id);
}
