package com.kodilla.restaurantbackend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EXCHANGE_RATES_LATESTS")
        public class ExchangeRatesLatest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @NotNull
    @Column(name = "SUCCESS")
    private boolean success;
    @NotNull
    @Column(name = "TIMESTAMP")
    private int timestamp;
    @NotNull
    @Column(name = "BASE")
    private String base;
    @NotNull
    @Column(name = "DATE")
    private String date;
//    @OneToMany(
//            targetEntity = Rate.class,
//            mappedBy = "exchangeRatesLatest",
//            fetch = FetchType.EAGER
//    )
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RATES_ID")
    private Rate rate;

    public ExchangeRatesLatest(@NotNull boolean success, @NotNull int timestamp, @NotNull String base, @NotNull String date, Rate rate) {
        this.success = success;
        this.timestamp = timestamp;
        this.base = base;
        this.date = date;
        this.rate = rate;
    }
}
