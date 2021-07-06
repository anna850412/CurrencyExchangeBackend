package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.domain.User;
import com.kodilla.restaurantbackend.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("User Service Test Suites")
public class UserServiceTestSuite {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    @Test
    void testUserServiceWithSaveUser(){
        //Given
        User user = new User("name", "login", "mail" );
        //When
        userService.saveUser(user);
        //Then
        verify(userRepository, times (1)).save(user);
    }
    @Test
    void testUserServiceFindAllUsers(){
        //Given
        List<User> userList = new ArrayList<>();
        User user1 = new User("name1", "login1", "mail1" );
        User user2 = new User("name2", "login2", "mail2" );
        userList.add(user1);
        userList.add(user2);
        when(userService.findAllUsers()).thenReturn(userList);
        //When
        userList = userService.findAllUsers();
        //Then
        verify(userRepository, times(1)).findAll();
    }
}
