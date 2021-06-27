package com.kodilla.restaurantbackend.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "MEALS")
public class Meal {
    @Id
    @GeneratedValue
    @Column(name = "MEALS_ID")
    private Long id;
    public String idMeal;
    @Column(name = "NAME")
    public String strMeal;
    public String strDrinkAlternate;
    @Column(name = "CATEGORY")
    public String strCategory;
    @Column(name = "AREA")
    public String strArea;
    @Column(name = "INSTRUCTION")
    public String strInstructions;
    public String strMealThumb;
    public String strTags;
    @Column(name = "YOU_TUBE_PAGE")
    public String strYoutube;
    @Column(name = "INGREDIENT1")
    public String strIngredient1;
    @Column(name = "INGREDIENT2")
    public String strIngredient2;
    @Column(name = "INGREDIENT3")
    public String strIngredient3;
    @Column(name = "INGREDIENT4")
    public String strIngredient4;
    @Column(name = "INGREDIENT5")
    public String strIngredient5;
    @Column(name = "INGREDIENT6")
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
    public String strMeasure1;
    public String strMeasure2;
    public String strMeasure3;
    public String strMeasure4;
    public String strMeasure5;
    public String strMeasure6;
    public String strMeasure7;
    public String strMeasure8;
    public String strMeasure9;
    public String strMeasure10;
    public String strMeasure11;
    public String strMeasure12;
    public String strMeasure13;
    public String strMeasure14;
    public String strMeasure15;
    public String strMeasure16;
    public String strMeasure17;
    public String strMeasure18;
    public String strMeasure19;
    public String strMeasure20;
    public String strSource;
    public String strImageSource;
    public String strCreativeCommonsConfirmed;
    public String dateModified;
    @ManyToOne
    @JoinColumn(name = "ROOTS_ID")
    private Root root;
}
