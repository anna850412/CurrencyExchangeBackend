package com.kodilla.restaurantbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
@Component
public class PriceCalculator {

    public static Double calculatePrice(Double price, String category){
        if(category.equals("Dessert")){
            return 10.0;
        } else if (category.equals("Chicken")){
            return 12.0;
        } else if (category.equals("Lamb")){
            return 13.0;
        } else if (category.equals("Pork")){
            return 14.0;
        } else if(category.equals("Beef")){
            return 15.0;
        } else if (category.equals("Seafood")){
            return 20.0;
        } else if (category.equals("Breakfast")){
            return 11.0;
        } else if (category.equals("Miscellaneous")){
            return 18.0;
        }else if (category.equals("Pasta")){
            return 22.0;
        } else if (category.equals("Vegan")){
            return 8.0;
        } else if (category.equals("Vegetarian")){
            return 9.0;
        } else if(category.equals("Goat")){
            return 25.0;
        } else if (category.equals("Starter")){
            return 16.0;
        } else if (category.equals("Side")){
            return 17.0;
        } return price;
    }
}
