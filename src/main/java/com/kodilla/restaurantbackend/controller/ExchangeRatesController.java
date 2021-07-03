package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.exceptions.RatesNotFoundException;
import com.kodilla.restaurantbackend.mapper.ExchangeRatesMapper;
import com.kodilla.restaurantbackend.service.ExchangeRatesService;
import com.kodilla.restaurantbackend.service.RatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExchangeRatesController {
    private final ExchangeRatesService exchangeRatesService;
    private final ExchangeRatesMapper exchangeRatesMapper;
    private final RatesService ratesService;

    @RequestMapping(method = RequestMethod.GET, value = "/rates")
    public List<ExchangeRatesLatestDto> getLatest() {
        return exchangeRatesMapper.mapToExchangeRatesLatestDtoList(exchangeRatesService.getAllRates());
    }

    @GetMapping(value = "/findBaseRate")
    public ExchangeRatesLatest findByBaseRate(@RequestParam String base) {
        return exchangeRatesService.getBaseRate(base);
    }

    @GetMapping(value = "/findDate")
    public ExchangeRatesLatestDto findByBaseDate(@RequestParam String date) {
        return exchangeRatesMapper.mapToExchangeRatesLatestDto(exchangeRatesService.getDate(date));
    }

    @GetMapping(value = "/rates/{latestId}")
    public ExchangeRatesLatestDto getRatesId(@PathVariable Long latestId) throws RatesNotFoundException {
        return exchangeRatesMapper.mapToExchangeRatesLatestDto(
                exchangeRatesService.findLatestRateById(latestId).orElseThrow(RatesNotFoundException::new));
    }

    @DeleteMapping(value = "/deleteRates/{latestId}")
    public void deleteRates(@RequestParam Long latestId) {
        exchangeRatesService.deleteExchangeRatesById(latestId);
    }

    @PutMapping(value = "/rates")
    public ExchangeRatesLatestDto updateRates(@RequestBody ExchangeRatesLatestDto exchangeRatesLatestDto) {
        Rate rate = exchangeRatesMapper.mapToRates(exchangeRatesLatestDto.getRatesDto());
        ratesService.saveRates(rate);
        exchangeRatesMapper.mapToExchangeRatesLatestDto(
                exchangeRatesService.saveLatestExchangeRate(
                        exchangeRatesMapper.mapToExchangeRatesLatest(exchangeRatesLatestDto)));
        return exchangeRatesLatestDto;
    }
/*
    @RequestMapping(method = RequestMethod.POST, value = "/createRates", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Rate createRate(@RequestBody ExchangeRatesLatestDto exchangeRatesLatestDto) {
        Rate rate = exchangeRatesMapper.mapToRates(exchangeRatesLatestDto.getRatesDto());
        ratesService.saveRates(rate);

        ExchangeRatesLatest exchangeRatesLatest = exchangeRatesMapper.mapToExchangeRatesLatest(exchangeRatesLatestDto);
        exchangeRatesService.saveLatestExchangeRate(exchangeRatesLatest);
//        exchangeRatesLatest.setRateList((List<Rate>) exchangeRatesMapper.mapToRatesDto(rate));
        exchangeRatesLatest.setRate(rate);

 return rate;
    }
    */
    @RequestMapping(method = RequestMethod.POST, value = "/createExchangeRates", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ExchangeRatesLatestDto createRate(@RequestBody ExchangeRatesLatestDto exchangeRatesLatestDto){
        Rate rate = exchangeRatesMapper.mapToRates(exchangeRatesLatestDto.getRatesDto());
        ratesService.saveRates(rate);
        ExchangeRatesLatest exchangeRatesLatest = exchangeRatesMapper.mapToExchangeRatesLatest(exchangeRatesLatestDto);
        exchangeRatesLatest.setRate(rate);
        exchangeRatesService.saveLatestExchangeRate(exchangeRatesLatest);
        return exchangeRatesLatestDto;
    }
}
