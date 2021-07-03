package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.domain.*;
import com.kodilla.restaurantbackend.exceptions.MealNotExistException;
import com.kodilla.restaurantbackend.fasade.MealFacade;
import com.kodilla.restaurantbackend.mapper.MealMapper;
import com.kodilla.restaurantbackend.service.MealService;
import com.kodilla.restaurantbackend.service.OneHundredDishesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/v1/meal")
@RequiredArgsConstructor
public class MealController {
    private final MealService mealService;
    private final MealFacade mealFacade;
    private final MealClient mealClient;
    private final MealMapper mealMapper;
    private final OneHundredDishesService oneHundredDishesService;

    @GetMapping(value = "/get100")
    public List<MealExternalDto> get100Meals(){
        return oneHundredDishesService.get100Recipients();
    }
    @GetMapping(value = "/getAllMeals")
    public List<MealDto> getAllMeals(){
    return mealMapper.mapToMealDtoList(mealService.findAllMeals());
    }
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
    @PostMapping(value = "/createMeal", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CreatedMealDto createMeal(@RequestBody MealDto mealDto) throws MealNotExistException {
               return mealFacade.createMeal(mealDto);

    }


}
