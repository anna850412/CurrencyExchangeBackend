package com.kodilla.restaurantbackend.repository;

import com.kodilla.restaurantbackend.domain.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface CartRepository extends CrudRepository<Cart, Long> {

    @Override
    Cart save(Cart cart);

    List<Cart> findAll();
    @Override
    Optional<Cart> findById(Long cartId);
}
