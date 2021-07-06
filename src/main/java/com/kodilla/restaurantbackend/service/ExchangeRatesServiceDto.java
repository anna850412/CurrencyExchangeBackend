package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.ExchangeRatesClient;
import com.kodilla.restaurantbackend.config.AdminConfig;
import com.kodilla.restaurantbackend.domain.CreatedRateDto;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.Mail;
import com.kodilla.restaurantbackend.domain.RatesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class ExchangeRatesServiceDto {
    private final static String SUBJECT = "New exchange Rate";
    private final ExchangeRatesClient exchangeRatesClient;
    private final SimpleEmailService emailService;
    private final AdminConfig adminConfig;

    public ExchangeRatesLatestDto getAllRatesDto() {
        return exchangeRatesClient.getExchangeRateLatest();
    }
    public CreatedRateDto createRate(final RatesDto ratesDto) {
        CreatedRateDto newRate = exchangeRatesClient.createNewRate(ratesDto);
        ofNullable(newRate).ifPresent(rate ->
                emailService.send(new Mail(adminConfig.getAdminMail(),
                        SUBJECT,
                        "New rate, which contains: " + " " + "PLN " +  " " + ratesDto.getPln()
                                + " " + "USD" + " " + ratesDto.getUsd()
                                + " " + "GBP" + " " + ratesDto.getGbp() + " " +
                                "has been created"
                )));
        return newRate;
        }
    }

