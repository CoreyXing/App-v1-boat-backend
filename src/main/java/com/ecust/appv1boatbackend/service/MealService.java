package com.ecust.appv1boatbackend.service;

import com.ecust.appv1boatbackend.model.dto.IngredientAndNutrientyDTO;
import com.ecust.appv1boatbackend.model.dto.MealInfoDTO;
import com.ecust.appv1boatbackend.model.pojo.Meal;
import com.ecust.appv1boatbackend.model.pojo.Ingredient;

import java.util.List;

public interface MealService {

    IngredientAndNutrientyDTO receiveMeal(Meal meal);


    IngredientAndNutrientyDTO getIngredientAndNutrientyUserIdAndDate(String userId, String date);





    List<Meal> queryMealInfo(String userId, String date);
}
