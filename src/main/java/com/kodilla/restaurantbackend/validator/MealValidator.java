package com.kodilla.restaurantbackend.validator;

import com.kodilla.restaurantbackend.domain.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MealValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(MealValidator.class);

    public void validateMeal(final Meal meal) {
        if (meal != null) {
            LOGGER.info("This meal is proper to be order");
        } else {
            LOGGER.info("Object Meal is null");
        }

    }

    public List<Meal> validateMealList(final List<Meal> meals) {
        for (Meal meal : meals) {
            if (meal != null) {
                LOGGER.info("This meal list is proper to be order");
            } else {
                LOGGER.info("Object Meal list is null");
            }
        }
        return meals;
    }

}
