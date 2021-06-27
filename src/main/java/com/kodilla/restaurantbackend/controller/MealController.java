package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.domain.MealDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/meal")
@RequiredArgsConstructor
public class MealController {
    private final MealClient mealClient;

    @GetMapping(value = "getMeals")
    public void getMeals(){
        List<MealDto> mealsList = mealClient.getMealsList();
        mealsList.forEach(mealDto ->
                System.out.println("category: " + mealDto.getStrCategory() +
                        "name: " + mealDto.getStrMeal()));
    }
}
