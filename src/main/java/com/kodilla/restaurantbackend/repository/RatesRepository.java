package com.kodilla.restaurantbackend.repository;

import com.kodilla.restaurantbackend.domain.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatesRepository extends CrudRepository<Rate, Long> {
    @Override
    Rate save(Rate rate);

}
