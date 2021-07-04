package com.kodilla.restaurantbackend.mapper;

import com.kodilla.restaurantbackend.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MealMapper {
public Meal mapFromMealDtoToMeal(final MealDto mealDto){
return new Meal(
        mealDto.getStrMeal(),
        mealDto.getStrCategory(),
        mealDto.getStrArea(),
        mealDto.getStrInstructions(),
        mealDto.getStrYoutube()
);
}
public Meal mapFromMealExtrenalDtoToMeal(final MealExternalDto mealExternalDto){
    return new Meal(
            mealExternalDto.getStrMeal(),
            mealExternalDto.getStrCategory(),
            mealExternalDto.getStrArea(),
            mealExternalDto.getStrInstructions(),
            mealExternalDto.getStrYoutube()
    );
}
public List<MealExternalDto> mapToMealExtrenalDtoList(final List<Meal> mealList){
    return (List<MealExternalDto>) mealList.stream()
.map(meal -> new MealExternalDto(meal.getStrMeal(), meal.getStrCategory(), meal.getStrArea(), meal.getStrInstructions(), meal.getStrYoutube()))
.collect(Collectors.toList());
}
public List<Meal> mapToMealList (final List<MealExternalDto> mealExternalDtoList){
    return mealExternalDtoList.stream()
            .map(meal -> new Meal(meal.getStrMeal(), meal.getStrCategory(), meal.getStrArea(), meal.getStrInstructions(), meal.getStrYoutube()))
            .collect(Collectors.toList());
}

    public List<Category> mapToCategories(List<CategoriesDto> allCategories) {
    return allCategories.stream()
            .map(categoriesDto -> new Category(categoriesDto.getIdCategory(), categoriesDto.getStrCategory(), categoriesDto.getStrCategoryThumb(), categoriesDto.getStrCategoryDescription()))
            .collect(Collectors.toList());
    }

    public List<CategoriesDto> mapToCategoriesDtoList(List<Category> categories) {
    return categories.stream()
            .map(category -> new CategoriesDto(category.getIdCategory(), category.getStrCategory(), category.getStrCategoryThumb(), category.getStrCategoryDescription()))
            .collect(Collectors.toList());
    }

    public MealDto mapFromMealToMealDto(Meal meal) {
    return new MealDto(
            meal.getStrMeal(),
            meal.getStrCategory(),
            meal.getStrArea(),
            meal.getStrInstructions(),
            meal.getStrYoutube());
    }

    public List<MealDto> mapToMealDtoList(List<Meal> mealList) {
    return mealList.stream()
            .map(meal -> new MealDto(meal.getStrMeal(), meal.getStrArea(), meal.getStrCategory(), meal.getStrYoutube(), meal.getStrInstructions()))
            .collect(Collectors.toList());


    }
}
