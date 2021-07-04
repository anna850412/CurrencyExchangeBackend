package com.kodilla.restaurantbackend.scheduler;

import com.kodilla.restaurantbackend.config.AdminConfig;
import com.kodilla.restaurantbackend.domain.Mail;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.Order;
import com.kodilla.restaurantbackend.domain.User;
import com.kodilla.restaurantbackend.service.SimpleEmailService;
import com.kodilla.restaurantbackend.service.TenDishesService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MealScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MealScheduler.class);
    private static final String DAILY_MENU = "Once a day email with new menu";
    private static final String ORDER = "Order summary";
    private final TenDishesService tenDishesService;
    private final SimpleEmailService simpleEmailService;
    private final Order order;
    private final AdminConfig adminConfig;
    private final User user;
    @Scheduled(cron = "008***")
    public void createNewMenuEveryDay(){
        List<Meal> mealList = tenDishesService.get10Recipients();
        simpleEmailService.send(
                new Mail(
                        adminConfig.getAdminMail(),
                        DAILY_MENU,
                        "Current menu for today consists of: " + mealList + "meals"
                )
        );
    }
    @Scheduled(fixedDelay = 10000)
    public void sendEmailWithOrderedMeals(){
        simpleEmailService.send(
                new Mail(
                        user.getEMail(),
                        ORDER,
                        "You have ordered below dished: " + order.getMealList()
                )
        );
    }
}
