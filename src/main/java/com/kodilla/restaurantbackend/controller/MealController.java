package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.domain.CategoriesDto;
import com.kodilla.restaurantbackend.domain.MealExternalDto;
import com.kodilla.restaurantbackend.fasade.MealFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/meal")
@RequiredArgsConstructor
public class MealController {
    private final MealFacade mealFacade;
    private final MealClient mealClient;

    @GetMapping(value = "/getMeals")
    public  List<MealExternalDto> getMeals(){
        List<MealExternalDto> mealsList = mealClient.getMealsList();
        mealsList.forEach(mealExternalDto ->
                System.out.println("category: " + mealExternalDto.getStrCategory() +
                        "name: " + mealExternalDto.getStrMeal()));
        return mealFacade.getAllMeals();
    }
    @GetMapping(value = "/getCategories")
    public List<CategoriesDto> getCategory() {
        List<CategoriesDto> categoriesList = mealClient.getCategories();
        categoriesList.
                forEach(categoriesDto ->
                        System.out.println("category: " + categoriesDto.getStrCategory() +
                                "description: " + categoriesDto.getStrCategoryDescription()));
        return mealFacade.getAllCategories();
    }


}
