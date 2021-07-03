package com.kodilla.restaurantbackend.fasade;

import com.kodilla.restaurantbackend.domain.CategoriesDto;
import com.kodilla.restaurantbackend.domain.Category;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.MealExternalDto;
import com.kodilla.restaurantbackend.mapper.MealMapper;
import com.kodilla.restaurantbackend.service.MealService;
import com.kodilla.restaurantbackend.validator.MealValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MealFacade {
    @Autowired
    private MealService mealService;
    @Autowired
    private MealMapper mealMapper;
    @Autowired
    private MealValidator mealValidator;

    public List<MealExternalDto> getAllMeals() {
        List<Meal> meals =  mealMapper.mapToMealList(mealService.getAllMeals());
        List<Meal> filteredMeals = mealValidator.validateMeal(meals);
        return mealMapper.mapToMealExtrenalDtoList(filteredMeals);
    }
    public List<CategoriesDto> getAllCategories(){
        List<Category> categories = mealMapper.mapToCategories(mealService.getAllCategories());
        List<Category> filteredCategories = mealValidator.validateCategory(categories);
        return mealMapper.mapToCategoriesDtoList(filteredCategories);
    }

}
