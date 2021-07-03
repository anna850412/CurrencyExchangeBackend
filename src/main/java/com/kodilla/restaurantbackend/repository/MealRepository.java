package com.kodilla.restaurantbackend.repository;

import com.kodilla.restaurantbackend.domain.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {
    @Override
    public List<Meal> findAll();
    @Override
    public Optional<Meal> findById(Long mealId);
    @Override
    public Meal save(Meal meal);
    @Override
    public void deleteById(Long mealId);
}
