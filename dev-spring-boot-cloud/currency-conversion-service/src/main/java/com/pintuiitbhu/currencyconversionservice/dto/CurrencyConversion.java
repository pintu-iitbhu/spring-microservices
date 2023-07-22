package com.pintuiitbhu.currencyconversionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {
    private int id;

    private String exchangeFrom;

    private String exchangeTo;

    private double conversionMultiple;

    private double totalCalculatedAmount;

    private int quantity;

    private String environment;
}
