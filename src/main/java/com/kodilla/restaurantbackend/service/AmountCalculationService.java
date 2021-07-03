package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.ExchangeRatesClient;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class AmountCalculationService {
    private final ExchangeRatesClient exchangeRatesClient;
    private Double amount;

    public Double calculateAmountFromEURToUSD(Double amount) {
        return amount * exchangeRatesClient.getExchangeRateLatest().getRatesDto().getUsd();
    }

    public Double calculateAmountFromUSDToEUR(Double amount) {
        return amount / exchangeRatesClient.getExchangeRateLatest().getRatesDto().getUsd();
    }

    public Double calculateAmountFromEURToPLN(Double amount) {
        return amount * exchangeRatesClient.getExchangeRateLatest().getRatesDto().getPln();
    }

    public Double calculateAmountFromPLNToEUR(Double amount) {
        return amount / exchangeRatesClient.getExchangeRateLatest().getRatesDto().getPln();
    }

    public Double calculateAmountFromEURToGBP(Double amount) {
        return amount * exchangeRatesClient.getExchangeRateLatest().getRatesDto().getGbp();
    }

    public Double calculateAmountFromGBPToEUR(Double amount) {
        return amount / exchangeRatesClient.getExchangeRateLatest().getRatesDto().getGbp();
    }

}
