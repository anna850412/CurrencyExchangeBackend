package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.domain.Order;
import com.kodilla.restaurantbackend.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public Order saveOrder(final Order order){
        return orderRepository.save(order);
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Optional<Order> findOrderById(final Long orderId){
        return orderRepository.findById(orderId);
    }
}
