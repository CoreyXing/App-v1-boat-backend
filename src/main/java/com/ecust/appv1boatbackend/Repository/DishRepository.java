package com.ecust.appv1boatbackend.Repository;

import com.ecust.appv1boatbackend.model.pojo.Dish;
import com.ecust.appv1boatbackend.model.pojo.IngredientUnit;

import java.util.List;

public interface DishRepository {
    List<Dish> getDishByCode(String code);

    Dish getDishById(String id);

    String getDishNameById(String id);

    List<Dish> getDishByKeyWords(String keyWord);

    String getMainUnitById(String id);
}
