package com.kodilla.restaurantbackend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "RATES")
public class Rate {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
//    private Long rate;
    @Column(name = "PLN")
    private Double pln;
    @Column(name = "USD")
    private Double usd;
    @Column(name = "GBP")
    private Double gbp;
    @ManyToOne
    @JoinColumn(name = "EXCHANGE_RATES_LATESTS_ID")
    @NotNull
    private ExchangeRatesLatest exchangeRatesLatest;

    public Rate(Double pln, Double usd, Double gbp) {
        this.pln = pln;
        this.usd = usd;
        this.gbp = gbp;
    }
}
