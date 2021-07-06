package com.kodilla.restaurantbackend.mapper;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.domain.RatesDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Exchange Rates Mapper Test Suites")
public class ExchangeRatesMapperTestSuite {
    @InjectMocks
    private ExchangeRatesMapper exchangeRatesMapper;
    @Test
    void testMapToRates(){
        //Given
        RatesDto ratesDto = new RatesDto(1.0,2.0,3.0);
        //When
        Rate mappedRate = exchangeRatesMapper.mapToRates(ratesDto);
        //Then
        assertEquals(1.0, mappedRate.getPln());
    }
    @Test
    void testMapToRatesDto(){
        //Given
        Rate rate = new Rate(1.0, 2.0, 3.0);
        //When
        RatesDto mappedRate = exchangeRatesMapper.mapToRatesDto(rate);
        //Then
        assertEquals(1.0, mappedRate.getPln());
    }
    @Test
    void testMapToExchangeRatesLatestDto(){
        //Given
        Rate rate = new Rate(1.0, 2.0, 3.0);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 123, "eur", "2021-07-03", rate);
        //When
        ExchangeRatesLatestDto mappedExchange = exchangeRatesMapper.mapToExchangeRatesLatestDto(exchangeRatesLatest);
        //Then
        assertEquals(123, mappedExchange.getTimestamp());
    }
    @Test
    void testMapToExchangeRatesLatest(){
        //Given
        RatesDto ratesDto = new RatesDto(1.0,2.0,3.0);
        ExchangeRatesLatestDto exchangeRatesLatestDto = new ExchangeRatesLatestDto(true, 123, "eur", "2021-07-03", ratesDto);
        //When
        ExchangeRatesLatest mappedExchange = exchangeRatesMapper.mapToExchangeRatesLatest(exchangeRatesLatestDto);
        //Then
        assertEquals(123, mappedExchange.getTimestamp());
    }
    @Test
    void testMapToExchangeRatesLatestDtoList(){
        //Given
        List<ExchangeRatesLatest> exchangeRatesLatestList = new ArrayList<>();
        Rate rate1 = new Rate(1.0, 2.0, 3.0);
        ExchangeRatesLatest exchangeRatesLatest1 = new ExchangeRatesLatest(true, 123, "eur", "2021-07-03", rate1);
        Rate rate2 = new Rate(1.0, 2.0, 3.0);
        ExchangeRatesLatest exchangeRatesLatest2 = new ExchangeRatesLatest(true, 123, "eur", "2021-07-03", rate2);
        exchangeRatesLatestList.add(exchangeRatesLatest1);
        exchangeRatesLatestList.add(exchangeRatesLatest2);
        //When
        List<ExchangeRatesLatestDto> exchangeRatesLatestDtoList = exchangeRatesMapper.mapToExchangeRatesLatestDtoList(exchangeRatesLatestList);
        //Then
        assertEquals(2, exchangeRatesLatestDtoList.size());
    }
}
