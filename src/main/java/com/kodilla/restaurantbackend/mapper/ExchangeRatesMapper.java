package com.kodilla.restaurantbackend.mapper;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
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
}
