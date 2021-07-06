package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.config.AdminConfig;
import com.kodilla.restaurantbackend.domain.CreatedMealDto;
import com.kodilla.restaurantbackend.domain.Mail;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.MealDto;
import com.kodilla.restaurantbackend.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class MealService {
    private final static String SUBJECT = "New meal was added";
    private final MealRepository mealRepository;
    private final MealClient mealClient;
    private final TenDishesService tenDishesService;
    private final SimpleEmailService emailService;
    private final AdminConfig adminConfig;

    public List<Meal> findAllMeals() {
        return mealRepository.findAll();
    }

    public List<Meal> findAllClientsMeals() {
        return tenDishesService.get10Recipients();
    }

    public CreatedMealDto createMeal(MealDto mealDto) {
        CreatedMealDto newMeal = mealClient.createNewMeal(mealDto);
        ofNullable(newMeal).ifPresent(rate ->
                emailService.send(new Mail(adminConfig.getAdminMail(),
                        SUBJECT,
                        "New meal with name : " + mealDto.getStrMeal()
                                + "from category" + mealDto.getStrCategory()
                                + "and from country" + mealDto.getStrArea() +
                                "has been created"
                )));

        return newMeal;
    }

    public Meal saveMeal(final Meal meal) {
        return mealRepository.save(meal);
    }
}
