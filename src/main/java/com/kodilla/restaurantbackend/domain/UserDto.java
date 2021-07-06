package com.kodilla.restaurantbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String login;
    private String mail;

    public UserDto(String username, String login, String mail) {
        this.username = username;
        this.login = login;
        this.mail = mail;
    }
}
