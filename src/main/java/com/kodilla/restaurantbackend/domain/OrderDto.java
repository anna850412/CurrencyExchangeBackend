package com.kodilla.restaurantbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
    private long id;
    private long userId;
}
