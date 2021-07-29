package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.repository.RatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatesService {
    private final RatesRepository ratesRepository;
    public Rate saveRates(Rate rate) {
        return ratesRepository.save(rate);
    }
}
