package com.pintuiitbhu.currencyexchangeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    @GetMapping("/sample-api")
//    @Retry(name = "default", fallbackMethod = "hardCodedMethod")
    @CircuitBreaker(name = "default", fallbackMethod = "hardCodedMethod")
    public String sampleApi(){
        System.out.println("Sample Api retry ===>>>>");
        ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8040", String.class);

        return response.getBody();
    }

    public String hardCodedMethod(Exception exception){
        return "fallBack Response ===> go exception";
    }
}
