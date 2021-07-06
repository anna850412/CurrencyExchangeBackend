package com.kodilla.restaurantbackend.repository;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@DisplayName("Repository test suites")
public class RepositoryTestSuite {
    @Autowired
    private RatesRepository ratesRepository;
    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void testRatesRepositorySaveWithRates() {
        //Given
        Rate rate1 = new Rate(4.5, 1.8, 0.8);
        Rate rate2 = new Rate(4.6, 1.9, 0.9);
        //When
        ratesRepository.save(rate1);
        Long id1 = rate1.getId();
        ratesRepository.save(rate2);
        Long id2 = rate2.getId();
        //Then
        Assertions.assertNotEquals(0, id1);
        Assertions.assertNotEquals(0, id2);
        //Clean up
        ratesRepository.deleteById(id1);
        ratesRepository.deleteById(id2);
    }

    @Test
    void testMealRepositoryFindAll() {
        //Given
        Meal meal = new Meal("name", "category", "area", "instruction", "youTube");
        //When
        mealRepository.save(meal);
        //Then
        Long id = meal.getId();
        Optional<Meal> savedMeal = mealRepository.findById(id);
        Assertions.assertTrue(savedMeal.isPresent());
        //Clean up
        mealRepository.deleteById(id);
    }

    @Test
    void testMealRepositoryFindById() {
        //Given
        Meal meal = new Meal("name", "category", "area", "instruction", "youTube");
        //When
        mealRepository.save(meal);
        //Then
        Long id = meal.getId();
        Optional<Meal> savedMeal = mealRepository.findById(id);
        Assertions.assertTrue(savedMeal.isPresent());
        //Clean up
        mealRepository.deleteById(id);
    }

    @Test
    void testMealRepositorySaveMeal() {
        //Given
        Meal meal = new Meal("name", "category", "area", "instructions", "youTube");
        //When
        mealRepository.save(meal);
        Long id = meal.getId();
        //Then
        Assertions.assertNotEquals(0, id);
        //Clean up
        mealRepository.deleteById(id);
    }

    @Test
    void testMealRepositoryDeleteById() {
        //Given
        mealRepository.deleteAll();
        Meal meal = new Meal("name", "category", "area", "instructions", "youTube");
        //When
        mealRepository.save(meal);
        Long id = meal.getId();
        mealRepository.deleteById(id);
        //Then
        Assertions.assertEquals("name", meal.getStrMeal());

    }

    @Test
    void testExchangeRatesRepositorySaveExchangeRatesLatest() {
        //Given
        Rate rate = new Rate(4.5, 1.8, 1.0);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 123, "eur", "2021-07-03", rate);
        //When
        ratesRepository.save(rate);
        exchangeRatesRepository.save(exchangeRatesLatest);
        Long id = exchangeRatesLatest.getId();
        //Then
        Assertions.assertNotEquals(0, id);
        //Clean up
        exchangeRatesRepository.deleteById(id);

    }

    @Test
    void testExchangeRatesRepositoryFindAll() {
        //Given
        Rate rate = new Rate(4.5, 1.8, 1.0);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 123, "eur", "2021-07-03", rate);
        ratesRepository.save(rate);
        //When
        exchangeRatesRepository.save(exchangeRatesLatest);
        Long id = exchangeRatesLatest.getId();
        //Then
        List<ExchangeRatesLatest> savedExchange = exchangeRatesRepository.findAll();
        Assertions.assertEquals(1, savedExchange.size());
        //Clean up
        exchangeRatesRepository.deleteById(id);
    }

    @Test
    void testExchangeRatesRepositoryDeleteById() {
        //Given
        Rate rate = new Rate(4.5, 1.8, 1.0);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 123, "eur", "2021-07-03", rate);
        ratesRepository.save(rate);
        //When
        exchangeRatesRepository.save(exchangeRatesLatest);
        Long id = exchangeRatesLatest.getId();
        exchangeRatesRepository.deleteById(id);
        //Then
        Assertions.assertEquals("eur", exchangeRatesLatest.getBase());

    }
    @Test
    void testExchangeRatesRepositoryFindById() {
        //Given
        Rate rate = new Rate(4.5, 1.8, 1.0);
        ExchangeRatesLatest exchangeRatesLatest = new ExchangeRatesLatest(true, 123, "eur", "2021-07-03", rate);
        ratesRepository.save(rate);
        //When
        exchangeRatesRepository.save(exchangeRatesLatest);
                //Then
        Long id = exchangeRatesLatest.getId();
        Optional<ExchangeRatesLatest> savedExchange = exchangeRatesRepository.findById(id);
        Assertions.assertTrue(savedExchange.isPresent());
        //Clean up
        exchangeRatesRepository.deleteById(id);
    }
    @Test
    void testUserRepositoryFindAll() {
        //Given
        User user = new User("name", "login", "mail");
        //When
        userRepository.save(user);
        //Then
        Long id = user.getId();
        Optional<User> savedUser = userRepository.findById(id);
        Assertions.assertTrue(savedUser.isPresent());
        //Clean up
        userRepository.deleteById(id);
    }
    @Test
    void testUserRepositorySaveUser() {
        //Given
        User user = new User("name", "login", "mail");
        //When
        userRepository.save(user);
        Long id = user.getId();
        //Then
        Assertions.assertNotEquals(0, id);
        //Clean up
        userRepository.deleteById(id);
    }

    @AfterEach
    void cleanUp() {
        ratesRepository.deleteAll();
        exchangeRatesRepository.deleteAll();
        mealRepository.deleteAll();
        userRepository.deleteAll();
    }
}
