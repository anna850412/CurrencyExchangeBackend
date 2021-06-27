package com.kodilla.restaurantbackend.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "ROOTS")
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOTS_ID")
    private Long id;
    @OneToMany(
            targetEntity = Meal.class,
            mappedBy = "root",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Meal> meals;
}
