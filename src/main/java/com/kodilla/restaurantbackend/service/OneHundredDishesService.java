package com.kodilla.restaurantbackend.service;

import com.kodilla.restaurantbackend.client.MealClient;
import com.kodilla.restaurantbackend.domain.MealDto;
import com.kodilla.restaurantbackend.domain.MealExternalDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class OneHundredDishesService {

    private final MealClient mealClient;

    public List<MealExternalDto> get100Recipients(){
        List<MealExternalDto> mealsList = mealClient.getMealsList();
        for (MealExternalDto recipient : mealsList){
            mealsList.add(recipient);
            System.out.println(recipient);
        } return mealsList;
    }


}
