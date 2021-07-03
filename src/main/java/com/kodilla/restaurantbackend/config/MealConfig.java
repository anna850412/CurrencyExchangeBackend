package com.kodilla.restaurantbackend.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MealConfig {
    @Value("${meal.endpoint}")
    private String mealEndPoint;
    @Value("${meal.random}")
    private String mealRandom;
    @Value("${meal.categories}")
    private String mealCategories;

}
