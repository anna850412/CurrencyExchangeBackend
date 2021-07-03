package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.repository.ExchangeRatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeRatesService {
    private final ExchangeRatesRepository exchangeRatesRepository;


    public List<ExchangeRatesLatest> getAllRates() {
        return exchangeRatesRepository.findAll();
    }

    public ExchangeRatesLatest getBaseRate(final String base) {
        return exchangeRatesRepository.findByBase(base);
    }

    public ExchangeRatesLatest getDate(final String date) {
        return exchangeRatesRepository.findByDate(date);
    }

    public Optional<ExchangeRatesLatest> findLatestRateById(final Long latestId) {
        return exchangeRatesRepository.findById(latestId);
    }

    public void deleteExchangeRatesById(final Long latestId) {
        exchangeRatesRepository.deleteById(latestId);
    }

    public ExchangeRatesLatest saveLatestExchangeRate(ExchangeRatesLatest exchangeRatesLatest) {
        return exchangeRatesRepository.save(exchangeRatesLatest);
    }

}
