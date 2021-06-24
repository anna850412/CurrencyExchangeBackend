package com.kodilla.restaurantbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RatesDto {
    @JsonProperty("PLN")
    private double pln;
    @JsonProperty("USD")
    private double usd;
    @JsonProperty("GBP")
    private double gbp;
}
