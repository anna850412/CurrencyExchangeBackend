package com.kodilla.restaurantbackend.validator;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRatesValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRatesValidator.class);

    public void validateExchangeRates(final ExchangeRatesLatest exchangeRatesLatest) {
        if (exchangeRatesLatest.getBase().equalsIgnoreCase("EUR")) {
            LOGGER.info("Only EUR can be used as base currency");
        } else {
            LOGGER.info("Proper base exchange rate");
        }
    }
}
