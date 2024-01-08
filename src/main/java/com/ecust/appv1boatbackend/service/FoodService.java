package com.ecust.appv1boatbackend.service;

import com.ecust.appv1boatbackend.model.pojo.Food;

import java.util.List;
import java.util.Set;

public interface FoodService {
     List<Food> getAllFoods();


     Food getFoodById(String id);


    List<Food> getFoodsByClass(String firstClass, String secondClass);


    Set<String> getSecondClassByFirstClass(String firstClass);


    Set<String> getAllFirstClass();


    List<Food> getFoodsByName(String name);





}
