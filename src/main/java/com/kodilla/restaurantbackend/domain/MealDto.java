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
    private String mealName;
    private String mealCategory;
    private String mealArea;
    private String mealInstructions;
    private String mealYoutube;
    private double mealPrice;

    public MealDto(String mealName, String mealCategory, String mealArea, String mealInstructions, String mealYoutube) {
        this.mealName = mealName;
        this.mealCategory = mealCategory;
        this.mealArea = mealArea;
        this.mealInstructions = mealInstructions;
        this.mealYoutube = mealYoutube;
    }

    public MealDto(String mealName, String mealCategory, String mealArea, String mealInstructions, String mealYoutube, double mealPrice) {
        this.mealName = mealName;
        this.mealCategory = mealCategory;
        this.mealArea = mealArea;
        this.mealInstructions = mealInstructions;
        this.mealYoutube = mealYoutube;
        this.mealPrice = mealPrice;
    }
}
