package com.ecust.appv1boatbackend.Repository;

import com.ecust.appv1boatbackend.model.dto.Meal;

import java.util.List;

public interface MealRepository {

    void insertMeal(String id, String userId,
                    String dishesId, String date);

    List<Meal> queryMealByUserIdAndDate(String userId,String date);


}
