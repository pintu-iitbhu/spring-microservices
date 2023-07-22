package com.pintuiitbhu.currencyexchangeservice.controller;

import com.pintuiitbhu.currencyexchangeservice.entity.CurrencyExchange;
import com.pintuiitbhu.currencyexchangeservice.repository.CurrencyExchangeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment env;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> retrieveCurrencyExchange(
            @PathVariable String from,
            @PathVariable String to
    ){
        CurrencyExchange currencyExchange= currencyExchangeRepository.findByExchangeFromAndExchangeTo(from,to);
//        CurrencyExchange currencyExchange1 = new CurrencyExchange(100L,"USD","INR", BigDecimal.valueOf(83.5));
        currencyExchange.setEnvironment(env.getProperty("local.server.port"));
        return new ResponseEntity<>(currencyExchange, HttpStatus.OK);
    }

    @PostMapping("/currency-exchange/post")
    @Transactional
    public ResponseEntity postCurrencyExchange(@RequestBody CurrencyExchange exchange){
        currencyExchangeRepository.save(exchange);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
