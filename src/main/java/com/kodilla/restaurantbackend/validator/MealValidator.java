package com.kodilla.restaurantbackend.validator;

import com.kodilla.restaurantbackend.domain.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
}
