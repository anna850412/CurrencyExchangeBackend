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
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID", unique = true)
    private Long id;
    @Column(name = "USERNAME", unique = true)
    private String username;
    @Column(name = "LOGIN", unique = true)
    private String login;
    @Column(name = "EMAIL")
    private String mail;
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

    public User(String username, String login, String mail) {
        this.username = username;
        this.login = login;
        this.mail = mail;
    }
}
