package com.ecust.appv1boatbackend.Repository;

import com.ecust.appv1boatbackend.model.pojo.Dish;

import java.util.List;

public interface DishRepository {
    List<Dish> getDishByCode(String code);

    Dish getDishById(String id);

    List<Dish> getDishByKeyWords(String keyWord);
}
