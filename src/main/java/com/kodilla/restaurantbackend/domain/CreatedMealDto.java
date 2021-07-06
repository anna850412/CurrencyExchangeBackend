package com.kodilla.restaurantbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedMealDto {
    @JsonProperty("strName")
    private String mealName;
    @JsonProperty("strCategory")
    private String mealCategory;
    @JsonProperty("strArea")
    private String mealArea;
    @JsonProperty("strInstructions")
    private String mealInstructions;
    @JsonProperty("strYoutube")
    private String mealYoutube;
//    @JsonProperty("mealName")
//    private double mealPrice;
}
