package com.kodilla.restaurantbackend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID", unique = true)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @NotNull
    @Column(name = "ORDER_DATE")
    private LocalDateTime orderDate;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "orderList")

//    private List<Product> productList = new ArrayList<>();
    private List<Meal> mealList = new ArrayList<>();

    public Order(User user, LocalDateTime orderDate, List<Meal> mealList) {
        this.user = user;
        this.orderDate = orderDate;
//      this.productList = productList;
        this.mealList = mealList;
    }

    public Order(User user, LocalDateTime orderDate) {
        this.user = user;
        this.orderDate = orderDate;
    }
    public Order(User user) {
        this.user = user;
    }
}
