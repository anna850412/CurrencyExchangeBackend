package com.kodilla.restaurantbackend.fasade;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.mapper.ExchangeRatesMapper;
import com.kodilla.restaurantbackend.repository.ExchangeRatesRepository;
import com.kodilla.restaurantbackend.service.ExchangeRatesService;
import com.kodilla.restaurantbackend.validator.ExchangeRatesValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExchangeRateFasade {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRateFasade.class);
    @Autowired
    private ExchangeRatesMapper exchangeRatesMapper;
    @Autowired
    private ExchangeRatesValidator exchangeRatesValidator;
    @Autowired
    private ExchangeRatesService exchangeRatesService;
    public List<ExchangeRatesLatestDto> fetchExchangeRatesLatest(){
        List<ExchangeRatesLatest> exchangeRatesLatests = exchangeRatesMapper.mapToExchangeRatesLatest()
    }
}
