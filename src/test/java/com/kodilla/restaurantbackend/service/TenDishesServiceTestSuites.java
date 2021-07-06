package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.MealExternalDto;
import com.kodilla.restaurantbackend.domain.MealsDto;
import com.kodilla.restaurantbackend.mapper.MealMapper;
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

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("10 Dishes Service Test Suites")
public class TenDishesServiceTestSuites {
    @InjectMocks
    private TenDishesService tenDishesService;
    @Mock
    private MealRepository mealRepository;
    @Mock
    private MealMapper mealMapper;
    @Mock
    private MealClient mealClient;

    @Test
    void testGet10Recepients() {
        //Given
        List<Meal> tenMeals = new ArrayList<>();
        Meal meal1 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal2 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal3 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal4 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal5 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal6 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal7 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal8 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal9 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal10 = new Meal("name", "category", "area", "instruction", "YT");
        tenMeals.add(meal1);
        tenMeals.add(meal2);
        tenMeals.add(meal3);
        tenMeals.add(meal4);
        tenMeals.add(meal5);
        tenMeals.add(meal6);
        tenMeals.add(meal7);
        tenMeals.add(meal8);
        tenMeals.add(meal9);
        tenMeals.add(meal10);
        when(tenDishesService.get10Recipients()).thenReturn(tenMeals);
        //When
        tenMeals = tenDishesService.get10Recipients();
        //Then
        verify(mealRepository, times(10)).save((Meal) tenMeals);
    }
}
