package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.MealExternalDto;
import com.kodilla.restaurantbackend.domain.MealsDto;
import com.kodilla.restaurantbackend.mapper.MealMapper;
import com.kodilla.restaurantbackend.repository.MealRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class TenDishesService {
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
            MealExternalDto mealExtDto = randomMeals.meals.get(0);
            Meal meal = mealMapper.mapFromMealExternalDtoToMeal(mealExtDto);
//                    new Meal(
//                    mealExtDto.getStrMeal(),
//                    mealExtDto.getStrCategory(),
//                    mealExtDto.getStrArea(),
//                    mealExtDto.getStrInstructions(),
//                    mealExtDto.getStrYoutube());
            mealRepository.save(meal);
            tenMeals.add(meal);
        }
        return tenMeals;
    }
/*
    public List<Meal> getAllCategories() {
        List<Meal> categories = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            MealsDto randomMeals = mealClient.getRandomMeal();
            List<MealExternalDto> randomCategories = randomMeals.getMeals().stream().map(n -> n.getStrCategory()).collect(Collectors.toList());
            MealExternalDto mealExtDto = randomCategories.get(0);
            Meal meal = mealMapper.mapFromMealExternalDtoToMeal(mealExtDto);
            categories.add(meal);
        }
        return categories;
    }

 */
}


