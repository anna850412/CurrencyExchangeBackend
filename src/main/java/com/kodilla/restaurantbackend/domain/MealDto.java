package com.kodilla.restaurantbackend.domain;

import lombok.Getter;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MealDto {
    private Long id;
    private Long clientIdMeal;
    private String strMeal;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strYoutube;


    public MealDto(String strMeal, String strCategory, String strArea, String strInstructions, String strYoutube) {
        this.strMeal = strMeal;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strYoutube = strYoutube;
    }

}
