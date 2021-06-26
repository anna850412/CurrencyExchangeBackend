package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.ExchangeRatesClient;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeRatesServiceDto {
    private final ExchangeRatesClient exchangeRatesClient;

    public ExchangeRatesLatestDto getAllRatesDto() {
        return exchangeRatesClient.getExchangeRateLatest();
    }
}
