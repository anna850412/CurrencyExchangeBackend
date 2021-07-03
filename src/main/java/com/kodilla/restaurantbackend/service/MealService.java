package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.domain.*;
import com.kodilla.restaurantbackend.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;
    private final MealClient mealClient;

    public List<Meal> findAllMeals(){
        return mealRepository.findAll();
    }
    public List<MealExternalDto> getAllMeals() {
        return mealClient.getMealsList();
    }

    public List<CategoriesDto> getAllCategories() {
        return mealClient.getCategories();
    }

    public CreatedMealDto createMeal(MealDto mealDto) {
        CreatedMealDto newMeal = mealClient.createNewMeal(mealDto);
        return newMeal;
    }
}
