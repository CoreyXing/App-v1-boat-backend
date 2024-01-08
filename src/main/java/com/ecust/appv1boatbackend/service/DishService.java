package com.ecust.appv1boatbackend.service;

import com.ecust.appv1boatbackend.model.pojo.Dish;
import com.ecust.appv1boatbackend.model.pojo.IngredientUnit;

import java.util.List;

public interface DishService {

    List<Dish> getDishByCode(String code);

    Dish getDishById(String id);

    List<Dish> getDishByKeyWord(String keyWord);

    IngredientUnit getMainUnitById(String id);


}
