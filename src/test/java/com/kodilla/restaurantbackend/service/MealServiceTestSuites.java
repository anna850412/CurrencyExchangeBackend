package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.config.AdminConfig;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.repository.MealRepository;
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
@DisplayName("Meal Service Test Suites")
public class MealServiceTestSuites {
    @InjectMocks
    private MealService mealService;
    @Mock
    private MealRepository mealRepository;
    @Mock
    private MealClient mealClient;
    @Mock
    private TenDishesService tenDishesService;
    @Mock
    private SimpleEmailService emailService;
    @Mock
    private AdminConfig adminConfig;
    @Test
    void testFindAllMeals(){
        //Given
        List<Meal> allMeals = new ArrayList<>();
        Meal meal1 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal2 = new Meal("name", "category", "area", "instruction", "YT");
        allMeals.add(meal1);
        allMeals.add(meal2);
        when(mealService.findAllMeals()).thenReturn(allMeals);
        //When
        allMeals = mealService.findAllMeals();
        //Then
        assertEquals(2, allMeals.size());
    }
    @Test
    void testSaveMeal(){
        //Given
        Meal meal = new Meal("name", "category", "area", "instruction", "YT");
        //When
        mealService.saveMeal(meal);
        //Then
        verify(mealRepository, times(1)).save(meal);
    }
}
