package com.kodilla.restaurantbackend.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "RATES")
public class Rate {
    @Id
    @GeneratedValue
    @Column(name = "RATES_ID")
    private Long id;
    @Column(name = "PLN")
    private Double pln;
    @Column(name = "USD")
    private Double usd;
    @Column(name = "GBP")
    private Double gbp;
    //    @ManyToOne
//    @JoinColumn(name = "EXCHANGE_RATES_LATESTS_ID")
//    @NotNull
    @OneToOne(mappedBy = "rate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ExchangeRatesLatest exchangeRatesLatest;

    public Rate(Double pln, Double usd, Double gbp) {
        this.pln = pln;
        this.usd = usd;
        this.gbp = gbp;
    }
}
