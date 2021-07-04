package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.MealDto;
import com.kodilla.restaurantbackend.domain.MealExternalDto;
import com.kodilla.restaurantbackend.domain.MealsDto;
import com.kodilla.restaurantbackend.mapper.MealMapper;
import com.kodilla.restaurantbackend.repository.MealRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class OneHundredDishesService {
    @Autowired
    private final MealClient mealClient;
    @Autowired
    private final MealMapper mealMapper;
    @Autowired
    private final MealRepository mealRepository;

    public List<Meal> get10Recipients() {
        List<Meal> tenMeals = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            MealsDto randomMeals = mealClient.getRandomMeal();
            MealExternalDto mealExtDto = randomMeals.meals[0];
            Meal meal = mealMapper.mapFromMealExtrenalDtoToMeal(mealExtDto);
            mealRepository.save(meal);
            tenMeals.add(meal);
        }
        return tenMeals;
    }
}
