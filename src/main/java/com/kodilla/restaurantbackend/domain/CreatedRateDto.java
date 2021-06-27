package com.kodilla.restaurantbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedRateDto {
    @JsonProperty("PLN")
    private double pln;
    @JsonProperty("USD")
    private double usd;
    @JsonProperty("GBP")
    private double gbp;
}
