package com.pintuiitbhu.currencyexchangeservice.repository;

import com.pintuiitbhu.currencyexchangeservice.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {
    public CurrencyExchange findByExchangeFromAndExchangeTo(String from, String to);
}
