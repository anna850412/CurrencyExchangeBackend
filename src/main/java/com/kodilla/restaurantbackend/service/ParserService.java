package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.MenuParserClient;
import com.kodilla.restaurantbackend.config.AdminConfig;
import com.kodilla.restaurantbackend.domain.CreatedMenuParserDto;
import com.kodilla.restaurantbackend.domain.Mail;
import com.kodilla.restaurantbackend.domain.MenuParserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class ParserService {
    private static final String SUBJECT = "New product in your order";
    private final MenuParserClient menuParserClient;
    private final SimpleEmailService emailService;
    private final AdminConfig adminConfig;

    public List<MenuParserDto> fetchedMenus(){
        return menuParserClient.getMenus();
    }
    public CreatedMenuParserDto createdMenuParser(final CreatedMenuParserDto createdMenuParserDto) {
        CreatedMenuParserDto newMenu = menuParserClient.createNewMenuParserDto(createdMenuParserDto);
        ofNullable(newMenu).isPresent(
//                card ->
//                emailService.send(new Mail(adminConfig.getAdminMail(),
//                        SUBJECT,
//                        "New product: " + createdMenuParserDto.getName() + "has been created in your order"
//                        , null
//                ))
        );
        return newMenu;
    }
}

