package com.kodilla.restaurantbackend.client;

import com.kodilla.restaurantbackend.config.MealConfig;
import com.kodilla.restaurantbackend.domain.CreatedMealDto;
import com.kodilla.restaurantbackend.domain.MealDto;
import com.kodilla.restaurantbackend.domain.MealExternalDto;
import com.kodilla.restaurantbackend.domain.MealsDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MealClientTestSuites {
    @InjectMocks
    private MealClient mealClient;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private MealConfig mealConfig;

    @Test
    void testShouldFetchRandomMeal() throws URISyntaxException {
        //Given
        List<MealExternalDto> mealsDtoList = new ArrayList<>();
        when(mealConfig.getMealEndPoint()).thenReturn("http://test.com");
        when(mealConfig.getMealRandom()).thenReturn("/test");
        MealExternalDto mealExternalDto = new MealExternalDto("name", "category", "area", "instruction", "yt");
        mealsDtoList.add(mealExternalDto);
        MealsDto mealsDto = new MealsDto(mealsDtoList);
        URI url = new URI("http://test.com/test");
        when(restTemplate.getForObject(url, MealsDto.class)).thenReturn(mealsDto);
        //When
        MealsDto fetchedMeals = mealClient.getRandomMeal();
        //Then
        assertEquals(1, fetchedMeals.meals.size());
    }
    @Test
    void testShouldCreateMeal() throws URISyntaxException {
        //Given
        when(mealConfig.getMealEndPoint()).thenReturn("http://test.com");
        when(mealConfig.getMealRandom()).thenReturn("/test");
        MealDto mealDto = new MealDto("name", "category", "area", "instruction", "yt");
        URI url = new URI("http://test.com/test");
        CreatedMealDto createdMealDto = new CreatedMealDto("name1", "category1", "area1", "instruction1", "yt1");
        when(restTemplate.postForObject(url, null, CreatedMealDto.class)).thenReturn(createdMealDto);
        //When
        CreatedMealDto newMeal = mealClient.createNewMeal(mealDto);
        //Then
        assertEquals("name1", newMeal.getMealName());
        assertEquals("area1", newMeal.getMealArea());
        assertEquals("category1", newMeal.getMealCategory());
        assertEquals("instruction1", newMeal.getMealInstructions());
        assertEquals("yt1", newMeal.getMealYoutube());
    }
}
