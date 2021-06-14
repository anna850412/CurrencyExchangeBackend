package com.kodilla.restaurantbackend.client;

import com.kodilla.restaurantbackend.domain.CreatedMenuParserDto;
import com.kodilla.restaurantbackend.domain.MenuParserDto;
import lombok.RequiredArgsConstructor;
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
public class MenuParserClient {
    private final RestTemplate restTemplate;

    public List<MenuParserDto> getMenus(){
//        MenuParserDto[] menuResponse = restTemplate.getForObject(
//                "https://https://menuparser.com/",
//                MenuParserDto[].class
//        );
        URI url = UriComponentsBuilder.fromHttpUrl("https://https://menuparser.com/")
                .queryParam("fields", "name, amount, currency")
                .build().encode().toUri();
        MenuParserDto[] menuResponse = restTemplate.getForObject(url, MenuParserDto[].class);
        if(menuResponse != null){
            return Arrays.asList(menuResponse);
        }
        return Optional.ofNullable(menuResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }
    public CreatedMenuParserDto createNewMenuParserDto(CreatedMenuParserDto createdMenuParserDto){
        URI url = UriComponentsBuilder.fromHttpUrl("https://https://menuparser.com/")
                .queryParam("name", createdMenuParserDto.getName())
                .queryParam("desc", createdMenuParserDto.getDescription())
                .build()
                .encode()
                .toUri();
        return restTemplate.postForObject(url, null, CreatedMenuParserDto.class);
    }
}
