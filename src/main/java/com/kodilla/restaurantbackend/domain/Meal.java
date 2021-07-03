package com.kodilla.restaurantbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "MEALS")
public class Meal {
    @Id
    @GeneratedValue
    @Column(name = "MEALS_ID")
    private Long id;
    @Column(name = "NAME")
    private String strMeal;
    @Column(name = "CATEGORY")
    private String strCategory;
    @Column(name = "AREA")
    private String strArea;
    @Column(name = "INSTRUCTION")
    private String strInstructions;
    @Column(name = "YOU_TUBE_PAGE")
    private String strYoutube;
    @Column(name = "PRICE")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "ROOTS_ID")
    private Root root;

    public Meal(String strMeal, String strCategory, String strArea, String strInstructions, String strYoutube, double price) {
    }

    public Meal(String strMeal, String strCategory, String strArea, String strInstructions, String strYoutube) {
    }
}
