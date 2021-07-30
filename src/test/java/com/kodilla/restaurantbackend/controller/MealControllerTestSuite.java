package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.client.MealClient;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
@WebMvcTest(MealController.class)
public class MealControllerTestSuite {
    @Autowired
    private MockMvc mockMvc;
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
        mockMvc.perform(get("/v1/meal/getAllMeals")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }
    @Test
    void testGet10Meals() throws Exception {
        //Given
        List<Meal> mealList= new ArrayList<>();
        Meal meal = new Meal("name1", "category1", "area1", "instr1", "yt1");
        Meal meal2 = new Meal("name2", "category2", "area2", "instr2", "yt2");
        mealList.add(meal);
        mealList.add(meal2);
        List<MealDto> mealDtoList = new ArrayList<>();
        MealDto mealDto1 = new MealDto("name", "category", "area", "instruction", "yt" );
        MealDto mealDto2 = new MealDto("name2", "category2", "area2", "instruction2", "yt2" );
        mealDtoList.add(mealDto1);
        mealDtoList.add(mealDto2);
        when(mealMapper.mapToMealDtoList(mealList)).thenReturn(mealDtoList);
        when(tenDishesService.get10Recipients()).thenReturn(  new ArrayList <Meal>()
//                mealMapper.mapFromMealDtoListToMealList(mealDtoList)
        );
        //When&Then
        mockMvc.perform(
                get("/v1/meal/get10Meals")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.strMeal", Matchers.is("name1")));
            }
    @Test
    void testGet10Categories(){
        //Given
        //When&Then
    }
}

