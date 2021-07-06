package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.domain.OrderDto;
import com.kodilla.restaurantbackend.mapper.OrderMapper;
import com.kodilla.restaurantbackend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {
//    private final OrderMapper orderMapper;
//    private final OrderService orderService;
//    @GetMapping(value = "/getAllOrders")
//    public List<OrderDto> getAllOrders(){
//        return orderMapper.mapToOrderDtoList(orderService.getAllOrders());
//    }

}
