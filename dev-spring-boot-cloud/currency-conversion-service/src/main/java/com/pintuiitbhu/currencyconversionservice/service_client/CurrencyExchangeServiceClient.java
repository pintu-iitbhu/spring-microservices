package com.pintuiitbhu.currencyconversionservice.service_client;

import com.pintuiitbhu.currencyconversionservice.dto.CurrencyExchangeResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@Service
public class CurrencyExchangeServiceClient {

    private RestTemplate restTemplate;
    CurrencyExchangeServiceClient(){
        this.restTemplate=new RestTemplate();
    }


    public CurrencyExchangeResponseDto  getCurrencyExchange(String from, String to){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyExchangeResponseDto> response= restTemplate.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyExchangeResponseDto.class, uriVariables);
        return response.getBody();
    }
}
