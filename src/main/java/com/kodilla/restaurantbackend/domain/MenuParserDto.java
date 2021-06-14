package com.kodilla.restaurantbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuParserDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("currency")
    private String currency;
}
