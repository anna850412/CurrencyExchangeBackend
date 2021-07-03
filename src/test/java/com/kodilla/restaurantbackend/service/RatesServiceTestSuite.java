package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.repository.RatesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("Rates Service Test Suite")
public class RatesServiceTestSuite {
    @Mock
    private RatesRepository ratesRepository;
    @InjectMocks
    private RatesService ratesService;

    @Test
    void testRatesServiceSaveRates(){
        //Given
        Rate rate = new Rate(4.5, 2.0, 1.0);
        //When
        ratesService.saveRates(rate);
        //Then
        verify(ratesRepository, times(1)).save(rate);
    }
}
