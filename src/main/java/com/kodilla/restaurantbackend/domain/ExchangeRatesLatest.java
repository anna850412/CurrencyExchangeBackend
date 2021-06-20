package com.kodilla.restaurantbackend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@Entity(name = "EXCHANGE_RATES_LATESTS")
        public class ExchangeRatesLatest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @NotNull
    @Column(name = "BASE")
    private String base;
    @NotNull
    @Column(name = "DATE")
    private String date;
    @OneToMany(
            targetEntity = Rate.class,
            mappedBy = "exchangeRatesLatest",
            fetch = FetchType.EAGER
    )
    private List<Rate> symbols = new ArrayList<>();
}
