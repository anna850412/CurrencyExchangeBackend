package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.domain.RatesDto;
import com.kodilla.restaurantbackend.fasade.ExchangeRateFasade;
import com.kodilla.restaurantbackend.mapper.ExchangeRatesMapper;
import com.kodilla.restaurantbackend.service.ExchangeRatesServiceDto;
import com.kodilla.restaurantbackend.validator.ExchangeRatesValidator;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(ExchangeRatesControllerDto.class)
public class ExchangeRatesControllerDtoTestSuites {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ExchangeRateFasade exchangeRateFasade;
    @MockBean
    private ExchangeRatesValidator exchangeRatesValidator;
    @MockBean
    private ExchangeRatesMapper exchangeRatesMapper;
    @MockBean
    private ExchangeRatesServiceDto exchangeRatesServiceDto;
    @MockBean
    private ExchangeRatesControllerDto exchangeRatesControllerDto;

    @Test
    void shouldFetchExchangeRatesLatest() throws Exception {
        //Given
        RatesDto ratesDto = new RatesDto(4.5, 3.2, 1.4);
        Rate rate = new Rate(4.5, 3.2, 1.4);
        ExchangeRatesLatestDto exchangeRatesLatestDto = new ExchangeRatesLatestDto(true, 123, "eur", "2021-07-03", ratesDto);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 123, "eur", "2021-07-03", rate);
        when(exchangeRateFasade.fetchExchangeRatesLatest()).thenReturn(exchangeRatesLatestDto);
        when(exchangeRatesValidator.validateExchangeRates(exchangeRatesLatest)).thenReturn(exchangeRatesLatest);
        when(exchangeRatesMapper.mapToExchangeRatesLatest(exchangeRatesLatestDto)).thenReturn(exchangeRatesLatest);
        when(exchangeRatesMapper.mapToExchangeRatesLatestDto(exchangeRatesLatest)).thenReturn(exchangeRatesLatestDto);
        //When&Then

        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/exchangeRates/getLatestRates")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", Matchers.is(123)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.base", Matchers.is("eur")));
    }

}
