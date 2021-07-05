package com.kodilla.restaurantbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "MEAL")
public class Meal {
    @Id
    @GeneratedValue
    @Column(name = "MEAL_ID")
    private Long id;
    @Column(name = "NAME")
    private String strMeal;
    @Column(name = "CATEGORY")
    private String strCategory;
    @Column(name = "AREA")
    private String strArea;
    @Column(name = "INSTRUCTION",  length = 2000, columnDefinition="TEXT")
    private String strInstructions;
    @Column(name = "YOU_TUBE_PAGE")
    private String strYoutube;
    @Column(name = "PRICE")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "ROOTS_ID")
    private Root root;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_MEAL_ORDER",
            joinColumns = {@JoinColumn(name = "MEAL_ID", referencedColumnName = "MEAL_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")}

    )
    private List<Order> orderList = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_CART_MEAL",
            joinColumns = {@JoinColumn(name = "MEAL_ID", referencedColumnName = "MEAL_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")}
    )
    private List<Cart> cartList = new ArrayList<>();

       public Meal(String strMeal, String strCategory, String strArea, String strInstructions, String strYoutube) {
           this.strMeal = strMeal;
           this.strCategory = strCategory;
           this.strArea = strArea;
           this.strInstructions = strInstructions;
           this.strYoutube = strYoutube;
    }
}
