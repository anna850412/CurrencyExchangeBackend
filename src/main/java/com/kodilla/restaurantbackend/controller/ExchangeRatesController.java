package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.domain.*;
import com.kodilla.restaurantbackend.exceptions.RatesNotFoundException;
import com.kodilla.restaurantbackend.fasade.ExchangeRateFasade;
import com.kodilla.restaurantbackend.mapper.ExchangeRatesMapper;
import com.kodilla.restaurantbackend.service.AmountCalculationService;
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
    private final ExchangeRateFasade exchangeRateFasade;
    private final ExchangeRatesService exchangeRatesService;
    private final ExchangeRatesMapper exchangeRatesMapper;
    private final RatesService ratesService;
    private final AmountCalculationService amountCalculationService;

    @RequestMapping(method = RequestMethod.GET, value = "/getLatestRates")
    public ExchangeRatesLatestDto getLatestExchangeRates() {

        ExchangeRatesLatestDto latest = exchangeRateFasade.fetchExchangeRatesLatest();
//        System.out.println("base currency is " + latest.getBase() + " " + "from date " + latest.getDate());
//        System.out.println("This exchange rates contains currencies: ");
//        System.out.println("GBP" + " " + latest.getRatesDto().getGbp() + " " + "PLN " + " " + latest.getRatesDto().getPln()
//                + " " + "USD " + " " + latest.getRatesDto().getUsd());
        return latest;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createRate")
    public CreatedRateDto createRate(@RequestBody RatesDto ratesDto) {
        return exchangeRateFasade.createRate(ratesDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/calculateFromEURtoUSD")
    public Double calculateFromEURtoUSD(@RequestParam Double amount) {
        Double valueInUSD = amountCalculationService.calculateAmountFromEURToUSD(amount);
        return valueInUSD;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/calculateFromEURtoPLN")
    public Double calculateFromEURtoPLN(@RequestParam Double amount) {
        Double valueInPLN = amountCalculationService.calculateAmountFromEURToPLN(amount);
        return valueInPLN;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/calculateFromUSDtoEUR")
    public Double calculateFromUSDtoEUR(@RequestParam Double amount) {
        Double valueInUSD = amountCalculationService.calculateAmountFromUSDToEUR(amount);
        return valueInUSD;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/calculateFromPLNtoEUR")
    public Double calculateFromPLNtoEUR(@RequestParam Double amount) {
        Double valueInPLN = amountCalculationService.calculateAmountFromPLNToEUR(amount);
        return valueInPLN;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/calculateFromEURtoGBP")
    public Double calculateFromEURtoGBP(@RequestParam Double amount) {
        Double valueInEUR = amountCalculationService.calculateAmountFromEURToGBP(amount);
        return valueInEUR;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/calculateFromGBPtoEUR")
    public Double calculateFromGBPtoEUR(@RequestParam Double amount) {
        Double valueInGBP = amountCalculationService.calculateAmountFromGBPToEUR(amount);
        return valueInGBP;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/allRates")
    public List<ExchangeRatesLatestDto> getLatest() {
        return exchangeRatesMapper.mapToExchangeRatesLatestDtoList(exchangeRatesService.getAllRates());
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
