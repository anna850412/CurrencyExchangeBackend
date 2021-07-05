package com.kodilla.restaurantbackend.repository;

import com.kodilla.restaurantbackend.domain.ExchangeRatesLatest;
import com.kodilla.restaurantbackend.domain.Meal;
import com.kodilla.restaurantbackend.domain.Rate;
import com.kodilla.restaurantbackend.domain.Root;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
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
//        List<Meal> savedMeal = mealRepository.findAll();
//        Assertions.assertEquals(1,savedMeal.size());
//        Assertions.assertEquals("area", meal.getStrArea());
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
//        Assertions.assertEquals("name", meal.getStrMeal());
        //Clean up
        mealRepository.deleteById(id);
    }

    @Test
    void testMealRepositoryDeleteById() {
        //Given
        mealRepository.deleteAll();
//        Root root = new Root();
        Meal meal = new Meal("name", "category", "area", "instructions", "youTube");
        //When
//        meal.setRoot(root);
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

    @AfterEach
    void cleanUp(){
        ratesRepository.deleteAll();
        exchangeRatesRepository.deleteAll();
        mealRepository.deleteAll();
    }
}
