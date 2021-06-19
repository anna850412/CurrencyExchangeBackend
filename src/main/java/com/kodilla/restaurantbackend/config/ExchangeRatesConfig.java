package com.kodilla.restaurantbackend.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ExchangeRatesConfig {
    @Value("${exchange.rates.api.endpoint.prod.latest}")
    private String exchangeRatesLatestEndpoint;
    @Value("${exchange.rates.app.key}")
    private String exchangeRatesAppKey;
    @Value("${exchange.rates.base}")
    private String exchangeRatesBase;
    @Value("${exchange.rates.symbols}")
    private String exchangeRatesSymbols;
}
