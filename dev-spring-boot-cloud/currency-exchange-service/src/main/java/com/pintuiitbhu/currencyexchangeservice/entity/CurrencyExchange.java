package com.pintuiitbhu.currencyexchangeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "currency-exchange")
public class CurrencyExchange {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "exchange_from")
    private String exchangeFrom;
    @Column(name = "exchange_to")
    private String exchangeTo;
    @Column(name = "conversion_multiple")
    private double conversionMultiple;

    @Column(name = "environment")
    private String environment;

    public CurrencyExchange(String exchangeFrom, String exchangeTo, double conversionMultiple, String environment) {
        this.exchangeFrom = exchangeFrom;
        this.exchangeTo = exchangeTo;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
    }

    public CurrencyExchange() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExchangeFrom() {
        return exchangeFrom;
    }

    public void setExchangeFrom(String exchangeFrom) {
        this.exchangeFrom = exchangeFrom;
    }

    public String getExchangeTo() {
        return exchangeTo;
    }

    public void setExchangeTo(String exchangeTo) {
        this.exchangeTo = exchangeTo;
    }

    public double getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(double conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
