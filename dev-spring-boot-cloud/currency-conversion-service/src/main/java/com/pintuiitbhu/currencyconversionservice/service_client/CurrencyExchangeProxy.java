package com.pintuiitbhu.currencyconversionservice.service_client;

import com.pintuiitbhu.currencyconversionservice.dto.CurrencyExchangeResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange",url = "localhost:8000")
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeResponseDto retrieveCurrencyExchange(
            @PathVariable String from,
            @PathVariable String to
    );
}
