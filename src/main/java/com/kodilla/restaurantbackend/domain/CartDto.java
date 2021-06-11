package com.kodilla.restaurantbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {
    private Long cartId;
    private List<ProductDto> listOfProducts;

}
