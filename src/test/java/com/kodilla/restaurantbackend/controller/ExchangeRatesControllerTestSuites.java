package com.kodilla.restaurantbackend.controller;

import com.google.gson.Gson;
import com.kodilla.restaurantbackend.domain.*;
import com.kodilla.restaurantbackend.fasade.ExchangeRateFasade;
import com.kodilla.restaurantbackend.fasade.MealFacade;
import com.kodilla.restaurantbackend.mapper.ExchangeRatesMapper;
import com.kodilla.restaurantbackend.service.ExchangeRatesService;
import com.kodilla.restaurantbackend.service.ExchangeRatesServiceDto;
import com.kodilla.restaurantbackend.validator.ExchangeRatesValidator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(ExchangeRatesController.class)
public class ExchangeRatesControllerTestSuites {
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
    private ExchangeRatesService exchangeRatesService;
    @MockBean
    private ExchangeRatesControllerDto exchangeRatesControllerDto;
    @MockBean
    private MealFacade mealFacade;
/*
    @Test
    void shouldFetchEmptyExchangeRatesLatest() throws Exception{
    //Given
    when(exchangeRatesServiceDto.getAllRatesDto()).thenReturn((ExchangeRatesLatestDto) Collections.emptyList());
    //When&Then
        mockMvc.perform(MockMvcRequestBuilders
        .get("/v1/allRates")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }
    @Test
    void shouldFetchExchangeRatesLatest() throws Exception {
        //Given
        RatesDto ratesDto = new RatesDto(4.5, 3.2, 1.4);
        Rate rate = new Rate(4.5, 3.2, 1.4);
        ExchangeRatesLatestDto exchangeRatesLatestDto = new ExchangeRatesLatestDto(true, 123, "eur", "2021-07-03", ratesDto);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 123, "eur", "2021-07-03", rate);
        when(exchangeRateFasade.fetchExchangeRatesLatest()).thenReturn(exchangeRatesLatestDto);
        when(exchangeRatesServiceDto.getAllRatesDto()).thenReturn(exchangeRatesLatestDto);
        when(exchangeRatesValidator.validateExchangeRates(exchangeRatesLatest)).thenReturn(exchangeRatesLatest);
        when(exchangeRatesMapper.mapToExchangeRatesLatest(exchangeRatesLatestDto)).thenReturn(exchangeRatesLatest);
        when(exchangeRatesMapper.mapToExchangeRatesLatestDto(exchangeRatesLatest)).thenReturn(exchangeRatesLatestDto);
        //When&Then

        mockMvc.perform(
//                MockMvcRequestBuilders
                get("/v1/exchangeRates/getLatestRates")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", Matchers.is(123)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.base", Matchers.is("eur")));
    }


    @Test
    void testShouldCreateRate() throws Exception {
        //Given
        RatesDto ratesDto = new RatesDto(2.0, 3.0 ,4.0);
        CreatedRateDto createdRateDto = new CreatedRateDto(3.0 ,4.0, 5.0);
        when(exchangeRateFasade.createRate(any(RatesDto.class))).thenReturn(createdRateDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(ratesDto);
        //When&Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/exchangeRates/createRate")
                        .characterEncoding("UTF-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.jsonPath("$.pln", Matchers.is(3.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.usd", Matchers.is(4.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gbp", Matchers.is(5.0))
                );
    }
    @Test
    @Disabled
    void shouldCreateMeal(){
        //Given
        CreatedMealDto createdMealDto = new CreatedMealDto("name", "cat", "area", "inst", "yt");
        MealDto mealDto = new MealDto("nameDto", "categoryDto", "areaDto","instructionsDto", "ytDto");
        when(mealFacade.createMeal(any(MealDto.class))).thenReturn(createdMealDto);

        //When&Then


    }

 */
}

