package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailCreatorService {
    @Autowired
    private AdminConfig adminConfig;
}
