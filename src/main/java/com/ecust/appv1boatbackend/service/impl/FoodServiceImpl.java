package com.ecust.appv1boatbackend.service.impl;

import com.ecust.appv1boatbackend.Repository.impl.FoodRepositoryImpl;
import com.ecust.appv1boatbackend.model.pojo.Food;
import com.ecust.appv1boatbackend.service.FoodService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {
    private final FoodRepositoryImpl foodRepository;

    public FoodServiceImpl(FoodRepositoryImpl foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFoods() {
        return foodRepository.getAllFoods();
    }

    public Food getFoodById(String id) {
        return foodRepository.getFoodById(id);
    }

    public List<Food> getFoodsByClass(String firstClass, String secondClass) {
        return foodRepository.getFoodsByClass(firstClass, secondClass);
    }

    public Set<String> getSecondClassByFirstClass(String firstClass){
        List<Food> foods = foodRepository.getFoodsByFirstClass(firstClass);
        return foods.stream().map(food -> food.getSecondClass()).collect(Collectors.toSet());
    }

    public Set<String> getAllFirstClass(){
        List<Food> foods = foodRepository.getAllFoods();
        return foods.stream().map(food -> food.getFirstClass()).collect(Collectors.toSet());
    }

    public List<Food> getFoodsByName(String name){
        return foodRepository.getFoodsByName(name);
    }


}
