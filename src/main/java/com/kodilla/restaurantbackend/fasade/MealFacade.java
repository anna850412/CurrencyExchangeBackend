package com.kodilla.restaurantbackend.fasade;

import com.kodilla.restaurantbackend.domain.*;
import com.kodilla.restaurantbackend.mapper.MealMapper;
import com.kodilla.restaurantbackend.service.MealService;
import com.kodilla.restaurantbackend.validator.MealValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MealFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(MealFacade.class);
    @Autowired
    private MealService mealService;
    @Autowired
    private MealMapper mealMapper;
    @Autowired
    private MealValidator mealValidator;

    public List<MealExternalDto> getAllMeals() {
        List<Meal> meals =  mealService.findAllMeals();
        List<Meal> filteredMeals = mealValidator.validateMealList(meals);
        return mealMapper.mapToMealExternalDtoList(filteredMeals);
    }

    public CreatedMealDto createMeal(final MealDto mealDto) {
        Meal meal = mealMapper.mapFromMealDtoToMeal(mealDto);
        mealValidator.validateMeal(meal);
        return mealService.createMeal(mealMapper.mapFromMealToMealDto(meal));
}
}
