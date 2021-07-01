package com.kodilla.restaurantbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EXCHANGE_RATES_LATESTS")
        public class ExchangeRatesLatest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "EXCHANGE_RATE_LATESTS_ID")
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
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    private List<Rate> rateList;
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
