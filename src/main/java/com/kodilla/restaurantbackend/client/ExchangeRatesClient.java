package com.kodilla.restaurantbackend.client;

import com.kodilla.restaurantbackend.config.ExchangeRatesConfig;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExchangeRatesClient {
    private final RestTemplate restTemplate;
    private final ExchangeRatesConfig exchangeRatesConfig;

    public List<ExchangeRatesLatestDto> getExchangeRateLatest() {
        URI url = UriComponentsBuilder.fromHttpUrl(exchangeRatesConfig.getExchangeRatesLatestEndpoint())
                .queryParam("access_key", exchangeRatesConfig.getExchangeRatesAppKey())
                .queryParam("base", exchangeRatesConfig.getExchangeRatesBase())
                .queryParam("symbols", exchangeRatesConfig.getExchangeRatesSymbols())
//                        "PLN, USD, GBP"
                .build()
                .encode()
                .toUri();
        ExchangeRatesLatestDto[] exchangeRatesLatestResponse = restTemplate.getForObject(url, ExchangeRatesLatestDto[].class);
        if(exchangeRatesLatestResponse!=null){
            return Arrays.asList(exchangeRatesLatestResponse);
        } return Optional.ofNullable(exchangeRatesLatestResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());

    }
}
