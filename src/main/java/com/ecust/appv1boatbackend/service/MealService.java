package com.ecust.appv1boatbackend.service;

import com.ecust.appv1boatbackend.model.dto.Meal;
import com.ecust.appv1boatbackend.model.pojo.Ingredient;

import java.util.List;

public interface MealService {
    void receiveMeal(Meal meal);


    Ingredient getIngredientByUserIdAndDate(String userId,String date);



}
