package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.domain.Cart;
import com.kodilla.restaurantbackend.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    public Cart saveCart(Cart cart){
        return cartRepository.save(cart);
    }
    public List<Cart> findAllCarts(){
        return cartRepository.findAll();
    }
    Optional<Cart> findCartById(Long cartId){
        return cartRepository.findById(cartId);
    }
}
