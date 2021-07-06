package com.kodilla.restaurantbackend.mapper;

import com.kodilla.restaurantbackend.domain.User;
import com.kodilla.restaurantbackend.domain.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("User Mapper Test Suites")
public class UserMapperTestSuites {
    @InjectMocks
    private UserMapper userMapper;
    @Test
    void testMapToUser(){
        //Given
        UserDto userDto = new UserDto("name", "login", "mail");
        //When
        User mappedUser = userMapper.mapToUser(userDto);
        //Then
        assertEquals("name", mappedUser.getUsername());
    }
    @Test
    void testMapToUserDto(){
        //Given
        User user = new User("name", "login", "mail");
        //When
        UserDto mappedUser = userMapper.mapToUserDto(user);
        //Then
        assertEquals("name", mappedUser.getUsername());
    }
    @Test
    void testMapToUserDtoList(){
        //Given
        List<User> userList = new ArrayList<>();
        User user1 = new User("name1", "login1", "mail1");
        User user2 = new User("name2", "login2", "mail2");
        userList.add(user1);
        userList.add(user2);
        //When
        List<UserDto> mappedUserList = userMapper.mapToUserDtoList(userList);
        //Then
        assertEquals("name2",  mappedUserList.get(1).getUsername());
    }
}
