package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.domain.*;
import com.kodilla.restaurantbackend.mapper.MealMapper;
import com.kodilla.restaurantbackend.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;
    private final MealClient mealClient;
    private final TenDishesService tenDishesService;

    public List<Meal> findAllMeals(){
        return mealRepository.findAll();
    }
    public List<Meal> findAllClientsMeals(){
        return tenDishesService.get10Recipients();
    }

    public List<CategoriesDto> getAllCategories() {
        return mealClient.getCategories();
    }

    public CreatedMealDto createMeal(MealDto mealDto) {
        CreatedMealDto newMeal = mealClient.createNewMeal(mealDto);
        return newMeal;
    }
}
