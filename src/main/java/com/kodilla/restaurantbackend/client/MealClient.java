package com.kodilla.restaurantbackend.client;

import com.kodilla.restaurantbackend.config.MealConfig;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.MealDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MealClient {
    private final MealConfig mealConfig;
    private final RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(MealClient.class);

    public List<MealDto> getMealsList(){
        URI url = UriComponentsBuilder.fromHttpUrl(mealConfig.getMealEndPoint())
                .queryParam("apiKey", mealConfig.getMealAppKey())
                .queryParam("random", "random.php")
                .encode().build().toUri();
        MealDto[] mealResponse = restTemplate.getForObject(url, MealDto[].class);
//        return getMealsList();
        return Optional.ofNullable(mealResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

}
