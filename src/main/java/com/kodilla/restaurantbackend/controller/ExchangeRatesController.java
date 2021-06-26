package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.mapper.ExchangeRatesMapper;
import com.kodilla.restaurantbackend.service.ExchangeRatesService;
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

    @RequestMapping(method = RequestMethod.GET, value = "/rates")
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

    @GetMapping(value = "/rates/{rateId}")
    public ExchangeRatesLatestDto getRatesId(@PathVariable Long latestId) throws RatesNotFoundException {
        return exchangeRatesMapper.mapToExchangeRatesLatestDto(
                exchangeRatesService.findLatestRateById(latestId).orElseThrow(RatesNotFoundException::new));
    }

    @DeleteMapping(value = "/deleteRates/{rateId}")
    public void deleteRates(@PathVariable Long latestId) {
        exchangeRatesService.deleteExchangeRatesById(latestId);
    }

    @PutMapping(value = "/rates")
    public ExchangeRatesLatestDto updateRates(@RequestBody ExchangeRatesLatestDto exchangeRatesLatestDto) {
        return exchangeRatesMapper.mapToExchangeRatesLatestDto(
                exchangeRatesService.saveLatestExchangeRate(
                        exchangeRatesMapper.mapToExchangeRatesLatest(exchangeRatesLatestDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rates", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createRate(@RequestBody ExchangeRatesLatestDto exchangeRatesLatestDto) {
        exchangeRatesService.saveLatestExchangeRate(exchangeRatesMapper.mapToExchangeRatesLatest(exchangeRatesLatestDto));
    }
}
