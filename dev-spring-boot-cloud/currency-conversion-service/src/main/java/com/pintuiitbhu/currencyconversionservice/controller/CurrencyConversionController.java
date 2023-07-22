package com.pintuiitbhu.currencyconversionservice.controller;

import com.pintuiitbhu.currencyconversionservice.dto.CurrencyConversion;
import com.pintuiitbhu.currencyconversionservice.dto.CurrencyExchangeResponseDto;
import com.pintuiitbhu.currencyconversionservice.service_client.CurrencyExchangeProxy;
import com.pintuiitbhu.currencyconversionservice.service_client.CurrencyExchangeServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {


    @Autowired
    private CurrencyExchangeServiceClient client;

    @Autowired
    private CurrencyExchangeProxy exchangeProxy;

    @GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    ResponseEntity<CurrencyConversion> calculateCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable int quantity
    ){
        CurrencyExchangeResponseDto responseDto = exchangeProxy.retrieveCurrencyExchange(from,to);

        CurrencyConversion conversion= CurrencyConversion.builder()
                .id(responseDto.getId())
                .quantity(quantity)
                .exchangeFrom(responseDto.getExchangeFrom())
                .exchangeTo(responseDto.getExchangeTo())
                .conversionMultiple(responseDto.getConversionMultiple())
                .totalCalculatedAmount(quantity*responseDto.getConversionMultiple())
                .environment(responseDto.getEnvironment()+ " feign").build();

      return new ResponseEntity<>(conversion, HttpStatus.OK);
    }

    @GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    ResponseEntity<CurrencyConversion> calculateCurrencyConversionFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable int quantity
    ){
        CurrencyExchangeResponseDto responseDto = client.getCurrencyExchange(from,to);

        CurrencyConversion conversion= CurrencyConversion.builder()
                .id(responseDto.getId())
                .quantity(quantity)
                .exchangeFrom(responseDto.getExchangeFrom())
                .exchangeTo(responseDto.getExchangeTo())
                .conversionMultiple(responseDto.getConversionMultiple())
                .totalCalculatedAmount(quantity*responseDto.getConversionMultiple())
                .environment(responseDto.getEnvironment()).build();

        return new ResponseEntity<>(conversion, HttpStatus.OK);
    }

}
