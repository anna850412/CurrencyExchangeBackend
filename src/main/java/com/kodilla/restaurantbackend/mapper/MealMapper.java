package com.kodilla.restaurantbackend.mapper;

import com.kodilla.restaurantbackend.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MealMapper {
public Meal mapFromMealDtoToMeal(final MealDto mealDto){
return new Meal(
        mealDto.getStrMeal(),
        mealDto.getStrCategory(),
        mealDto.getStrArea(),
        mealDto.getStrInstructions(),
        mealDto.getStrYoutube()
);
}
public Meal mapFromMealExternalDtoToMeal(final MealExternalDto mealExternalDto){
    return new Meal(
            mealExternalDto.getStrMeal(),
            mealExternalDto.getStrCategory(),
            mealExternalDto.getStrArea(),
            mealExternalDto.getStrInstructions(),
            mealExternalDto.getStrYoutube()
    );
}
public List<MealExternalDto> mapToMealExternalDtoList(final List<Meal> mealList){
    return (List<MealExternalDto>) mealList.stream()
.map(meal -> new MealExternalDto(meal.getStrMeal(), meal.getStrCategory(), meal.getStrArea(), meal.getStrInstructions(), meal.getStrYoutube()))
.collect(Collectors.toList());
}

    public MealDto mapFromMealToMealDto(Meal meal) {
    return new MealDto(
            meal.getStrMeal(),
            meal.getStrCategory(),
            meal.getStrArea(),
            meal.getStrInstructions(),
            meal.getStrYoutube());
    }

    public List<MealDto> mapToMealDtoList(List<Meal> mealList) {
    return mealList.stream()
            .map(meal -> new MealDto(meal.getStrMeal(), meal.getStrArea(), meal.getStrCategory(), meal.getStrYoutube(), meal.getStrInstructions()))
            .collect(Collectors.toList());
    }
}
