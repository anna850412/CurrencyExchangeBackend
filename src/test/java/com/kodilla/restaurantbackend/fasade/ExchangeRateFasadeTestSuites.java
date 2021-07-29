package com.kodilla.restaurantbackend.fasade;

import com.kodilla.restaurantbackend.domain.*;
import com.kodilla.restaurantbackend.mapper.ExchangeRatesMapper;
import com.kodilla.restaurantbackend.service.ExchangeRatesService;
import com.kodilla.restaurantbackend.service.ExchangeRatesServiceDto;
import com.kodilla.restaurantbackend.validator.ExchangeRatesValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExchangeRateFasadeTestSuites {
    @InjectMocks
    private ExchangeRateFasade exchangeRateFasade;
    @Mock
    private ExchangeRatesService exchangeRatesService;
    @Mock
    private ExchangeRatesServiceDto exchangeRatesServiceDto;
    @Mock
    private ExchangeRatesMapper exchangeRatesMapper;
    @Mock
    private ExchangeRatesValidator exchangeRatesValidator;

    @Test
    void testCreateRate(){
        //Given
        CreatedRateDto createdRateDto = new CreatedRateDto(1.0, 2.0, 3.0);
        RatesDto ratesDto = new RatesDto(2.0, 3.0, 4.0);
        Rate rate = new Rate(3.0, 4.0, 5.0);
        when(exchangeRatesServiceDto.createRate(ratesDto)).thenReturn(createdRateDto);
        when(exchangeRatesMapper.mapToRates(ratesDto)).thenReturn(rate);
        when(exchangeRatesMapper.mapToRatesDto(rate)).thenReturn(ratesDto);
        doNothing().when(exchangeRatesValidator).validateRates(any(Rate.class));
        //When
        CreatedRateDto newRate = exchangeRateFasade.createRate(ratesDto);
        //Then
        assertThat(newRate).isNotNull();
        assertEquals(1.0, newRate.getPln());
        assertEquals(2.0, newRate.getUsd());
        assertEquals(3.0, newRate.getGbp());
        assertEquals(2.0, ratesDto.getPln());
        assertEquals(3.0, ratesDto.getUsd());
        assertEquals(4.0, ratesDto.getGbp());
    }
    @Test

    void testFetchExchangeRatesLatest(){

    }
}
