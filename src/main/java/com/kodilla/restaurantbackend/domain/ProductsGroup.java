package com.kodilla.restaurantbackend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "PRODUCTS_GROUPS")
public class ProductsGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "TYPE")
    private ProductType type;

    public ProductsGroup(String name) {
        this.type = type;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "productsGroup",
            fetch = FetchType.EAGER
    )
    private List<Product> products = new ArrayList<>();

    public ProductsGroup(long id, @NotNull ProductType type) {
        this.id = id;
        this.type = type;
    }
}
