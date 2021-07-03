package com.kodilla.restaurantbackend.mapper;

import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.domain.RatesDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void testMapTo(){
        //Given
        //When
        //Then
    }
}
