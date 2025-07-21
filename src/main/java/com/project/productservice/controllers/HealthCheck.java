package com.project.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/HeathCheck")
    public String HealthCheck(){
     return "Health Ok";
    }

}
