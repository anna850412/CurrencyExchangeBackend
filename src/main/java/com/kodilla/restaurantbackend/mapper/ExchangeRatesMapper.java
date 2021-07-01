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

    public Rate mapToRates(RatesDto ratesDto) {
        return new Rate(
                ratesDto.getPln(),
                ratesDto.getGbp(),
                ratesDto.getUsd()
        );
    }

    public RatesDto mapToRatesDto(Rate rate) {
        return new RatesDto(
                rate.getPln(),
                rate.getGbp(),
                rate.getUsd()
        );
    }

    public ExchangeRatesLatestDto mapToExchangeRatesLatestDto(ExchangeRatesLatest exchangeRatesLatest) {
        return new ExchangeRatesLatestDto(
                exchangeRatesLatest.isSuccess(),
                exchangeRatesLatest.getTimestamp(),
                exchangeRatesLatest.getBase(),
                exchangeRatesLatest.getDate(),
//                mapToRatesDto((Rate) exchangeRatesLatest.getRateList())
                mapToRatesDto(exchangeRatesLatest.getRate())
        );
    }

   public ExchangeRatesLatest mapToExchangeRatesLatest(ExchangeRatesLatestDto exchangeRatesLatestDto) {
        return new ExchangeRatesLatest(
                exchangeRatesLatestDto.isSuccess(),
                exchangeRatesLatestDto.getTimestamp(),
                exchangeRatesLatestDto.getBase(),
                exchangeRatesLatestDto.getDate(),
                mapToRates(exchangeRatesLatestDto.getRatesDto()));
    }

    public List<ExchangeRatesLatestDto> mapToExchangeRatesLatestDtoList(final List<ExchangeRatesLatest> exchangeRatesLatestList) {
        return exchangeRatesLatestList.stream()
                .map(this::mapToExchangeRatesLatestDto)
                .collect(Collectors.toList());
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

    public List<RatesDto> mapToRatesDtoList(final List<Rate> ratesList) {
        return ratesList.stream()
                .map(rateDto -> new RatesDto(rateDto.getGbp(), rateDto.getPln(), rateDto.getUsd()))
                .collect(toList());
    }
}
