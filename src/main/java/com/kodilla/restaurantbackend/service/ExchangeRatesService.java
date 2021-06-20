package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.ExchangeRatesClient;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRatesService {
    private final ExchangeRatesClient exchangeRatesClient;
 public List<ExchangeRatesLatestDto> fetchLatestExchangeRates(){
     return exchangeRatesClient.getExchangeRateLatest();
 }
}
