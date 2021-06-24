package com.kodilla.restaurantbackend.repository;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExchangeRatesRepository extends CrudRepository<ExchangeRatesLatest, Long> {
    @Override
    List<ExchangeRatesLatest> findAll();

    ExchangeRatesLatest findByBase(String base);

    ExchangeRatesLatest findByDate(String date);

    @Override
    Optional<ExchangeRatesLatest> findById(Long latestId);

    @Override
    void deleteById(Long latestId);

    @Override
    ExchangeRatesLatest save(ExchangeRatesLatest exchangeRatesLatest);
}
