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
@RequestMapping("v1/exchangeRates")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExchangeRatesController {

    private final ExchangeRatesClient exchangeRatesClient;

    @RequestMapping(method = RequestMethod.GET, value = "/getLatestRates")
    public void getLatestExchangeRates() {
        List<ExchangeRatesLatestDto> latest = exchangeRatesClient.getExchangeRateLatest();
        latest.forEach(exchangeRatesLatestDto -> {
            System.out.println(exchangeRatesLatestDto.getBase() + "" + exchangeRatesLatestDto.getDate());
            System.out.println("This exchange rates contains lists: ");
            exchangeRatesLatestDto.getSymbols().forEach(Rate ->{
                System.out.println(Rate.getRate());
            });
        });
    }
}
