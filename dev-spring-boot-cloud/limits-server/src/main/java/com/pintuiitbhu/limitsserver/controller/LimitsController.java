package com.pintuiitbhu.limitsserver.controller;

import com.pintuiitbhu.limitsserver.bean.Limits;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @GetMapping("/limits")
    ResponseEntity<Limits> retrieveLimits(){
        return new ResponseEntity<>(new Limits(12,23), HttpStatus.OK);
    }
}
