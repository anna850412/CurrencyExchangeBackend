package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.domain.CreatedRateDto;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.RatesDto;
import com.kodilla.restaurantbackend.fasade.ExchangeRateFasade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/exchangeRates")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExchangeRatesControllerDto {
    @Autowired
    private final ExchangeRateFasade exchangeRateFasade;

    @RequestMapping(method = RequestMethod.GET, value = "/getLatestRates")
    public ExchangeRatesLatestDto getLatestExchangeRates() {

        ExchangeRatesLatestDto latest = exchangeRateFasade.fetchExchangeRatesLatest();
        System.out.println("base currency is " + latest.getBase() + " " + "from date " + latest.getDate());
        System.out.println("This exchange rates contains currencies: ");
        System.out.println("GBP" + " " + latest.getRatesDto().getGbp() + " " + "PLN " + " " + latest.getRatesDto().getPln()
                + " " + "USD " + " " + latest.getRatesDto().getUsd());
        return latest;
    }
    @RequestMapping(method = RequestMethod.POST, value = "/createRate")
    public CreatedRateDto createRate(@RequestParam RatesDto ratesDto){
        return exchangeRateFasade.createRate(ratesDto);
    }
}

