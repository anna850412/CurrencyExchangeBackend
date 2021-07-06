package com.kodilla.restaurantbackend.scheduler;

import com.kodilla.restaurantbackend.config.AdminConfig;
import com.kodilla.restaurantbackend.controller.ExchangeRatesControllerDto;
import com.kodilla.restaurantbackend.domain.ExchangeRatesLatestDto;
import com.kodilla.restaurantbackend.domain.Mail;
import com.kodilla.restaurantbackend.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeRatesScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeRatesScheduler.class);
    private static final String DAILY_RATE = "Once a day email with new rate";
    private final SimpleEmailService simpleEmailService;
    private final ExchangeRatesControllerDto exchangeRatesControllerDto;
    private final AdminConfig adminConfig;

    @Scheduled(cron = "008***")
    public void sentNewRateEveryDay() {
        ExchangeRatesLatestDto rats = exchangeRatesControllerDto.getLatestExchangeRates();
        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        DAILY_RATE,
                        "Current rate for day" + " " + rats.getDate() + " " + "consists of: " + " " + "PLN" + rats.getRatesDto().getPln()
                                + " " + "USD" + rats.getRatesDto().getUsd() + " " + " GBP" + rats.getRatesDto().getGbp()
                )
        );
    }
}
