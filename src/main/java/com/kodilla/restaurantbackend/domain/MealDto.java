package com.kodilla.restaurantbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MealDto {
    @JsonProperty("NAME")
    public String strMeal;
    public String strDrinkAlternate;
    @JsonProperty("CATEGORY")
    public String strCategory;
    @JsonProperty("AREA")
    public String strArea;
    @JsonProperty("INSTRUCTION")
    public String strInstructions;
    public String strMealThumb;
    public String strTags;
    @JsonProperty("YOU_TUBE_PAGE")
    public String strYoutube;
    @JsonProperty("INGREDIENT1")
    public String strIngredient1;
    @JsonProperty("INGREDIENT2")
    public String strIngredient2;
    @JsonProperty("INGREDIENT3")
    public String strIngredient3;
    @JsonProperty("INGREDIENT4")
    public String strIngredient4;
    @JsonProperty("INGREDIENT5")
    public String strIngredient5;
    @JsonProperty("INGREDIENT6")
    public String strIngredient6;
    @JsonProperty("INGREDIENT7")
    public String strIngredient7;
    @JsonProperty("INGREDIENT8")
    public String strIngredient8;
    @JsonProperty("INGREDIENT9")
    public String strIngredient9;
    @JsonProperty("INGREDIENT10")
    public String strIngredient10;
    @JsonProperty("INGREDIENT11")
    public String strIngredient11;
    @JsonProperty("INGREDIENT12")
    public String strIngredient12;
    @JsonProperty("INGREDIENT13")
    public String strIngredient13;
    @JsonProperty("INGREDIENT14")
    public String strIngredient14;
    @JsonProperty("INGREDIENT15")
    public String strIngredient15;
    @JsonProperty("INGREDIENT16")
    public String strIngredient16;
    @JsonProperty("INGREDIENT17")
    public String strIngredient17;
    @JsonProperty("INGREDIENT18")
    public String strIngredient18;
    @JsonProperty("INGREDIENT19")
    public String strIngredient19;
    @JsonProperty("INGREDIENT20")
    public String strIngredient20;
}
