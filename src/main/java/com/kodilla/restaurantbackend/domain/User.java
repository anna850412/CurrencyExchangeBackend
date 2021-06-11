package com.kodilla.restaurantbackend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID", unique = true)
    private Long id;
    @NotNull
    @Column(name = "USERNAME", unique = true)
    private String username;
    @NotNull
    @Column(name = "LOGIN", unique = true)
    private String login;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name ="CART_ID")
    private Cart cart;
    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> listOfOrders = new ArrayList<>();
}
