package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.client.MenuParserClient;
import com.kodilla.restaurantbackend.domain.MenuParserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/menuParser")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MenuParserController {
    @Autowired
    private MenuParserClient menuParserClient;
    @GetMapping("getMenus")
    public List<MenuParserDto> getMenus() {
        List<MenuParserDto> parserMenus = menuParserClient.getMenus();
        parserMenus.forEach(menuParserDto -> {
            System.out.println("product name" + menuParserDto.getItems());
//                    + "amount" + menuParserDto.getAmount()
//                    + "in currency" + menuParserDto.getCurrency());
        });
        return parserMenus;
    }

}
