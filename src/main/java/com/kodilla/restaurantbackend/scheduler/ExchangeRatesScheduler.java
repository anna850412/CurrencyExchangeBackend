package com.kodilla.restaurantbackend.scheduler;

import com.kodilla.restaurantbackend.client.ExchangeRatesClient;
import com.kodilla.restaurantbackend.config.AdminConfig;
import com.kodilla.restaurantbackend.controller.ExchangeRatesControllerDto;
import com.kodilla.restaurantbackend.domain.CreatedRateDto;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.Mail;
import com.kodilla.restaurantbackend.domain.RatesDto;
import com.kodilla.restaurantbackend.mapper.ExchangeRatesMapper;
import com.kodilla.restaurantbackend.repository.ExchangeRatesRepository;
import com.kodilla.restaurantbackend.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class ExchangeRatesScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRatesScheduler.class);
    private static final String DAILY_RATE = "Once a day email with new rate";
    private final SimpleEmailService simpleEmailService;
    private final ExchangeRatesControllerDto exchangeRatesControllerDto;
    private final AdminConfig adminConfig;
    private final ExchangeRatesClient exchangeRatesClient;
    private final ExchangeRatesRepository exchangeRatesRepository;
    private final ExchangeRatesMapper exchangeRatesMapper;

    @Scheduled(cron = "0 0 8 * * *")
    public void sentNewRateEveryDay() {
        LOGGER.info("Scheduler is working");

        List<ExchangeRatesLatest> all = exchangeRatesRepository.findAll();
        if (all.isEmpty()) {
            LOGGER.info("There are no rates available in database");
        } else {
            ExchangeRatesLatest rates = all.get(all.size() - 1);
            exchangeRatesControllerDto.getLatestExchangeRates();

                    simpleEmailService.send(
                            new Mail(
                                    adminConfig.getAdminMail(),
                                    DAILY_RATE,
                                    "Current rate for today consists of: " + " " + "PLN" + rates.getRate().getPln()
                                            + " " + "USD" + rates.getRate().getUsd() + " " + " GBP" + rates.getRate().getGbp()
                            ));


        }
    }
}

