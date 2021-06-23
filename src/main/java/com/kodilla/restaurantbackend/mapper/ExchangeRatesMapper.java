package com.kodilla.restaurantbackend.mapper;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.domain.RatesDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ExchangeRatesMapper {

    public List<ExchangeRatesLatestDto> mapToExchangeRatesLatestDtoList(final List<ExchangeRatesLatest> exchangeRatesLatestList){
    return exchangeRatesLatestList.stream()
            .map(this::mapToExchangeRatesLatestDto)
            .collect(Collectors.toList());}

    private ExchangeRatesLatestDto mapToExchangeRatesLatestDto(ExchangeRatesLatest exchangeRatesLatest) {
        return new ExchangeRatesLatestDto(
                exchangeRatesLatest.getBase(),
                exchangeRatesLatest.getDate(),
                exchangeRatesLatest.getSymbols());
    }

    public List<ExchangeRatesLatest> mapToExchangeRatesLatestList(final List<ExchangeRatesLatestDto> exchangeRatesLatestDtoList) {
    return exchangeRatesLatestDtoList.stream()
            .map(this::mapToExchangeRatesLatest)
            .collect(Collectors.toList());
    }
    public List<Rate> mapToList(final List<RatesDto> ratesListDto) {
        return ratesListDto.stream()
                .map(rate -> new Rate(rate.getPln(), rate.getUsd(), rate.getGbp()))
                .collect(toList());
    }
    private ExchangeRatesLatest mapToExchangeRatesLatest(ExchangeRatesLatestDto exchangeRatesLatestDto) {
        return new ExchangeRatesLatest(
                exchangeRatesLatestDto.getBase(),
                exchangeRatesLatestDto.getDate(),
                mapToList(exchangeRatesLatestDto.getSymbols())
        )
    }
}
