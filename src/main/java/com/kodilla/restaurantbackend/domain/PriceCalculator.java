package com.kodilla.restaurantbackend.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class PriceCalculator {
    @Autowired
    private MealExternalDto mealExternalDto;
    public Double calculatePrice(Double price){
        if(mealExternalDto.getStrCategory().equals("Dessert")){
            return 10.0;
        } else if (mealExternalDto.getStrCategory().equals("Chicken")){
            return 12.0;
        } else if (mealExternalDto.getStrCategory().equals("Lamb")){
            return 13.0;
        } else if (mealExternalDto.getStrCategory().equals("Pork")){
            return 14.0;
        } else if(mealExternalDto.getStrCategory().equals("Beef")){
            return 15.0;
        } else if (mealExternalDto.getStrCategory().equals("Seafood")){
            return 20.0;
        } else if (mealExternalDto.getStrCategory().equals("Breakfast")){
            return 11.0;
        } else if (mealExternalDto.getStrCategory().equals("Miscellaneous")){
            return 18.0;
        }else if (mealExternalDto.getStrCategory().equals("Pasta")){
            return 22.0;
        } else if (mealExternalDto.getStrCategory().equals("Vegan")){
            return 8.0;
        } else if (mealExternalDto.getStrCategory().equals("Vegetarian")){
            return 9.0;
        } else if(mealExternalDto.getStrCategory().equals("Goat")){
            return 25.0;
        } else if (mealExternalDto.getStrCategory().equals("Starter")){
            return 16.0;
        } else if (mealExternalDto.getStrCategory().equals("Side")){
            return 17.0;
        } return price;
    }
}
