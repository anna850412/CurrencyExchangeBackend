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
    @Column(name = "INGREDIENT7")
    public String strIngredient7;
    @Column(name = "INGREDIENT8")
    public String strIngredient8;
    @Column(name = "INGREDIENT9")
    public String strIngredient9;
    @Column(name = "INGREDIENT10")
    public String strIngredient10;
    @Column(name = "INGREDIENT11")
    public String strIngredient11;
    @Column(name = "INGREDIENT12")
    public String strIngredient12;
    @Column(name = "INGREDIENT13")
    public String strIngredient13;
    @Column(name = "INGREDIENT14")
    public String strIngredient14;
    @Column(name = "INGREDIENT15")
    public String strIngredient15;
    @Column(name = "INGREDIENT16")
    public String strIngredient16;
    @Column(name = "INGREDIENT17")
    public String strIngredient17;
    @Column(name = "INGREDIENT18")
    public String strIngredient18;
    @Column(name = "INGREDIENT19")
    public String strIngredient19;
    @Column(name = "INGREDIENT20")
    public String strIngredient20;
}
