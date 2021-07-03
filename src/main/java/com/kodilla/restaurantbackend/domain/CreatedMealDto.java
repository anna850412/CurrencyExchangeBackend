package com.kodilla.restaurantbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedMealDto {
    @JsonProperty("mealName")
    private String mealName;
    @JsonProperty("mealCategory")
    private String mealCategory;
    @JsonProperty("mealArea")
    private String mealArea;
    @JsonProperty("mealInstructions")
    private String mealInstructions;
    @JsonProperty("mealYoutube")
    private String mealYoutube;
//    @JsonProperty("mealName")
//    private double mealPrice;
}
