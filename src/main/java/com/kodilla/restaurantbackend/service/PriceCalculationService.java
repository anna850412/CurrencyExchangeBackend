package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.exceptions.MealNotExistException;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Data
public class PriceCalculationService {
    private final MealClient mealClient;
    private long amount;

    public long calculateMealPrice(long price) {
        return mealClient.getMealsList().stream()
                .flatMap(meal -> mealClient.getMealsList().stream())
                .filter(mealExternalDto -> mealExternalDto.getStrCategory().equals("Dessert"))
                .count();
    }
}

