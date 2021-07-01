package com.kodilla.restaurantbackend.mapper;

import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.MealDto;
import com.kodilla.restaurantbackend.domain.MealExternalDto;
import org.springframework.stereotype.Component;

@Component
public class MealMapper {
public Meal mapFromMealDtoToMeal(final MealDto mealDto){
return new Meal(
        mealDto.getMealName(),
        mealDto.getMealCategory(),
        mealDto.getMealArea(),
        mealDto.getMealInstructions(),
        mealDto.getMealYoutube(),
        mealDto.getMealPrice()
);
}
public Meal mapFromMealExtrenalDtoToMeal(final MealExternalDto mealExternalDto){
    return new Meal(
            mealExternalDto.getStrMeal(),
            mealExternalDto.getStrCategory(),
            mealExternalDto.getStrArea(),
            mealExternalDto.getStrInstructions(),
            mealExternalDto.getStrYoutube()
    );
}
}
