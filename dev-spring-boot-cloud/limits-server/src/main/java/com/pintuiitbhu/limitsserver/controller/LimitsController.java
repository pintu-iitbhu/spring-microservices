package com.pintuiitbhu.limitsserver.controller;

import com.pintuiitbhu.limitsserver.bean.Limits;
import com.pintuiitbhu.limitsserver.configurations.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @Autowired
    private Limits limits;

    @GetMapping("/limits")
    ResponseEntity<Limits> retrieveLimits(){
//        return new ResponseEntity<>(new Limits(configuration.getMinvalue(), configuration.getMaxvalue()), HttpStatus.OK);
        return new ResponseEntity<>(limits, HttpStatus.OK);

    }
}
