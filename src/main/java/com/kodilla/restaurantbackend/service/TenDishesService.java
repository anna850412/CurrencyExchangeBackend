package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.MealExternalDto;
import com.kodilla.restaurantbackend.domain.MealsDto;
import com.kodilla.restaurantbackend.mapper.MealMapper;
import com.kodilla.restaurantbackend.repository.MealRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class TenDishesService {
    @Autowired
    private final MealClient mealClient;
    @Autowired
    private final MealMapper mealMapper;
    @Autowired
    private final MealRepository mealRepository;

    public List<Meal> get10Recipients() {
        List<Meal> tenMeals = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            MealsDto randomMeals = mealClient.getRandomMeal();
            MealExternalDto mealExtDto = randomMeals.meals.get(0);
            Meal meal = mealMapper.mapFromMealExternalDtoToMeal(mealExtDto);
            mealRepository.save(meal);
            tenMeals.add(meal);
        }
        return tenMeals;
    }

    public List<String> getAllCategories() {

        List<String> categories = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            MealsDto randomMeals = mealClient.getRandomMeal();
            MealExternalDto mealExtDto = randomMeals.meals.get(0);
            String strCategory = mealExtDto.getStrCategory();
            categories.add(strCategory);
        }
        return categories;
    }

    public List<String> getNamesOfTodaysDishes() {

        List<String> names = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            MealsDto randomMeals = mealClient.getRandomMeal();
            MealExternalDto mealExtDto = randomMeals.meals.get(0);
            String strMeal = mealExtDto.getStrMeal();
            names.add(strMeal);
        }
        return names;
    }

    public List<String> getCountryNames() {
        List<String> countries = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            MealsDto randomMeal = mealClient.getRandomMeal();
            MealExternalDto mealExtDto = randomMeal.meals.get(0);
            String strCountry = mealExtDto.getStrArea();
            countries.add(strCountry);
        }
        return countries;
    }
}


