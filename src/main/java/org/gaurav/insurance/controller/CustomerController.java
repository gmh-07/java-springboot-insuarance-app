package org.gaurav.insurance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/customer/dashboard")
    public String customerDashboard() {

        return "Welcome Customer";
    }
}
