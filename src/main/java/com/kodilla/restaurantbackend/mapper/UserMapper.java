package com.kodilla.restaurantbackend.mapper;

import com.kodilla.restaurantbackend.domain.User;
import com.kodilla.restaurantbackend.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto mapToUserDto(final User user){
    return new UserDto(
            user.getUsername(),
            user.getLogin(),
            user.getMail()
    );
    }
    public User mapToUser(final UserDto userDto){
        return new User(
                userDto.getUsername(),
                userDto.getLogin(),
                userDto.getMail()
        );
    }
    public List<UserDto> mapToUserDtoList(List<User> allUsers) {
        return allUsers.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
