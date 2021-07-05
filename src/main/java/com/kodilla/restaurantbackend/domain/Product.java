package com.kodilla.restaurantbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", unique = true)
    private Long id;
    @NotNull
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @NotNull
    @Column(name = "PRICE")
    private Long price;
    @NotNull
    @Column(name = "QUANTITY")
    private Long quantity;
    @NotNull
    @Column(name = "AVAILABLE")
    private boolean available;
    //    @ManyToOne
//    @JoinColumn(name = "PRODUCT_TYPE")
//    @NotNull
//    private ProductType type;
    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    @NotNull
    private ProductsGroup productsGroup;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "JOIN_CART_PRODUCT",
//            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")}
//    )
//    private List<Cart> cartList = new ArrayList<>();
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "JOIN_PRODUCT_ORDER",
//            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")}
//
//    )
//    @ManyToMany(mappedBy = "productList")
//    private List<Order> orderList = new ArrayList<>();

}

