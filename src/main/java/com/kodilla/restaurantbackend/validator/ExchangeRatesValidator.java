package com.kodilla.restaurantbackend.validator;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.Rate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExchangeRatesValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRatesValidator.class);

    public ExchangeRatesLatest validateExchangeRates(final ExchangeRatesLatest exchangeRatesLatest) {
        if (exchangeRatesLatest.getBase().equalsIgnoreCase("EUR")) {
            LOGGER.info("Only EUR can be used as base currency");
        } else {
            LOGGER.info("Proper base exchange rate");
        } return exchangeRatesLatest;
    }

    public void validateRates(final Rate rate) {
        if(rate != null){
            LOGGER.info("This object has proper rates");
        } else {
            LOGGER.info("Object rate in null");
        }
    }
}
