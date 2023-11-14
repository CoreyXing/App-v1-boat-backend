package com.ecust.appv1boatbackend.service;

import com.ecust.appv1boatbackend.Repository.FoodRepository;
import com.ecust.appv1boatbackend.model.pojo.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFoods() {
        return foodRepository.getAllFoods();
    }

    public Food getFoodById(int id) {
        return foodRepository.getFoodById(id);
    }

    public void createFood(Food food) {
        foodRepository.createFood(food);
    }

    public void updateFood(Food food) {
        foodRepository.updateFood(food);
    }

    public void deleteFood(int id) {
        foodRepository.deleteFood(id);
    }

    public List<Food> getFoodsByClass(String firstClass, String secondClass) {
        return foodRepository.getFoodsByClass(firstClass, secondClass);
    }
}
