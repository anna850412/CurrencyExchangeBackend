package com.kodilla.restaurantbackend.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class PriceCalculator {
    @Autowired
    private MealDto mealDto;
    public Double calculatePrice(MealDto mealDto){
        if(mealDto.getStrIngredient1().equals("Bacon")){
            return 3.0;
        } else if (mealDto.getStrIngredient1().length()>10){
            return 5.0;
        } else if (mealDto.getStrIngredient1().contains("a")){
            return 3.0;
        } else {
            return 2.0;
        }
    }
}
