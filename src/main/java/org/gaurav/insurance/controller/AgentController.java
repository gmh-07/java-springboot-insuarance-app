package org.gaurav.insurance.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

    @GetMapping("/agent/dashboard")
    public String agentDashboard() {

        return "Welcome Agent";
    }
}
