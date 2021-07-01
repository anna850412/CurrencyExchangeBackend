package com.kodilla.restaurantbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesDto {
    @JsonProperty("idCategory")
    public String idCategory;
    @JsonProperty("strCategory")
    public String strCategory;
    @JsonProperty("strCategoryThumb")
    public String strCategoryThumb;
    @JsonProperty("strCategoryDescription")
    public String strCategoryDescription;
}
