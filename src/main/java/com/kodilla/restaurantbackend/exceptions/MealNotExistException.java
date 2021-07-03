package com.kodilla.restaurantbackend.exceptions;

public class MealNotExistException extends Exception{
public MealNotExistException(final String message){
    super(message);
}
}
