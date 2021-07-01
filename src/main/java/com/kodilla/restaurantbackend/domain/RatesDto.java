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
    @JsonProperty("pln")
    private double pln;
    @JsonProperty("usd")
    private double usd;
    @JsonProperty("gbp")
    private double gbp;

}
