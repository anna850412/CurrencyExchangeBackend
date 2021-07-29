package com.kodilla.restaurantbackend.client;

import com.kodilla.restaurantbackend.config.ExchangeRatesConfig;
import com.kodilla.restaurantbackend.domain.CreatedRateDto;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.RatesDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExchangeRatesClient {
    private final RestTemplate restTemplate;
    private final ExchangeRatesConfig exchangeRatesConfig;
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRatesClient.class);

    public ExchangeRatesLatestDto getExchangeRateLatest() {
        URI url = getUri();
        try {
            ExchangeRatesLatestDto exchangeRatesLatestResponse = restTemplate.getForObject(url, ExchangeRatesLatestDto.class);

            if (exchangeRatesLatestResponse != null) {
                return exchangeRatesLatestResponse;
            }
            return Optional.ofNullable(exchangeRatesLatestResponse).get();
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return getExchangeRateLatest();
        }
    }

    private URI getUri() {
        URI url = UriComponentsBuilder.fromHttpUrl(exchangeRatesConfig.getExchangeRatesLatestEndpoint())
                .queryParam("access_key", exchangeRatesConfig.getExchangeRatesAppKey())
                .queryParam("base", exchangeRatesConfig.getExchangeRatesBase())
                .queryParam("symbols", exchangeRatesConfig.getExchangeRatesSymbols())
                .build()
                .encode()
                .toUri();
        return url;
    }
    public CreatedRateDto createNewRate(RatesDto ratesDto){
        URI url =UriComponentsBuilder.fromHttpUrl(exchangeRatesConfig.getExchangeRatesLatestEndpoint())
                .queryParam("access_key", exchangeRatesConfig.getExchangeRatesAppKey())
                .queryParam("base", exchangeRatesConfig.getExchangeRatesBase())
                .queryParam("symbols", exchangeRatesConfig.getExchangeRatesSymbols())
                .build()
                .encode()
                .toUri();
        return restTemplate.postForObject(url, null, CreatedRateDto.class);
    }
}
