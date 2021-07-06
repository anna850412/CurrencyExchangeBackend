package com.kodilla.restaurantbackend.controller;

import com.kodilla.restaurantbackend.domain.User;
import com.kodilla.restaurantbackend.domain.UserDto;
import com.kodilla.restaurantbackend.exceptions.UserNotExistException;
import com.kodilla.restaurantbackend.mapper.UserMapper;
import com.kodilla.restaurantbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping(value = "/getAllUsers")
    public List<UserDto> getAllUsers() {
        return userMapper.mapToUserDtoList(userService.findAllUsers());
    }

    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) throws UserNotExistException {
        User user = userMapper.mapToUser(userDto);
        userService.saveUser(user);
    }
}
