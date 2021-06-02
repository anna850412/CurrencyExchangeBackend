package com.kodilla.restaurantbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long id;
    @NotNull
    @Column(name= "NAME")
    private String name;
    @NotNull
    @Column(name= "DESCRIPTION")
    private String description;
    @NotNull
    @Column(name= "PRICE")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name= "GROUP_ID")
    @NotNull
    private ProductsGroup productsGroup;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="JOIN_PRODUCT_CART",
            joinColumns = {@JoinColumn(name="PRODUCT_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "ID")}
    )
    private List<Cart> cartList = new ArrayList<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="JOIN_PRODUCT_ORDER",
            joinColumns = {@JoinColumn(name="PRODUCT_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")}
    )
    private List<Order> orderList = new ArrayList<>();

}

