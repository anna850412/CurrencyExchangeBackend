package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.domain.CreatedMealDto;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.MealDto;
import com.kodilla.restaurantbackend.fasade.MealFacade;
import com.kodilla.restaurantbackend.mapper.MealMapper;
import com.kodilla.restaurantbackend.service.MealService;
import com.kodilla.restaurantbackend.service.TenDishesService;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(MealController.class)
public class MealControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MealFacade mealFacade;
    @MockBean
    private MealClient mealClient;
    @MockBean
    private MealService mealService;
    @MockBean
    private MealMapper mealMapper;
    @MockBean
    private TenDishesService tenDishesService;
    @MockBean
    private MealController mealController;

    @Test
    void shouldFetchEmptyMeal() throws Exception {
        //Given
        when(mealService.findAllMeals()).thenReturn(Collections.emptyList());
        //When@Then
        mockMvc.perform(MockMvcRequestBuilders
                .get("/v1/meal/getAllMeals")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void shouldCreateMeal(){
        //Given
        CreatedMealDto createdMealDto = new CreatedMealDto("name", "cat", "area", "inst", "yt");
        MealDto mealDto = new MealDto("nameDto", "categoryDto", "areaDto","instructionsDto", "ytDto");
        when(mealFacade.createMeal(any(MealDto.class))).thenReturn(createdMealDto);

        //When&Then
    }


}

