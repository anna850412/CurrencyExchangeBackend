package com.kodilla.restaurantbackend.validator;

import com.kodilla.restaurantbackend.domain.Category;
import com.kodilla.restaurantbackend.domain.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MealValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(MealValidator.class);

    public List<Meal> validateMeal(final List<Meal> meals) {
        for(Meal meal: meals) {
            if (meal != null) {
                LOGGER.info("This meal is proper to be order");
            } else {
                LOGGER.info("Object Meal is null");
            }
        }
            return meals;
        }

    public List<Category> validateCategory(List<Category> categories) {
        if(categories != null){
            LOGGER.info("Proper category");
        } else {
            LOGGER.info("This category doesn't exist");
        } return categories;
    }
}
