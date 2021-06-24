package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.client.ExchangeRatesClient;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.mapper.ExchangeRatesMapper;
import com.kodilla.restaurantbackend.service.ExchangeRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/exchangeRates")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExchangeRatesController {

    private final ExchangeRatesClient exchangeRatesClient;

    @RequestMapping(method = RequestMethod.GET, value = "/getLatestRates")
    public ExchangeRatesLatestDto getLatestExchangeRates() {
        ExchangeRatesLatestDto latest = exchangeRatesClient.getExchangeRateLatest();
        System.out.println("base currency is " + latest.getBase() + " " +  "from date " + latest.getDate());
        System.out.println("This exchange rates contains currencies: ");
        System.out.println("GBP" + " " + latest.getRatesDto().getGbp() + " " + "PLN " + " " + latest.getRatesDto().getPln()
                + " " + "USD " + " " + latest.getRatesDto().getUsd());
        return latest;
    }
}

