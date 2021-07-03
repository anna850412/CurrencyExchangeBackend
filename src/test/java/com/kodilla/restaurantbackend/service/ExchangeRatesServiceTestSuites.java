package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.repository.ExchangeRatesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("Exchange Rates Service Test Suites")
public class ExchangeRatesServiceTestSuites {
    @Mock
    private ExchangeRatesRepository exchangeRatesRepository;
    @InjectMocks
    private ExchangeRatesService exchangeRatesService;

    @Test
    void testExchangeRatesServiceSaveLatestExchangeRates(){
        //Given
        Rate rate = new Rate(4.5, 2.0, 1.0);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 1233,"eur","2021-07-03", rate);
        //When
        exchangeRatesService.saveLatestExchangeRate(exchangeRatesLatest);
        //Then
        verify(exchangeRatesRepository, times(1)).save(exchangeRatesLatest);
    }
    @Test
    void testExchangeRatesServiceFindAllRates(){
        //Given
        List<ExchangeRatesLatest> allRates = new ArrayList<>();
        Rate rate1 = new Rate(4.5, 2.0, 1.0);
        ExchangeRatesLatest exchangeRatesLatest1 = new ExchangeRatesLatest(true, 1233,"eur","2021-07-03", rate1);
        Rate rate2 = new Rate(3.5, 1.5, 2.0);
        ExchangeRatesLatest exchangeRatesLatest2 = new ExchangeRatesLatest(true, 1233,"eur","2021-07-03", rate2);
        allRates.add(exchangeRatesLatest1);
        allRates.add(exchangeRatesLatest2);
        when(exchangeRatesService.getAllRates()).thenReturn(allRates);
        //When
        allRates = exchangeRatesService.getAllRates();
        //Then
        assertEquals(2, allRates.size());
    }
    @Test
    void testExchangeRatesServiceFindLatestRateById(){
        //Given
        Rate rate = new Rate(4.5, 2.0, 1.0);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 1233,"eur","2021-07-03", rate);
        Long exchangeRateLatestId = exchangeRatesLatest.getId();
        //When
        exchangeRatesService.findLatestRateById(exchangeRateLatestId);
        //Then
        verify(exchangeRatesRepository, times(1)).findById(exchangeRateLatestId);
    }
    @Test
    void testExchangeRatesServiceGetDate(){
        //Given
        Rate rate = new Rate(4.5, 2.0, 1.0);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 1233,"eur","2021-07-03", rate);
        String exchangeRateLatestDate = exchangeRatesLatest.getDate();
        //When
        exchangeRatesService.getDate(exchangeRateLatestDate);
        //Then
        verify(exchangeRatesRepository, times(1)).findByDate(exchangeRateLatestDate);
    }
    @Test
    void testExchangeRatesServiceGetBaseRate(){
        //Given
        Rate rate = new Rate(4.5, 2.0, 1.0);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 1233,"eur","2021-07-03", rate);
        String baseRate = exchangeRatesLatest.getBase();
        //When
        exchangeRatesService.getBaseRate(baseRate);
        //Then
        verify(exchangeRatesRepository, times(1)).findByBase(baseRate);
    }
    @Test
    void testExchangeRatesServiceDeleteExchangeRatesById(){
        //Given
        Rate rate = new Rate(4.5, 2.0, 1.0);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 1233,"eur","2021-07-03", rate);
        Long exchangeRateLatestId = exchangeRatesLatest.getId();
        //When
        exchangeRatesService.deleteExchangeRatesById(exchangeRateLatestId);
        //Then
        verify(exchangeRatesRepository, times(1)).deleteById(exchangeRateLatestId);
    }
}
