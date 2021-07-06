package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.domain.RatesDto;
import com.kodilla.restaurantbackend.fasade.ExchangeRateFasade;
import com.kodilla.restaurantbackend.service.ExchangeRatesService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(ExchangeRatesController.class)
public class ExchangeRatesControllerTestSuites {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ExchangeRateFasade exchangeRateFasade;
    @MockBean
    private ExchangeRatesService exchangeRatesService;
    @MockBean
    private ExchangeRatesController exchangeRatesController;

    @Test
    void shouldFetchEmptyExchangeRatesLatest() throws Exception{
    //Given
    when(exchangeRatesService.getAllRates()).thenReturn(Collections.emptyList());
    //When&Then
        mockMvc.perform(MockMvcRequestBuilders
        .get("/v1/allRates")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }
}
