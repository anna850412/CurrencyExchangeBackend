package com.kodilla.restaurantbackend.fasade;

import com.kodilla.restaurantbackend.domain.*;
import com.kodilla.restaurantbackend.mapper.ExchangeRatesMapper;
import com.kodilla.restaurantbackend.service.ExchangeRatesServiceDto;
import com.kodilla.restaurantbackend.validator.ExchangeRatesValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeRateFasade {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRateFasade.class);
    private final ExchangeRatesMapper exchangeRatesMapper;
    private final ExchangeRatesValidator exchangeRatesValidator;
    private final ExchangeRatesServiceDto exchangeRatesServiceDto;

    public ExchangeRatesLatestDto fetchExchangeRatesLatest() {
        ExchangeRatesLatest exchangeRatesLatests = exchangeRatesMapper.mapToExchangeRatesLatest(exchangeRatesServiceDto.getAllRatesDto());
        ExchangeRatesLatest filteredExchangeRatesLatests = exchangeRatesValidator.validateExchangeRates(exchangeRatesLatests);

        return exchangeRatesMapper.mapToExchangeRatesLatestDto(filteredExchangeRatesLatests);
    }
    public CreatedRateDto createRate(final RatesDto ratesDto){
        Rate rate = exchangeRatesMapper.mapToRates(ratesDto);
        exchangeRatesValidator.validateRates(rate);
        return exchangeRatesServiceDto.createRate(exchangeRatesMapper.mapToRatesDto(rate));
    }
}

