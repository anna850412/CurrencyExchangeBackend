package com.kodilla.restaurantbackend.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="CARTS")
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "CART_ID", unique = true)
    private Long cartId;
    @OneToOne(mappedBy = "cart", fetch = FetchType.LAZY)
    private User user;
    @ManyToMany(mappedBy = "cartList", fetch = FetchType.LAZY)
//    private List<Product> listOfProducts = new ArrayList<>();
    private List<Meal> mealList = new ArrayList<>();
    public Cart(User user) {
        this.user = user;
    }
}
