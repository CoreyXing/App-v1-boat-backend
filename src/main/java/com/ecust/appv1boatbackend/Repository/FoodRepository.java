package com.ecust.appv1boatbackend.Repository;

import com.ecust.appv1boatbackend.model.pojo.Food;

import java.util.List;

public interface FoodRepository {

    List<Food> getAllFoods();

    Food getFoodById(String id);

    List<Food> getFoodsByClass(String firstClass, String secondClass);

    List<Food> getFoodsByName(String name);

    List<String> getSecondClassByFirstClass(String firstClass);

    List<Food> getFoodsByFirstClass(String firstClass);

}
