package com.kodilla.restaurantbackend.mapper;

import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.MealDto;
import com.kodilla.restaurantbackend.domain.MealExternalDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Meal Mapper Test Suites")
public class MealMapperTestSuites {
    @InjectMocks
    private MealMapper mealMapper;
    @Test
    void testMapFromMealDtoToMeal(){
        //Given
        MealDto mealDto = new MealDto("name", "category", "area", "instruction", "YT");
        //When
        Meal mappedMeal = mealMapper.mapFromMealDtoToMeal(mealDto);
        //Then
        assertEquals("area", mappedMeal.getStrArea());
    }
    @Test
    void testMapFromMealExternalDtoToMeal(){
        //Given
        MealExternalDto mealExternalDto = new MealExternalDto("name", "cat", "area", "inst", "YT");
        //When
        Meal mappedMeal = mealMapper.mapFromMealExternalDtoToMeal(mealExternalDto);
        //Then
        assertEquals("cat", mappedMeal.getStrCategory());
    }
    @Test
    void testToMealExternalDtoList(){
        //Given
        List<Meal> mealList = new ArrayList<>();
        Meal meal1 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal2 = new Meal("name2", "category2", "area2", "instruction2", "YT2");
        mealList.add(meal1);
        mealList.add(meal2);
        //When
        List<MealExternalDto> mappedMeal = mealMapper.mapToMealExternalDtoList(mealList);
        //Then
        assertEquals(2, mappedMeal.size());
        assertEquals("name", mappedMeal.get(0).getStrMeal());
        assertEquals("name2", mappedMeal.get(1).getStrMeal());
    }
    @Test
    void testToMealDtoList(){
        //Given
        List<Meal> mealList = new ArrayList<>();
        Meal meal1 = new Meal("name", "category", "area", "instruction", "YT");
        Meal meal2 = new Meal("name2", "category2", "area2", "instruction2", "YT2");
        mealList.add(meal1);
        mealList.add(meal2);
        //When
        List<MealDto> mappedMeal = mealMapper.mapToMealDtoList(mealList);
        //Then
        assertEquals(2, mappedMeal.size());
        assertEquals("name", mappedMeal.get(0).getStrMeal());
        assertEquals("name2", mappedMeal.get(1).getStrMeal());
    }
    @Test
    void testMapFromMealToMealDto(){
        //Given
        Meal meal = new Meal("name", "category", "area", "instruction", "YT");
        //When
        MealDto mappedMeal = mealMapper.mapFromMealToMealDto(meal);
        //Then
        assertEquals("area", mappedMeal.getStrArea());
    }
}
