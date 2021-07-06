package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.exceptions.RatesNotFoundException;
import com.kodilla.restaurantbackend.fasade.ExchangeRateFasade;
import com.kodilla.restaurantbackend.mapper.ExchangeRatesMapper;
import com.kodilla.restaurantbackend.service.ExchangeRatesService;
import com.kodilla.restaurantbackend.service.RatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExchangeRatesController {
    @Autowired
    private final ExchangeRateFasade exchangeRateFasade;
    private final ExchangeRatesService exchangeRatesService;
    private final ExchangeRatesMapper exchangeRatesMapper;
    private final RatesService ratesService;

    @RequestMapping(method = RequestMethod.GET, value = "/allRates")
    public List<ExchangeRatesLatestDto> getLatest() {
        return exchangeRatesMapper.mapToExchangeRatesLatestDtoList(exchangeRatesService.getAllRates());
//    return exchangeRatesMapper.mapToExchangeRatesLatestList(exchangeRateFasade.fetchExchangeRatesLatest());
    }

    @GetMapping(value = "/findBaseRate")
    public ExchangeRatesLatest findByBaseRate(@RequestParam String base) {
        return exchangeRatesService.getBaseRate(base);
    }

    @GetMapping(value = "/findDate")
    public ExchangeRatesLatest findByBaseDate(@RequestParam String date) {
        return exchangeRatesService.getDate(date);
    }

    @GetMapping(value = "/rates/{latestId}")
    public ExchangeRatesLatestDto getRatesId(@RequestParam Long latestId) throws RatesNotFoundException {
        return exchangeRatesMapper.mapToExchangeRatesLatestDto(
                exchangeRatesService.findLatestRateById(latestId).orElseThrow(RatesNotFoundException::new));
    }

    @DeleteMapping(value = "/deleteRates/{latestId}")
    public void deleteRates(@RequestParam Long latestId) {
        exchangeRatesService.deleteExchangeRatesById(latestId);
    }

    @PutMapping(value = "/rates")
    public ExchangeRatesLatest updateRates(@RequestBody ExchangeRatesLatestDto exchangeRatesLatestDto) {

        ExchangeRatesLatest exchangeRatesLatest = exchangeRatesMapper.mapToExchangeRatesLatest(exchangeRatesLatestDto);
        Rate rate = exchangeRatesLatest.getRate();
        ratesService.saveRates(rate);
        exchangeRatesService.saveLatestExchangeRate(exchangeRatesLatest);
        return exchangeRatesLatest;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createExchangeRates", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ExchangeRatesLatestDto createRate(@RequestBody ExchangeRatesLatestDto exchangeRatesLatestDto) {
        Rate rate = exchangeRatesMapper.mapToRates(exchangeRatesLatestDto.getRatesDto());
        ratesService.saveRates(rate);
        ExchangeRatesLatest exchangeRatesLatest = exchangeRatesMapper.mapToExchangeRatesLatest(exchangeRatesLatestDto);
        exchangeRatesLatest.setRate(rate);
        exchangeRatesService.saveLatestExchangeRate(exchangeRatesLatest);
        return exchangeRatesLatestDto;
    }
}
