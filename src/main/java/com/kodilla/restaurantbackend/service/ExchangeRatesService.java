package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.ExchangeRatesClient;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.repository.ExchangeRatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeRatesService {
    private final ExchangeRatesRepository exchangeRatesRepository;
    private final ExchangeRatesClient exchangeRatesClient;

    public List<ExchangeRatesLatest> getAllRates() {
        return exchangeRatesRepository.findAll();
    }
    public ExchangeRatesLatestDto getAllRatesDto() {
        return exchangeRatesClient.getExchangeRateLatest();
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

    public ExchangeRatesLatest saveLatestExchangeRate(final ExchangeRatesLatest exchangeRatesLatest) {
        return exchangeRatesRepository.save(exchangeRatesLatest);
    }
}
