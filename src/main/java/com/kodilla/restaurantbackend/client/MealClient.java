package com.kodilla.restaurantbackend.client;

import com.kodilla.restaurantbackend.config.MealConfig;
import com.kodilla.restaurantbackend.domain.CategoriesDto;
import com.kodilla.restaurantbackend.domain.MealExternalDto;
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

    public List<MealExternalDto> getMealsList(){
        URI url = UriComponentsBuilder.fromHttpUrl(mealConfig.getMealEndPoint())
                .queryParam("apiKey", mealConfig.getMealAppKey())
                .queryParam("random", "/random.php")
                .encode().build().toUri();
        MealExternalDto[] mealResponse = restTemplate.getForObject(url, MealExternalDto[].class);
//        return getMealsList();
        return Optional.ofNullable(mealResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }
    public List<CategoriesDto> getCategories(){
        URI url = UriComponentsBuilder.fromHttpUrl(mealConfig.getMealEndPoint())
                .queryParam("apiKey", mealConfig.getMealAppKey())
                .queryParam("categories", "/categories.php")
                .encode().build().toUri();
        CategoriesDto[] categoriesResponse = restTemplate.getForObject(url, CategoriesDto[].class);
        return Optional.ofNullable(categoriesResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

}
